package com.xzp.utils;

import com.xzp.common.constants.CommonConstants;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidParameterException;
import java.security.Key;
import java.util.Base64;

/**
 * AES工具类
 * @author xuzhipeng
 * @date 2022/2/18
 */
public final class AESUtils {

    /**
     * 密钥算法
     */
    private static final String ALGORITHM = "AES";

    /**
     * 加密/解密算法-工作模式-填充模式
     */
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";

    private AESUtils(){
        throw new UnsupportedOperationException(CommonConstants.INSTANTIATE_UTILITY_CLASS_EXCEPTION);
    }

    /**
     * 加密
     * @param password 加密密码，长度必须是16位
     * @param iv 偏移变量，固定占16位字节
     * @param content 待加密字符串
     * @return 加密后内容
     * @throws Exception 异常
     */
    public static String encrypt(String password,String iv,String content) throws Exception {
        return handle(password, iv, content.getBytes(StandardCharsets.UTF_8), Cipher.ENCRYPT_MODE);
    }

    /**
     * 解密
     * @param password 解密密码，长度必须是16位
     * @param iv 偏移变量，固定占16位字节
     * @param content 待解密字符串
     * @return 解密后内容
     * @throws Exception 异常
     */
    public static String decrypt(String password,String iv,String content) throws Exception {
        return handle(password, iv, Base64.getDecoder().decode(content.getBytes(StandardCharsets.UTF_8)), Cipher.DECRYPT_MODE);
    }

    /**
     * 处理加解密
     * @param password 密码，长度必须是16位
     * @param iv 偏移变量，固定占16位字节
     * @param bytes 待加解密字节数组
     * @param mode 模式
     * @return 加解密后内容
     * @throws Exception 异常
     */
    private static String handle(String password,String iv,byte[] bytes,int mode) throws Exception {
        Key secretKey = new SecretKeySpec(password.getBytes(StandardCharsets.UTF_8),ALGORITHM);
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        cipher.init(mode, secretKey, new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8)));
        switch (mode){
            case Cipher.ENCRYPT_MODE:
                return new String(Base64.getEncoder().encode(cipher.doFinal(bytes)));
            case Cipher.DECRYPT_MODE:
                return new String(cipher.doFinal(bytes));
            default:
                throw new InvalidParameterException("Invalid operation mode");
        }
    }

}
