package com.xbzheng.utils;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2015/7/27.
 */
public class Encodes {
    private static final Logger LOGGER = LoggerFactory.getLogger(Encodes.class);

    /**
     * Hex±àÂë
     * @param input
     * @return
     */
    public static String encodeHex(byte[] input){
        return new String(Hex.encodeHex(input));
    }

    /**
     * Hex½âÂë
     * @param input
     * @return
     */
    public static byte[] decodeHex(String input){
        try {
            return Hex.decodeHex(input.toCharArray());
        } catch (DecoderException e) {
            LOGGER.error("DecodeHex failed:"+e.getMessage());
        }
        return null;
    }
}
