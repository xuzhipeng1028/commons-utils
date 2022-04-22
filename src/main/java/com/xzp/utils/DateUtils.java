package com.xzp.utils;

import com.xzp.common.constants.CommonConstants;
import javafx.util.Pair;
import org.apache.commons.lang3.time.FastDateFormat;

import java.util.*;

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

    /**
     * 获取今天的开始时间
     * @return {@link Date}
     */
    public static Date getTodayStartTime(){
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取今天的结束时间
     * @return {@link Date}
     */
    public static Date getTodayEndTime(){
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    /**
     * 获取某天的开始时间
     * @return {@link Date}
     */

    /**
     * 获取某天的开始时间
     * @param date 时间
     * @return {@link Date}
     */
    public static Date getSomeDayStartTime(Date date){
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取某天的结束时间
     * @param date 时间
     * @return {@link Date}
     */
    public static Date getSomeDayEndTime(Date date){
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    /**
     * 获取某天明天的开始时间
     * @param date 时间
     * @return {@link Date}
     */
    public static Date getSomeDayTomorrowStartTime(Date date){
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取某天明天的结束时间
     * @param date 时间
     * @return {@link Date}
     */
    public static Date getSomeDayTomorrowEndTime(Date date){
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    /**
     * 获取时间段内每一天的开始和结束时间
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @return {@link List < Pair <Date,Date>>}
     */
    public static List<Pair<Date,Date>> getEveryDayStartAndEnd(Date startDate,Date endDate){
        if (Objects.isNull(startDate) || Objects.isNull(endDate) || endDate.before(startDate)) {
            throw new IllegalArgumentException("参数有误");
        }
        List<Pair<Date,Date>> list = new ArrayList<>();
        Date beginDate = getSomeDayStartTime(startDate);
        Date finalDate = getSomeDayEndTime(endDate);
        while (finalDate.after(beginDate)){
            list.add(new Pair<>(beginDate,getSomeDayEndTime(beginDate)));
            beginDate = getSomeDayTomorrowStartTime(beginDate);
        }
        return list;
    }

}
