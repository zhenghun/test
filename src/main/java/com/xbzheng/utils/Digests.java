package com.xbzheng.utils;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.security.MessageDigest;
import java.security.SecureRandom;

/**
 * @Created by Administrator on 2015/7/27.
 */
public class Digests {
    private static final Logger LOGGER = LoggerFactory.getLogger(Digests.class);

    private static final String SHA1 = "SHA1";
    private static final String MD5 = "MD5";

    private static final SecureRandom secureRandom = new SecureRandom();

    public static byte[] md5(byte[] input){
        return digests(input, MD5, null, 1);
    }

    public static byte[] md5(byte[] input, int iterations) {
        return digests(input, MD5, null, iterations);
    }

    public static byte[] sha1(byte[] input){
        return digests(input, SHA1, null, 1);
    }

    public static byte[] sha1(byte[] input, byte[] salt){
        return digests(input, SHA1, salt, 1);
    }

    public static byte[] sha1(byte[] input, byte[] salt, int iterations){
        return digests(input, SHA1, salt, iterations);
    }

    /**
     * 通过指定的算法进行加密
     * @param input 需要被加密的二进制
     * @param algorithm 算法类型 md5/sha1
     * @param salt 盐值
     * @param iterations 重复加密次数
     * @return
     */
    private static byte[] digests(byte[] input, String algorithm, byte[] salt, int iterations){
        try{
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            if(salt != null){
                digest.update(salt);
            }
            byte[] result = digest.digest(input);
            for( int i =0; i < iterations; i++){
                digest.reset();
                digest.digest(result);
            }
            return result;
        }catch (Exception e){
            LOGGER.error("Encryption failed:"+e.getMessage());
        }
        return null;
    }

    /**
     * 随机产生指定长度的盐值
     * @param arrLen
     * @return
     */
    public static byte[] getSalt(int arrLen){
        Validate.isTrue(arrLen > 0, "arrLen argument must be a position integer (1 to max integer)", arrLen);
        byte[] salt = new byte[arrLen];
        secureRandom.nextBytes(salt);
        return salt;
    }

    public static byte[] md5(InputStream input){
        return digests(input, MD5);
    }

    public static byte[] sha1(InputStream input){
        return digests(input, SHA1);
    }

    /**
     * 对输入流进行加密
     * @param input
     * @param algorithm
     * @return
     */
    private static byte[] digests(InputStream input, String algorithm){
        try{
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            int bufferLength = 8 * 1024;
            byte[] buffer = new byte[bufferLength];
            int read = input.read(buffer, 0, bufferLength);
            while(read != -1){
                digest.update(buffer, 0, read);
                read = input.read(buffer, 0, bufferLength);
            }
            return digest.digest();
        }catch(Exception e){
            LOGGER.error("Encryption failed:"+e.getMessage());
        }
        return null;
    }

    public static void main(String[] args){
        System.out.println(Digests.sha1("zhenghun".getBytes()));
    }
}
