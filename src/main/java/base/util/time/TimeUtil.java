package base.util.time;

import base.util.time.enums.TimeFormatPatternEnums;

import java.time.*;
import java.util.Date;

/**
 * @Author: weixuedong
 * @Date: 2018/3/16 16:24
 * @Description:时间工具类，用于处理时间操作
 * @Since：jdk1.8
 *  SQL -> Java
 *  --------------------------
 *  date -> LocalDate
 *  time -> LocalTime
 *  timestamp -> LocalDateTime
 */
public class TimeUtil {
    /**
     * 获得当前时间得起，yyyy-MM-dd 00：00：00
     * @return LocalDateTime
     */
    public static LocalDateTime getNowStart(){
        return LocalDateTime.of(LocalDateTime.now().toLocalDate(),LocalTime.of(0,0));
    }

    /**
     * 获得当前时间得截至，yyyy-MM-dd 23:59:59
     * @return LocalDateTime
     */
    public static LocalDateTime getNowEnd(){
        return LocalDateTime.of(LocalDateTime.now().toLocalDate(),LocalTime.of(23,59,59));
    }

    /**
     * 获得时时分秒得截止时间
     * 23：59：59
     * @return
     */
    public static LocalTime getNowTimeEnd(){
        return  LocalTime.of(23,59,59);
    }

    /**
     * 获得时分秒得开始时间
     * 00：00：00
     * @return
     */
    public static LocalTime getNowTimeStart(){
        return  LocalTime.of(0,0,0);
    }

    /**
     * 获得系统当前时间 yyyy-MM-dd HH:mm:ss
     * @return String
     */
    public static String getNowDateTimeStr(){
        return LocalDateTime.now().format(TimeFormatPatternEnums.YMDHMS.getDateTimeFormatter());
    }

    /**
     * 获得系统当前时间 yyyy-MM-dd
     * @return String
     */
    public static String getNowDateStr(){
        return LocalDateTime.now().format(TimeFormatPatternEnums.YMD.getDateTimeFormatter());
    }

    /**
     * 获得系统当前时间 HH:mm:ss
     * @return String
     */
    public static String getNowTimeStr(){
        return LocalDateTime.now().format(TimeFormatPatternEnums.HMS.getDateTimeFormatter());
    }

    /**
     *  LocalDateTime转换成Date
     *  @return
     */
    public static Date changeLocalDateTimeToDate(LocalDateTime dateTime){

        ZoneId zone = ZoneId.systemDefault();

        Instant instant = dateTime.atZone(zone).toInstant();

        return Date.from(instant);
    }

    /**
     *  Date转换成LocalDateTime
     *  @return
     */
    public static LocalDateTime changeDateToLocalDateTime(Date date){

        return LocalDateTime.ofInstant(date.toInstant(),ZoneId.systemDefault());

    }

    /**
     *  LocalDate转换成Date
     *  @return
     */
    public static Date changLocalDateToDate(LocalDate dateTime){

        ZoneId zone = ZoneId.systemDefault();

        Instant instant = dateTime.atStartOfDay().atZone(zone).toInstant();

        return Date.from(instant);
    }

    /**
     *  Date转换成LocalDate
     *  @return
     */
    public static LocalDate changeDateToLocalDate(Date date){

        return LocalDateTime.ofInstant(date.toInstant(),ZoneId.systemDefault()).toLocalDate();
    }

    /**
     *  LocalTime转换成Date
     *  @return
     */
    public static Date changeLocalTimeToDate(LocalTime dateTime){

        LocalDate localDate = LocalDate.now();

        LocalDateTime localDateTime = LocalDateTime.of(localDate, dateTime);

        ZoneId zone = ZoneId.systemDefault();

        Instant instant = localDateTime.atZone(zone).toInstant();

        return Date.from(instant);
    }
}
