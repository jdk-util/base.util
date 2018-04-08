package base.util.time;

import org.junit.Test;

/**
 * @Author: weixuedong
 * @Date: 2018/3/16 16:34
 * @Description:日期操作工具测试类
 */

public class TimeUtilTest {

    @Test
    public void testGetNowStart(){
        System.out.println(TimeUtil.getNowStart());
        //"2018-03-16T00:00";
    }

    @Test
    public void testGetNowEnd(){
        System.out.println(TimeUtil.getNowEnd());
        //2018-03-16T23:59:59
    }

    @Test
    public void testNowStr(){
        System.out.println(TimeUtil.getNowDateTimeStr());
    }

    @Test
    public void getNowStart() {
    }

    @Test
    public void getNowEnd() {
    }

    @Test
    public void getNowTimeEnd() {
    }

    @Test
    public void getNowTimeStart() {
    }

    @Test
    public void getNowDateTimeStr() {
    }

    @Test
    public void getNowDateStr() {
    }

    @Test
    public void getNowTimeStr() {
    }

    @Test
    public void changeLocalDateTimeToDate() {
    }

    @Test
    public void changeDateToLocalDateTime() {
    }

    @Test
    public void changLocalDateToDate() {
    }

    @Test
    public void changeDateToLocalDate() {
    }

    @Test
    public void changeLocalTimeToDate() {

    }
}
