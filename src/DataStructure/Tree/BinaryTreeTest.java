package DataStructure.Tree;


import java.nio.file.attribute.BasicFileAttributes;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther Alessio
 * @date 2022/2/19
 **/
public class BinaryTreeTest {
    public static void main(String[] args) {
        BinarySearchTree<String, String> tree = new BinarySearchTree<>();

        //put
        tree.put("e", "5");
        tree.put("g", "7");
        tree.put("b", "2");
        tree.put("a", "1");
        tree.put("d", "4");
        tree.put("f", "6");
        tree.put("h", "8");
        tree.put("c", "3");
        System.out.println("size : " + tree.getSize());


//        //search
//        System.out.println(tree.get(1));
//
//        //delete
//        tree.delete(1);
//        System.out.println(tree.get(2));
//        System.out.println(tree.getSize());
//
//        System.out.println(tree.minKey());
//        System.out.println(tree.maxKey());

//        Queue<String> queue = new LinkedList<>();
//        queue = tree.preErgodic();
//        for (String i : queue) {
//            System.out.println(i);
//        }

//        Queue<Integer> queue2 = new LinkedList<>();
//        queue2 = tree.midErgodic();
//        for (Integer i : queue2) {
//            System.out.println(i);
//        }
//
//        Queue<String> queue3 = new LinkedList<>();
//        queue3 = tree.afterErgodic();
//        for (String i : queue3) {
//            System.out.println(i);
//        }


//        Queue<String> queue3;
//        queue3 = tree.layerErgodic();
//        for (String i : queue3) {
//            System.out.println(i);
//        }

//
//        Queue<String> queue4;
//        queue4 = tree.myPostTraversal();
//        for (String i : queue4) {
//            System.out.println(i);
//        }

    }


}
