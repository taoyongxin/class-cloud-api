package com.scs.soft.cloud.api.controller;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.domain.dto.SignDto;
import com.scs.soft.cloud.api.service.SmsService;
import com.scs.soft.cloud.api.service.UserLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Tao
 */
@RestController
@RequestMapping(value = "/api/user")
@Api(value = "UserLoginController",tags = {"用户模块接口"})
public class UserLoginController {
    @Resource
    private UserLoginService userLoginService;
    @Resource
    private SmsService smsService;

    @ApiOperation(value = "通过帐号密码登录",notes = "data为用户数据")
    @PostMapping(value = "/login")
    Result login(@RequestBody SignDto signDto){
        System.out.println(signDto);
        return userLoginService.login(signDto);
    }

    /**
     * 发送手机短信
     * @param signDto
     * @return
     */
    @ApiOperation(value = "通过手机号码发送短信验证码",notes = "")
    @PostMapping(value = "/sms")
    Result getSms(@RequestBody  SignDto signDto){
        return smsService.sendSms(signDto);
    }

    /**
     * 验证手机短信
     * @param signDto
     * @return
     */
    @ApiOperation(value = "判断手机号和验证码是否匹配",notes = "")
    @PostMapping(value = "/sms/check")
    Result checkSms(@RequestBody SignDto signDto){
        return smsService.checkSms(signDto);
    }
}

