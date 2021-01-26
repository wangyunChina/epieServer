package com.muc.websocket;


import com.muc.model.EMSPBaseRequest;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption
{
    private static final Logger logger = LogManager.getLogger(Encryption.class);
    private static String gcm256algorithm = "AES/GCM/PKCS5Padding";

    /**
     *
     * @param sSrc 明文字符串
     * @param keyStr 加密秘钥
     * @param ivStr 加密向量
     * @param charset 编码
     * @return
     */
    public static String encrypt(String sSrc, String keyStr, String ivStr, String charset) {
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(keyStr.getBytes(), "AES");
            // "算法/模式/补码方式"
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            // 使用CBC模式，需要一个向量iv，可增加加密算法的强度
            IvParameterSpec iv = new IvParameterSpec(ivStr.getBytes(charset));

            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(sSrc.getBytes());

            String str = new BASE64Encoder().encode(encrypted);
            //注意：linux环境下加密时，会自动补\r \n到加密数据里面
            //str = str.replaceAll("\r\n", "");
            //str = str.replaceAll("\n", "");
            str = str.replaceAll(System.getProperty("line.separator"), "");
            return str;
        } catch (Exception e) {
         logger.error("AESUtil 加密失败",e);
            return "";
        }
    }

    /**
     * AES 解密
     *
     * @param sSrc 密文字符串
     * @param sKey 加密秘钥
     * @param ivStr 加密向量
     * @param charset 编码
     * @return
     */
    public static String decrypt(String sSrc, String sKey, String ivStr, String charset) {
        try {
            byte[] raw = sKey.getBytes("UTF-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(ivStr.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);// 先用base64解密
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original, charset);
            //originalString = originalString.replaceAll("\r\n", "");
            //originalString = originalString.replaceAll("\n", "");
            originalString = originalString.replaceAll(System.getProperty("line.separator"), "");
            return originalString;
        } catch (Exception ex) {
            logger.error("AESUtil 解密失败",ex);
            return "";
        }
    }
    // 加密
    public static String encrypt(String sSrc, String encodingFormat, String sKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        byte[] raw = sKey.getBytes();
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes(encodingFormat));
        return new BASE64Encoder().encode(encrypted);//此处使用BASE64做转码。
    }

    // 解密
    public static String decrypt(String sSrc, String encodingFormat, String sKey) throws Exception {
        try {
            byte[] raw = sKey.getBytes("ASCII");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);//先用base64解密
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original,encodingFormat);
            return originalString;
        } catch (Exception ex) {
            return null;
        }
    }
    public static String MD5_Sig(EMSPBaseRequest requestBody, String signKey)
    {
        String msg = requestBody.getOperatorID() + requestBody.getData() + requestBody.getTimeStamp() + requestBody.getSeq();
        return HMAC_MD5(signKey, msg);
    }

    public static String HMAC_MD5(String key, String msg)
    {
        try
        {
            SecretKey secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8),"HmacMD5");
            Mac mac = Mac.getInstance(secretKey.getAlgorithm());
            mac.init(secretKey);
            byte[] result = mac.doFinal(msg.getBytes("UTF-8"));
            StringBuffer sb = new StringBuffer(result.length * 2);
            for (int i = 0; i < result.length; i++) {
                int v = result[i] & 0xff;
                if (v < 16) {
                    sb.append('0');
                }
                sb.append(Integer.toHexString(v));
            }
            String sig = sb.toString();
            return sig.toUpperCase();
        }
        catch(Exception ex) {
            String exeMessage=ex.getMessage();
            logger.error("MD5处理异常,error:{}",ex);

        }
        return  "";
    }
    public static String getSign(String key, long timestamp,
                                 String requestBody, String secret) {
        if (StringUtils.isBlank(key)) {
            throw new RuntimeException("key can not be empty");
        }
        if (StringUtils.isBlank(secret)) {
            throw new RuntimeException("secret can not be empty");
        }
        String paramsSortSecret = String.format("key=%s&timestamp=%s%s&secret=%s",
                key, timestamp, requestBody, secret);
        String strMd5Util=Md5Utils.string2MD5(paramsSortSecret);
        String strThirdpartner=Encryption.getMd5Str(paramsSortSecret);
        String sign="";
        try {
            sign=Md5Utils.string2MD5(paramsSortSecret);
        } catch (Exception e) {
            logger.error("-----------------------getSign method md5 exception:" + e.getMessage());
        }
        return sign;
    }
    public static String getMd5Str(String plainText) {
        byte[] secretBytes = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            secretBytes = md.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("非法的验证算法");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }

}
