package base.util.object;

import java.io.*;

/**
 * @Author: weixuedong
 * @Date: 2018/4/12 15:23
 * @Description:对象Copy
 */
public class CopyUtil {
    /**
     * 对同类型数据进行复制
     * @param t 源数据
     * @param <T> 复制得类型
     * @return 被复制得新对象
     */
    public static <T extends Serializable> T copy(T  t) {
        Object obj = null;
        try {
            // Write the object out to a byte array
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(t);
            out.flush();
            out.close();

            // Make an input stream from the byte array and read
            // a copy of the object back in.
            ObjectInputStream in = new ObjectInputStream(
                    new ByteArrayInputStream(bos.toByteArray()));
            obj = in.readObject();
        }  catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
        return (T)obj;
    }
}
