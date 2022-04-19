package DataStructure.heap;

import java.util.LinkedList;
import java.util.List;

/**
 * @auther Alessio
 * @date 2022/4/18
 **/
public class Lambda {
    public static void main(String[] args) {
        List list = new LinkedList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        list.forEach(a -> System.out.println("tt" + a));
    }
}
