package base.util.objects;

import base.util.object.CopyUtil;
import org.junit.Test;

/**
 * @Author: weixuedong
 * @Date: 2018/4/13 17:13
 * @Description:
 */
public class CopyUtilTest {
    @Test
    public void test(){
        Integer integer = new Integer(400);
        Integer intr = CopyUtil.copy(integer);
        System.out.println(intr);
        System.out.println(integer);
    }
}
