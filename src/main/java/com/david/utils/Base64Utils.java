package com.david.utils;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha1Hash;

public class Base64Utils {
    public static void main(String[] args) {
        String msg = "陈冠希15厘米钛合金黑硬大屌后入肏日张柏芝肮脏的黑屄淫水喷涌浪叫海豚音";
        String salt = "张柏芝的黑屄";

        String base64EncodedMsg = Base64.encodeToString(msg.getBytes());
        System.out.println("加密后："+base64EncodedMsg);
        String base64DecodedMsg = Base64.decodeToString(base64EncodedMsg);
        System.out.println("解密后："+base64DecodedMsg);

        String md5_1 = new Md5Hash(msg, salt, 1).toString();
        System.out.println("结果1："+md5_1);
        String md5_2 = new Md5Hash(msg, salt, 108).toString();
        System.out.println("结果2："+md5_2);

        String md5_test = new Md5Hash("fuck", "fuck", 20).toString();
        System.out.println("结果test："+md5_test);
        //f9ea7833c0a9681afeab2b4392fb5485
        //c7f91e0eb37f7853bfcf49790f66bcbba7d16fb2
        //8eb1d970c424785e6d00dad3d6dcf10e
        //579be2334c6ceffc49e362ee4bf79a0fcc8807d0

        String sha1_1 = new Sha1Hash(msg, salt, 1).toString();
        System.out.println("结果1："+sha1_1);
        String sha1_2 = new Sha1Hash(msg, salt, 108).toString();
        System.out.println("结果2："+sha1_2);
    }
}
