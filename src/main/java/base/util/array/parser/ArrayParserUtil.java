package base.util.array.parser;

import base.util.reflex.ClassParserUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: weixuedong
 * @Date: 2018/4/3 10:30
 * @Description:数组转换工具
 */
public class ArrayParserUtil {

    /**
     * 同型转换
     * 将Array转换为List
     * @param arrays 数组
     * @param <T> 集合类型
     * @return 集合
     */
    public static <T> List<T> changeArrayToList(T[] arrays){

        return Stream.of(arrays).collect(Collectors.toList());

    }

    /**
     * 将非同型数组转换为集合(强转)
     * @param arrays 需要转型的数组
     * @param rClass 返回值集合的类型
     * @param <T> 数组类型
     * @param <R> 集合类型
     * @return 集合
     */
    public static <T,R> List<R> changeArrayToListBreak(T[] arrays,Class<R> rClass){

        List<R> listR = new ArrayList<>();

        Stream.of(arrays).forEach(one -> listR.add(ClassParserUtil.formatBaseClass(one, rClass)));

        return listR;
    }
    /**
     * 将非同型数组转换为集合(父子类的转换)
     * @param arrays 需要转型的数组
     * @param rClass 返回值集合的类型
     * @param <T> 数组类型
     * @param <R> 集合类型
     * @return 集合
     */
    public static <T,R>  List<R> changeArrayToListCast(T[] arrays,Class<R> rClass){

        List<T> list = Stream.of(arrays).collect(Collectors.toList());

        return list.stream().map(one -> rClass.cast(one)).collect(Collectors.toList());
    }

    /**
     * 将int型数组转换成自定义集合，强制转换
     * @param arrays 源数组
     * @param tClass 转换目标类型
     * @param <T> 目标类型
     * @return 返回目标类型集合
     */
    public static <T> List<T>  changeIntArrayToListBreak(int[] arrays,Class<T> tClass){

        return Arrays.stream(arrays).mapToObj(arr -> ClassParserUtil.formatBaseClass(arr,tClass)).collect(Collectors.toList());
    }

    /**
     * 将double型数组转换成自定义集合，强制转换
     * @param arrays 源数组
     * @param tClass 转换目标类型
     * @param <T> 目标类型
     * @return 返回目标类型集合
     */
    public static <T> List<T> changeDoubleArrayToListBreak(double[] arrays,Class<T> tClass){

        return Arrays.stream(arrays).mapToObj(arr -> ClassParserUtil.formatBaseClass(arr,tClass)).collect(Collectors.toList());

    }
    /**
     * 将long型数组转换成自定义集合，强制转换
     * @param arrays 源数组
     * @param tClass 转换目标类型
     * @param <T> 目标类型
     * @return 返回目标类型集合
     */
    public static <T> List<T> changeLongArrayToListBreak(long[] arrays,Class<T> tClass){

        return Arrays.stream(arrays).mapToObj(arr -> ClassParserUtil.formatBaseClass(arr,tClass)).collect(Collectors.toList());

    }

    /**
     * 将引用类型数组转换为基本类型
     * @param arrays 源数组
     * @param <T> 数组类型
     * @return int型数组
     */
    public static <T> int[] changeArrayToIntArrayBreak(T[] arrays){

        return Arrays.stream(arrays).mapToInt(arr ->Integer.parseInt(arr.toString())).toArray();

    }

    /**
     * 将引用类型数组转换为基本类型
     * @param arrays 源数组
     * @param <T> 数组类型
     * @return long型数组
     */
    public static <T> long[] changeArrayToLongArrayBreak(T[] arrays){

        return Arrays.stream(arrays).mapToLong(arr ->Long.parseLong(arr.toString())).toArray();

    }

    /**
     * 将引用类型数组转换为基本类型,强转
     * @param arrays 源数组
     * @param <T> 数组类型
     * @return double型数组
     */
    public static <T> double[] changeArrayToDoubleArrayBreak(T[] arrays){

        return Arrays.stream(arrays).mapToDouble(arr ->Double.parseDouble(arr.toString())).toArray();

    }

    /**
     * 将int数组转换成double数组
     * @param intArray int数组
     * @return double数组
     */
    public static  double[] changeIntArrayToDoubleArrayBreak(int[] intArray){

        return Arrays.stream(intArray).mapToDouble(intArra -> (double)intArra).toArray();

    }

    /**
     * 将int数组转换成long数组
     * @param intArray int数组
     * @return long数组
     */
    public static  long[] changeIntArrayToLongArrayBreak(int[] intArray){

        return Arrays.stream(intArray).mapToLong(intArra -> (long) intArra).toArray();

    }
}
