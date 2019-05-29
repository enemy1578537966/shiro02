package cn.juechuang.util;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5Util {
    // 散列次数
    private static int hashIterations = 3;
    /**
     * md5加密工具类
     */
    public static String md5(String source, String salt) {
        return new Md5Hash(source, salt, hashIterations).toString();
    }
}