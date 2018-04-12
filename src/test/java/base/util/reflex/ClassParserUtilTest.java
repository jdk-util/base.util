package base.util.reflex;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: weixuedong
 * @Date: 2018/4/8 15:27
 * @Description:
 */
public class ClassParserUtilTest {
    @Test
    public void formateBaseClass(){
        String str = "20";
        System.out.println(ClassParserUtil.formatBaseClass(str,Integer.class));
    }

    @Test
    public void otherTest(){
        List<String> strs = new ArrayList<>();
        strs.add("a");
        strs.add("b");
        strs.add("c");
        strs.stream().filter(str -> str.equals("a"));
        System.out.println(strs);
        List<String> strsNew = strs.stream().filter(str -> str.equals("a")).collect(Collectors.toList());
        System.out.println(strs);
        System.out.println(strsNew);
    }

    @Test
    public void otherTest2(){
       A a1 = new A(1,2);
       A a2 = new A(2,3);
       A a3 = new A(3,4);
       List<Object> list = Stream.builder().add(a1).add(a2).add(a3).build().collect(Collectors.toList());
       List<Object> listFind = list.stream().filter(obj -> {
            A a = (A) obj;
            return a.getA() == 1;
        }).collect(Collectors.toList());
        listFind.forEach(obj->{
            A a = (A) obj;
            a.setA(5);
        });
        System.out.println(list);
        System.out.println(listFind);
    }


    class A{
        private int a;

        private int b;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        public A(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "A{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }
}
