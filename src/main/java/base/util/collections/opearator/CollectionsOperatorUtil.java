package base.util.collections.opearator;

import base.util.object.CopyUtil;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Author: weixuedong
 * @Date: 2018/4/12 9:45
 * @Description:集合流处理类
 */
public class CollectionsOperatorUtil {

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

    /**
     * 移除自身
     * @param list 需要移除得集合
     * @param <T> 数据类型
     * @return 删除得数据
     */
    public static <T> List<T> distinctSelf(List<T> list){
        List<T> repeatList = new ArrayList<>();
        if(!Objects.isNull(list)){

            repeatList= findRepeat(list);

            List<T> distinctList = list.stream().distinct().collect(Collectors.toList());

            list.clear();

            list.addAll(distinctList);
        }
        return repeatList;
    }

    /**
     * 判断一个数据在集合中出现几次
     * @param list 目标集合
     * @param r 想比对得数据
     * @param <T> 源数据类型
     * @param <R> 比对得类型
     * @return 重复次数
     */
    public static <T,R> long repeatTimes(List<T> list,R r){
        long repeatCount = 0;

        if(!Objects.isNull(list)){

            repeatCount = list.stream().filter(t -> t.equals(r)).count();

        }

        return repeatCount;
    }

    /**
     * 找出重复源list得重复数据
     * @param list 源数据
     * @param <T> 集合类型
     * @return 重复数据
     */
    public static <T> List<T> findRepeat(List<T> list){

        List<T> repeatList = new ArrayList<>();//重复集合

        if(!Objects.isNull(list)){

            List<T> copy = (List<T>) CopyUtil.copy(list);

            Iterator<T> listIt = copy.iterator();

            while (listIt.hasNext()){

                T data = listIt.next();

                listIt.remove();

                if(copy.contains(data)){//如果删了还有

                    repeatList.add(data);

                }
            }
        }
        return repeatList;
    }
}
