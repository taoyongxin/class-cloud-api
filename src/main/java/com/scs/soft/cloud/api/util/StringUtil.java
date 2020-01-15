package com.scs.soft.cloud.api.util;

import java.util.Random;

/**
 * @author Tao
 */
public class StringUtil {
    private final static int LENGTH = 6;

    /**
     * 获取六位随机短信验证码
     * @return
     */
    public static String getVerifyCode(){
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0;i<LENGTH;i++){
            stringBuffer.append(random.nextInt(10));
        }
        return stringBuffer.toString();
    }
}
