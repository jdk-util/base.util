package base.util.mach;

import base.util.math.MachUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: weixuedong
 * @Date: 2018/5/25 11:44
 * @Description:
 */
public class MachUtilTest {
    @Test
    public void test(){
        List<Integer> list = new ArrayList();
        for(int i=0;i<100;i++){
            list.add(i);
        }
        Map<String, List<Integer>> resultMap = MachUtil.group(list, 2);
//        resultMap.values().forEach(integers -> System.err.println("100选2所有组合结果："+integers));
//        System.err.println("分组总数量："+resultMap.size());
    }
}
