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
    public static String getRandomString(){
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        int index;
        for (int i=0 ; i< LENGTH ; i++){
            //随机生成0、1、2三个整数，代表数字字符、大写字母、小写字母，保证验证码的组成比较正态随机
            index = random.nextInt(3);
            char result = getChar(index);
            //追加到可变长字符串
            stringBuilder.append(result);
        }
        return stringBuilder.toString();
    }

    private static char getChar(int item) {
        //数字字符范围
        int digitalBound = 10 ;
        //字符返回
        int charBound = 26 ;
        Random random = new Random();
        int index;
        char c;
        //根据调用时候的三个选项，生成数字、大写字母、小写字母三种不同的字符
        if(item == 0){
            index = random.nextInt(digitalBound);
            c = (char) ('0' + index);
        }else if (item == 1 ){
            index = random.nextInt(charBound);
            c = (char)('A' + index);
        } else {
            index = random.nextInt(charBound);
            c = (char)('a' + index);
        }
        return c;
    }
}
