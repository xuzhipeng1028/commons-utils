package com.xzp.utils;

import com.xzp.common.constants.CommonConstants;

/**
 * 字符串工具类
 * @author xuzhipeng
 * @date 2022/1/19
 */
public final class StringUtils {

    private StringUtils(){
        throw new UnsupportedOperationException(CommonConstants.INSTANTIATE_UTILITY_CLASS_EXCEPTION);
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
        return defaultStringIfNull(obj,CommonConstants.EMPTY);
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
