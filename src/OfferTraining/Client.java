package OfferTraining;

import com.sun.xml.internal.txw2.output.IndentingXMLFilter;

import java.util.*;

/**
 * @auther Alessio
 * @date 2022/1/8
 **/
public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        int[] nums = {3, 2, 1, 5, 6, 6, 4};
        System.out.println(client.nthUglyNumber(325));
    }

    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        HashSet<Integer> set = new HashSet<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        set.add(1);
        heap.add(1);

        int ugly = 0;

        for (int i = 0; i < n; i++) {
            int cur = heap.poll();
            ugly = cur;

            for (int factor : factors) {
                int next = cur * factor;
                if (set.add(next)) {
                    heap.add(next);
                }
            }
        }

        return ugly;
    }


}
