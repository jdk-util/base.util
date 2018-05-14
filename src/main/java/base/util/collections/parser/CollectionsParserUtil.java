package base.util.collections.parser;

import base.util.collections.CollectionUtil;
import base.util.reflex.ClassParserUtil;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;

/**
 * @Author: weixuedong
 * @Date: 2018/3/19 11:50
 * @Description: 集合转换工具
 * @Since：jdk1.8
 */
public class CollectionsParserUtil {


    /**
     * T集合转换成R集合，也可以用于集合属性的提取
     * @param list 集合
     * @param function 转换方法
     * @param <T> 集合里得数据类型
     * @param <R> 返回值类型
     * @return
     */
    public static <T,R> List<R> collectFieldToList(List<T> list,Function<T,R> function) {

        return list.stream().map((t) -> function.apply(t)).collect(Collectors.toList());

    }

    /**
     * 强行将一个集合转成另一个集合
     * @param list 需要转换的集合
     * @param rClass 转后集合的泛型类型
     * @param <T> 集合原本泛型
     * @param <R> 转换后泛型
     * @return 转换后的集合
     */
    public static <T,R> List<R> changeListToOtherListBreak(List<T> list,Class<R> rClass){

        List<R> listR = new ArrayList<>();

        list.forEach(one ->listR.add( ClassParserUtil.formatBaseClass(one,rClass)));

        return listR;
    }
    /**
     * 将list转换成map
     * @param list
     * @param key key得转换方式
     * @param value value得转换方式
     * @param <T> 集合内得类型
     * @param <K> key类型
     * @param <V> value得类型
     * @return
     */
    public static <T,K,V> Map<K,V> collectFieldToMap(List<T> list,Function<T,K> key,Function<T,V> value){

        Map<K,V> map = new HashMap<>();

        list.forEach(t -> map.put(key.apply(t),value.apply(t)));

        return map;
    }

    /**
     * 将list转换成map value为集合内得类型
     * @param list
     * @param key key得转换方式
     * @param <T> 集合内得类型
     * @param <K> key类型
     * @return
     */
    public static <T,K> Map<K,T> collectFieldToMap(List<T> list,Function<T,K> key){

        Map<K,T> map = new HashMap<>();

        list.forEach(t -> map.put(key.apply(t), t));

        return map;
    }

    /**
     * 集合互转（强转）
     * @param list 原集合
     * @param rClass 目标类型
     * @param <T> 原类型
     * @param <R> 目标类型
     * @return 目标集合
     */
    public static<T,R> List<R> parseTListToRListBreak(List<T> list,Class<R> rClass){
        List<R> listR = new ArrayList<>();

        list.forEach(one ->{

            listR.add(ClassParserUtil.formatBaseClass(one,rClass));
        });
        return listR;
    }
    /**
     * 集合转换成数组
     * @param list 源集合
     * @param rClass 目标类型
     * @param <T> 集合类型
     * @param <R> 目标数组类型
     * @return
     */
    public static <T,R> R[] parseListToArrayBreak(List<T> list,Class<R> rClass){

        return (R[])list.toArray();
    }
    /**
     * 将任意List转换成ArrayInt
     * @param list 需要转换得集合
     * @param function 转换方法得实现
     * @return 返回数组
     */
    public static <T> int[] parseListToIntArray(List<T> list,ToIntFunction<T> function){

        return list.stream().mapToInt(function).toArray();

    }

    /**
     * 将任意List转换成ArrayInteger
     * @param list 需要转换得集合
     * @param function 转换方法得实现
     * @return 返回数组
     */
    public static <T> Integer[] parseListToIntegerArray(List<T> list,ToIntFunction<T> function){

        List<Integer> listInteger = list.stream().map(t -> function.applyAsInt(t)).collect(Collectors.toList());

        return listInteger.toArray(new Integer[list.size()]);

    }
    /**
     * 集合转换成整形数组
     * @param list 源集合
     * @param <T> 集合类型
     * @return 目标数组
     */
    public static <T> int[] parseListToIntArrayBreak(List<T> list){

        return list.stream().mapToInt(one -> ClassParserUtil.formatBaseClass(one,int.class)).toArray();
    }

    /**
     * 将任意List转换成doubleArray
     * @param list 需要转换得集合
     * @param function 转换方法得实现
     * @return 返回数组
     */
    public static <T> double[] parseListTodoubleArray(List<T> list, ToDoubleFunction<T> function){

        return list.stream().mapToDouble(function).toArray();

    }

    /**
     * 将任意List转换成ArrayInteger
     * @param list 需要转换得集合
     * @param function 转换方法得实现
     * @return 返回数组
     */
    public static <T> Double[] parseListToIntegerArray(List<T> list,ToDoubleFunction<T> function){

        List<Double> listDouble = list.stream().map(t -> function.applyAsDouble(t)).collect(Collectors.toList());

        return listDouble.toArray(new Double[list.size()]);

    }
    /**
     * 集合转换成double数组
     * @param list 源集合
     * @param <T> 集合类型
     * @return 目标数组
     */
    public static <T> double[] parseListToDoubleArrayBreak(List<T> list){

        return list.stream().mapToDouble(one -> ClassParserUtil.formatBaseClass(one,double.class)).toArray();
    }
    /**
     * 将任意List转换成doubleArray
     * @param list 需要转换得集合
     * @param function 转换方法得实现
     * @return 返回数组
     */
    public static <T> long[] parseListTolongArray(List<T> list, ToLongFunction<T> function){

        return list.stream().mapToLong(function).toArray();

    }

    /**
     * 将任意List转换成ArrayInteger
     * @param list 需要转换得集合
     * @param function 转换方法得实现
     * @return 返回数组
     */
    public static <T> Long[] parseListToLongArray(List<T> list,ToLongFunction<T> function){

        List<Long> listLong = list.stream().map(t -> function.applyAsLong(t)).collect(Collectors.toList());

        return listLong.toArray(new Long[list.size()]);

    }

    /**
     * 集合转换成long数组
     * @param list 源集合
     * @param <T> 集合类型
     * @return 目标数组
     */
    public static <T> long[] parseListToLongArrayBreak(List<T> list){

        return list.stream().mapToLong(one -> ClassParserUtil.formatBaseClass(one,long.class)).toArray();
    }

    /**
     * 将list集合转换成Map<K,List<T>> 集合
     * @param list 需要转换得集合
     * @param key 提取方式
     * @param <T> 数据类型
     * @param <K> key类型
     * @return map<K,List<T>>
     */
    public static <T,K> Map<K,List<T>> collectFieldToMapList(List<T> list,Function<T,K> key){
        Map<K,List<T>> map = new HashMap<>();
        if(CollectionUtil.isEmpty(list)){
            return map;
        }

        list.forEach(t -> {
            List<T> valueList = map.get(key.apply(t));
            if(CollectionUtil.isEmpty(valueList)){
                valueList = new ArrayList<>();
                valueList.add(t);
                map.put(key.apply(t),valueList);
            }else {
                valueList.add(t);
            }
        });

        return map;
    }

}
