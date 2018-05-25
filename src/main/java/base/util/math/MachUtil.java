package base.util.math;

import base.util.collections.CollectionUtil;

import java.util.*;

/**
 * @Author: weixuedong
 * @Date: 2018/5/25 9:39
 * @Description:数学工具
 */
public class MachUtil {
    /**
     * 罗列数据中取出groupNum个数有多少组合情况
     * @param datas 数据
     * @param groupNum 需要抽取的数量
     * @param <T> 支持的数据类型
     * @return 所有组合情况 比如 5选3的所有情况 顺序不同认为是一致数据 key为第几个发现
     */
    public static <T> void groupOne(List<T> datas , int groupNum,List<T> list,Map<String,List<T>> map){
        int size =datas.size();
        if(groupNum!=0) {
            for (int i = 0; i < size; i++) {
                List<T> datasCopy = new ArrayList<>(datas);

                List<T> listCopy = new ArrayList<>(list);

                T data = datasCopy.remove(i);

                listCopy.add(data);

                groupOne(datasCopy, groupNum - 1, listCopy,map);

            }
        }else{

            map.put(UUID.randomUUID()+"",list);

        }
    }

    public static <T> Map<String,List<T>> group(List<T> datas , int groupNum){
        Map<String,List<T>> map = new LinkedHashMap<>();

        if(CollectionUtil.isNotEmpty(datas) && groupNum!=0 && datas.size()!=groupNum){

            groupOne(datas,groupNum,new ArrayList<>(),map);

            return map;
        }
        map.put(UUID.randomUUID()+"",datas);
        return map;
    }



}
