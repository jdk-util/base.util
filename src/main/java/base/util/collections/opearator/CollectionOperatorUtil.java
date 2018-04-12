package base.util.collections.opearator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Author: weixuedong
 * @Date: 2018/4/12 9:45
 * @Description:集合流处理类
 */
public class CollectionOperatorUtil {

    /**
     * 过滤自身并将自身移除形成新得list
     * @param list 需要过滤得集合
     * @param <T> 数据类型
     * @return 新形成得集合
     */
    public static <T> List<T> filterSelf(List<T> list, Predicate<? super T> predicate){

        if(!Objects.isNull(list)){

            List<T> filterList = list.stream().filter(predicate).collect(Collectors.toList());

            list.removeIf(predicate);

            return filterList;
        }
        return new ArrayList<>();
    }
}
