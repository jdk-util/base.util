package base.util.time.enums;

import java.time.format.DateTimeFormatter;

/**
 * @Author: weixuedong
 * @Date: 2018/3/16 17:28
 * @Description:中国常用得日期格式
 */
public enum TimeFormatPatternEnums {
    YMDHMS(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),

    HMS(DateTimeFormatter.ofPattern("HH:mm:ss")),

    YMD(DateTimeFormatter.ofPattern("yyyy-MM-dd")),

    YMDHM(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
    ;
    private DateTimeFormatter dateTimeFormatter;

    TimeFormatPatternEnums(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }

    public DateTimeFormatter getDateTimeFormatter() {
        return dateTimeFormatter;
    }
}
