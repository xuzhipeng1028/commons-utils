package com.xzp.utils;

import com.xzp.common.constants.CommonConstants;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidParameterException;
import java.security.Key;
import java.util.Base64;

/**
 * DES工具类
 * @author xuzhipeng
 * @date 2022/2/16
 */
public final class DESUtils {

    /**
     * 密钥算法
     */
    private static final String ALGORITHM = "DES";

    /**
     * 加密/解密算法-工作模式-填充模式
     */
    private static final String DEFAULT_CIPHER_ALGORITHM  = "DES/CBC/PKCS5Padding";

    private DESUtils(){
        throw new UnsupportedOperationException(CommonConstants.INSTANTIATE_UTILITY_CLASS_EXCEPTION);
    }

    /**
     * 加密
     * @param password 加密密码，长度不能够小于8位
     * @param iv 偏移变量，固定占8位字节
     * @param content 待加密字符串
     * @return 加密后内容
     * @throws Exception 异常
     */
    public static String encrypt(String password,String iv,String content) throws Exception {
        return handle(password, iv, content.getBytes(StandardCharsets.UTF_8), Cipher.ENCRYPT_MODE);
    }

    /**
     * 解密
     * @param password 解密密码，长度不能够小于8位
     * @param iv 偏移变量，固定占8位字节
     * @param content 待解密字符串
     * @return 解密后内容
     * @throws Exception 异常
     */
    public static String decrypt(String password,String iv,String content) throws Exception {
        return handle(password, iv, Base64.getDecoder().decode(content.getBytes(StandardCharsets.UTF_8)), Cipher.DECRYPT_MODE);
    }

    /**
     * 处理加解密
     * @param password 密码，长度不能够小于8位
     * @param iv 偏移变量，固定占8位字节
     * @param bytes 待加解密字节数组
     * @param mode 模式
     * @return 加解密后内容
     * @throws Exception 异常
     */
    private static String handle(String password,String iv,byte[] bytes,int mode) throws Exception {
        Key secretKey = generateKey(password);
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

    /**
     * 生成KEY
     * @param password 密码，长度不能够小于8位
     * @return Key
     * @throws Exception 异常
     */
    private static Key generateKey(String password) throws Exception {
        DESKeySpec dks = new DESKeySpec(password.getBytes(StandardCharsets.UTF_8));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        return keyFactory.generateSecret(dks);
    }

}
