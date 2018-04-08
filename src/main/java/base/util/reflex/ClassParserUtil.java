package base.util.reflex;

import java.util.function.Function;

/**
 * @Author: weixuedong
 * @Date: 2018/4/8 15:04
 * @Description:类型转换类，反射使用
 */
public class ClassParserUtil {

    /**
     * 将T对象转换成R对象
     * @param t 原始对象
     * @param r 目标类型
     * @param <T> 原始类型
     * @param <R> 目标类型
     * @return 目标对象
     */
    public static <T,R> R formatBaseClass(T t,Class<R> r){

        if(r == int.class || r == Integer.class){

            return (R)(new Integer(Integer.parseInt(t.toString())));

        }else if(r == long.class || r == Long.class){

            return (R)(new Long(Long.parseLong(t.toString())));

        }else if(r == double.class || r == Double.class){

            return (R)(new Double(Double.parseDouble(t.toString())));

        }else if(r == String.class){

            return (R)t.toString();

        }else if(r == float.class || r == Float.class){

            return (R)(new Float(Float.parseFloat(t.toString())));

        }else if(r == byte.class || r == Byte.class){

            return (R)(new Byte(Byte.parseByte(t.toString())));

        }else if(r == boolean.class || r == Boolean.class){

            return (R)(new Boolean(Boolean.parseBoolean(t.toString())));

        }
        else {
            throw  new ClassCastException("无法识别当前类型！原："+t.getClass()+",目标："+r);
        }

    }

    /**
     * 将T类型转换成任意数据类型
     * @param t 原始数据
     * @param function 转换方法
     * @param <T> 原始类型
     * @param <R> 目标类型
     * @return
     */
    public static <T,R> R formateClass(T t, Function<T,R> function){
        return function.apply(t);
    }
}
