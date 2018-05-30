package base.util.string;

import java.util.Objects;

/**
 * @Author: weixuedong
 * @Date: 2018/5/28 10:14
 * @Description:
 */
public class StringUtil {
    /**
     * 空返回true null||""
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        if(Objects.isNull(str) || "".equals(str)){
            return true;
        }
        return false;
    }

    /**
     * 空返回false null||""
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str){
        if(Objects.isNull(str) || "".equals(str)){
            return false;
        }
        return true;
    }
}
