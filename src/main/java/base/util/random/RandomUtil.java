package base.util.random;

import java.util.List;
import java.util.Random;

/**
 * @Author: weixuedong
 * @Date: 2018/5/7 11:57
 * @Description:随机数工具
 */
public class RandomUtil {
    /**
     * 范围生成随机数
     * @param min 最小数
     * @param max   最大数
     * @return 随机数
     */
    public static int rangeRandom(int min,int max){
        return new Random().nextInt(max-min)+min;
    }

    /**
     * 范围固定类型随机数
     * @param list   备选范围
     * @return 随机数
     */
    public static <T> T rangeRandom(List<T> list){
        int intIndex = new Random().nextInt(list.size());
        return list.get(intIndex);
    }
}
