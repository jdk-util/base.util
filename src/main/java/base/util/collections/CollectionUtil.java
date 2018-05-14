package base.util.collections;

import java.util.*;

/**
 * @Author: weixuedong
 * @Date: 2018/4/22 22:34
 * @Description:通用集合工具
 */
public class CollectionUtil {

    /**
     * 判断是否为空 空返回true否则返回false
     * @param collection 集合
     * @return 结果
     */
    public static boolean isEmpty(Collection collection){
        if(Objects.isNull(collection) || collection.isEmpty()){
            return true;
        }
        return false;
    }

    /**
     * 判断是否为空 空返回true否则返回false
     * @param collection 集合
     * @return 结果
     */
    public static boolean isNotEmpty(Collection collection){
        if(Objects.isNull(collection) || collection.isEmpty()){
            return false;
        }
        return true;
    }

    /**
     * 判断是否为空 空返回true否则返回false
     * @param collection 集合
     * @return 结果
     */
    public static boolean isEmpty(Map collection){
        if(Objects.isNull(collection) || collection.isEmpty()){
            return true;
        }
        return false;
    }

    /**
     * 判断是否为空 空返回true否则返回false
     * @param collection 集合
     * @return 结果
     */
    public static boolean isNotEmpty(Map collection){
        if(Objects.isNull(collection) || collection.isEmpty()){
            return false;
        }
        return true;
    }

}
