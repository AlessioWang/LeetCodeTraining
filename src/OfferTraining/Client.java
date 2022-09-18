package OfferTraining;


import java.util.*;

/**
 * @auther Alessio
 * @date 2022/1/8
 **/
public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        int[] nums = {2, 3, 4, 5, 3};

        System.out.println(client.rob(nums));
    }

    public int rob(int[] nums) {
        int length = nums.length;

        if (length == 1)
            return nums[0];
        if (length == 2)
            return Math.max(nums[0], nums[1]);

        int[] dp = new int[3];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            dp[i % 3] = Math.max((dp[(i - 2) % 3] + nums[i]), (dp[(i - 1) % 3]));
        }

        return dp[(length - 1) % 3];
    }

}
