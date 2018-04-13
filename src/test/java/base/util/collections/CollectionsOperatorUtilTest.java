package base.util.collections;

import base.util.collections.opearator.CollectionsOperatorUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weixuedong
 * @Date: 2018/4/13 15:25
 * @Description:
 */
public class CollectionsOperatorUtilTest {
    @Test
    public void testDis(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(100);
        list.add(3000);
        list.add(3000);
        list.add(3000);
        list.stream().distinct();
        List<Integer> distinctList = CollectionsOperatorUtil.distinctSelf(list);
        System.out.println(distinctList);
        System.out.println(list);
    }

    @Test
    public void testRepeatList(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(100);
        list.add(3000);
        list.add(3000);
        list.add(3000);
        List<Integer> repeatList = CollectionsOperatorUtil.findRepeat(list);
        System.out.println(repeatList);
    }

    @Test
    public void testRepeatTimes(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(100);
        list.add(3000);
        list.add(3000);
        list.add(3000);
        long count =  CollectionsOperatorUtil.repeatTimes(list,3000);
        System.out.println(count);
    }
}
