package DataStructure.heap;

import java.util.PriorityQueue;

/**
 * @auther Alessio
 * @date 2022/4/18
 **/
public class HeapTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> n2 - n1);
        queue.add(0);
        queue.add(1);
        queue.add(3);
        queue.add(2);


        System.out.println(queue.peek());
    }


}
