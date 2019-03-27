package com.example.mydagger2.utils;

import java.io.UnsupportedEncodingException;

/**
 * Created by beijixiong on 2019/3/27.
 */

public class PublicPracticalMethod {

    private static volatile PublicPracticalMethod mInstance;

    public static PublicPracticalMethod getInstance() {
        if (mInstance == null) {
            synchronized (PublicPracticalMethod.class) {
                if (mInstance == null) {
                    mInstance = new PublicPracticalMethod();
                }
            }
        }
        return mInstance;
    }

    /**
     * 将byte[]数组转化成String
     */
    public String byte2String(byte[] arg) {
        String dataString = "";
        try {
            dataString = new String(arg, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return dataString;
    }


}
