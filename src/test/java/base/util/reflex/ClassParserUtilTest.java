package base.util.reflex;

import org.junit.Test;

/**
 * @Author: weixuedong
 * @Date: 2018/4/8 15:27
 * @Description:
 */
public class ClassParserUtilTest {
    @Test
    public void formateBaseClass(){
        String str = "20";
        System.out.println(ClassParserUtil.formatBaseClass(str,Integer.class));
    }
}
