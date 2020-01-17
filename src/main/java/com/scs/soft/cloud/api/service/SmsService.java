package com.scs.soft.cloud.api.service;

import com.scs.soft.cloud.api.common.Result;
import com.scs.soft.cloud.api.domain.dto.SignDto;

/**
 * @author Tao
 */
public interface SmsService {
    /**
     * 获取短信验证码
     * @param signDto
     * @return
     */
    Result sendSms(SignDto signDto);

    /**
     * 验证短信是否正确（signDto中有手机号和验证码）
     * @param signDto
     * @return
     */
    Result checkSms(SignDto signDto);


}
