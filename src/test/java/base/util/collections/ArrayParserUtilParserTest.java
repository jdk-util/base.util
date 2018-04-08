package base.util.collections;

import base.util.array.parser.ArrayParserUtil;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * @Author: weixuedong
 * @Date: 2018/4/8 14:22
 * @Description:数组转换测试类
 */
public class ArrayParserUtilParserTest {

    @Test
    public void testChangeArrayToList(){
        String[] strs = new String[]{"a","b","c"};
        System.out.println(ArrayParserUtil.changeArrayToList(strs));
    }

    @Test
    public void testChangeArrayToList1(){
        double[] doubles = new double[]{1.1,1.2,13.3};
        List<String> strs = ArrayParserUtil.changeDoubleArrayToListBreak(doubles, String.class);
        System.out.println(strs);
    }
}
