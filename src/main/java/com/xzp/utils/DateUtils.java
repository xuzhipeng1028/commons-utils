package com.xzp.utils;

import com.xzp.common.constants.CommonConstants;
import org.apache.commons.lang3.time.FastDateFormat;

/**
 * 日期工具类
 * @author xuzhipeng
 * @date 2022/1/19
 */
public final class DateUtils {

    public static final String PATTERN_YYYY = "yyyy";
    public static final String PATTERN_YYYY_MM = "yyyy-MM";
    public static final String PATTERN_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String PATTERN_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static final FastDateFormat FAST_DATE_FORMAT_YYYY = FastDateFormat.getInstance(PATTERN_YYYY);
    public static final FastDateFormat FAST_DATE_FORMAT_YYYY_MM = FastDateFormat.getInstance(PATTERN_YYYY_MM);
    public static final FastDateFormat FAST_DATE_FORMAT_YYYY_MM_DD = FastDateFormat.getInstance(PATTERN_YYYY_MM_DD);
    public static final FastDateFormat FAST_DATE_FORMAT_YYYY_MM_DD_HH_MM_SS = FastDateFormat.getInstance(PATTERN_YYYY_MM_DD_HH_MM_SS);

    private DateUtils(){
        throw new UnsupportedOperationException(CommonConstants.INSTANTIATE_UTILITY_CLASS_EXCEPTION);
    }

}
