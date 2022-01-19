package com.xzp.utils;

import java.util.Optional;

/**
 * 字符串工具类
 * @author xuzhipeng
 * @date 2022/1/19
 */
public final class StringUtils {

    public static final String EMPTY = "";

    private StringUtils(){
        throw new UnsupportedOperationException();
    }

    /**
     * 如果obj为null则返回null，否则返回obj.toString()
     * @param obj 对象
     * @return String
     */
    public static String defaultNullIfNull(Object obj){
        return defaultStringIfNull(obj,null);
    }

    /**
     * 如果obj为null则返回空字符串，否则返回obj.toString()
     * @param obj 对象
     * @return String
     */
    public static String defaultEmptyIfNull(Object obj){
        return defaultStringIfNull(obj,EMPTY);
    }

    /**
     * 如果obj为null则返回defaultStr，否则返回obj.toString()
     * @param obj 对象
     * @param defaultStr 默认字符串
     * @return String
     */
    public static String defaultStringIfNull(Object obj,String defaultStr){
        return obj == null ? defaultStr : obj.toString();
    }
}
