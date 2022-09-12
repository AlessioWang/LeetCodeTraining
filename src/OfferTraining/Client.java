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
        System.out.println(client.findKthLargest(nums, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int n : nums) {
            if (minHeap.size() < k) {
                minHeap.add(n);
            } else {
                if (minHeap.peek() < n) {
                    minHeap.poll();
                    minHeap.add(n);
                }
            }
        }

        return minHeap.peek();
    }
}
