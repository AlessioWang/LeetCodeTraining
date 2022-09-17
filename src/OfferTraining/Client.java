package OfferTraining;

import com.sun.xml.internal.txw2.output.IndentingXMLFilter;
import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

import java.util.*;

/**
 * @auther Alessio
 * @date 2022/1/8
 **/
public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        int[] nums = {1, 100, 1};
        System.out.println(client.minCostClimbingStairs(nums));
    }

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < len; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        return Math.min(dp[len - 2], dp[len - 1]);
    }


}
