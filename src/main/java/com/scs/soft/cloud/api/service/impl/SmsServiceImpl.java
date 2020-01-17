package com.scs.soft.cloud.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.common.ResultCode;
import com.scs.soft.cloud.api.domain.dto.SignDto;
import com.scs.soft.cloud.api.service.RedisService;
import com.scs.soft.cloud.api.service.SmsService;
import com.scs.soft.cloud.api.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;



/**
 * @author Tao
 */
@Service
@Slf4j
public class SmsServiceImpl implements SmsService {
    @Resource
    private RedisService redisService;

    @Override
    public Result sendSms(SignDto signDto) {
        String mobile = signDto.getMobile();
        DefaultProfile profile = DefaultProfile.getProfile(
                "cn-beijing",
                "LTAI4FvqK568YDj7HtsPEZ5d",
                "VMfoqfNr2TpdzQVc9sLIOmSt5f5rhN");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-beijing");
        request.putQueryParameter("PhoneNumbers", mobile);
        request.putQueryParameter("SignName", "个人空间");
        request.putQueryParameter("TemplateCode", "SMS_179216037");
        String verifyCode = StringUtil.getVerifyCode();
        request.putQueryParameter("TemplateParam", "{\"code\":" + verifyCode + "}");
        CommonResponse response;
        try {
            response = client.getCommonResponse(request);
        } catch (ClientException e) {
            log.error("短信发送异常");
            return Result.failure(ResultCode.SMS_ERROR);
        }
        //resData样例：{"Message":"OK","RequestId":"0F3A84A6-55CA-4984-962D-F6F54281303E","BizId":"300504175696737408^0","Code":"OK"}
        String resData = response.getData();
        //将返回的JSON字符串转成JSON对象
        JSONObject jsonObject = JSONObject.parseObject(resData);
        if ("OK".equals(jsonObject.get("Code"))) {
            System.out.println(verifyCode);
            //存入redis，1分钟有效
            redisService.set(mobile, verifyCode, 1L);
            return Result.success(verifyCode);
        } else {
            return Result.failure(ResultCode.SMS_ERROR);
        }
    }

    @Override
    public Result checkSms(SignDto signDto) {
        String mobile = signDto.getMobile();
        String sms = signDto.getSms();
        String correctSms = redisService.getValue(mobile, String.class);
        if (correctSms != null) {
            //将客户端传来的短信验证码和redis取出的短信验证码比对
            if (correctSms.equals(sms)) {
                return Result.success();
            } else {
                //验证码错误
                Result.failure(ResultCode.USER_VERIFY_CODE_ERROR);
            }
        }
        //验证码失效
        return Result.failure(ResultCode.USER_CODE_TIMEOUT);

    }
}
