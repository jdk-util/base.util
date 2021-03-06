package base.util.collections.opearator;

import base.util.collections.CollectionUtil;
import base.util.collections.parser.CollectionsParserUtil;
import base.util.object.CopyUtil;
import com.sun.istack.internal.NotNull;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

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
     * 根据属性去重
     * @param list 需要去重得
     * @param <T> 数据类型
     * @param <R> 去重得类型
     * @return 去重后得集合
     */
    public static <T,R> List<T> distinct(List<T> list,Function<T,R> function){
        Map<R, T> map = CollectionsParserUtil.collectFieldToMap(list, function);
        return new ArrayList<>(map.values());
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

    /**
     *按数量对集合进行分组，保证每组得数量一致，但是不够得情况则不补
     * @param count 每组数量
     * @param list 数据集合
     * @param <T> 支持数据类型
     * @return 返回分组后得结果 key是组号从1开始 value是数量符合count得集合
     */
    public static <T> Map<Integer,List<T>> countGroup(int count, List<T> list){
        Map<Integer,List<T>> map = new HashMap<>();
        if(CollectionUtil.isEmpty(list)){
            return map;
        }

        for(int i = 1; i<=(int)(list.size()/count+1); i++){
            List<T> subList;
            try {
                subList = list.subList((i-1)*count,count*i);
            }catch (IndexOutOfBoundsException e){
                subList = list.subList((i-1)*count,list.size());
            }
            map.put(map.size()+1,subList);
        }
        return map;
    }

    /**
     * 按照一个方式和排序参照进行排序，顺序于soreReferences一致
     * 原位排序
     * @param list  数据
     * @param sortReferences 排序参照
     * @param function 转换方式
     * @param <T> 需要排序得数据类型
     * @param <R> 参照得数据类型
     * @return
     */
    public static <T,R> void sortBy(List<T> list, Set<R> sortReferences, Function<T,R> function){
        if(CollectionUtil.isNotEmpty(list) && CollectionUtil.isNotEmpty(sortReferences) && !Objects.isNull(function)) {
            List<T> sorts = new ArrayList<>(list.size());

            sortReferences.forEach(sortReference -> {

                List<T> findDatas = list.stream().filter(data -> function.apply(data) == sortReference).collect(Collectors.toList());

                sorts.addAll(findDatas);
            });
            list.clear();

            list.addAll(sorts);
        }
    }
}
