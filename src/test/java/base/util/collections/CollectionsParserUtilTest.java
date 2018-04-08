package base.util.collections;

import base.util.array.parser.ArrayParserUtil;
import base.util.collections.parser.CollectionsParserUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: weixuedong
 * @Date: 2018/3/19 13:59
 * @Description:
 */
public class CollectionsParserUtilTest {

    @Test
    public void changeListToArray() {
        String[] strs = new String[]{"a","b"};
        List<String> strsList = ArrayParserUtil.changeArrayToList(strs);
        System.out.println(strsList);
    }

    @Test
    public void collectField() {
        A a = new A();
        a.setA(10);
        List<A> list= new ArrayList<>();
        list.add(a);
        System.out.println(CollectionsParserUtil.collectFieldToList(list,A::getA));
    }

    @Test
    public void collectFieldToMap() {
        A a = new A();
        a.setA(10);
        List<A> list= new ArrayList<>();
        list.add(a);
        System.out.println(CollectionsParserUtil.collectFieldToMap(list,A::getA,A::getA));
    }


    private class  A{
        private int a;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }
    }
}