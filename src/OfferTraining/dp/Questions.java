package OfferTraining.dp;

/**
 * @auther Alessio
 * @date 2022/9/17
 **/
public class Questions {

    //[offer 88] 爬楼梯
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

    //[509]斐波那契数列
    public int fib(int n) {
        int[] dp = new int[n + 1];
        if (n == 0) return 0;

        if (n == 1) return 1;

        if (n > 1) {
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 1;
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    //三步问题
    public int waysToStep(int n) {
        int[] dp;
        if (n < 4) {
            dp = new int[4];
        } else {
            dp = new int[n + 1];
        }


        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n] % 1000000007;
    }

    //[offer 89]房屋偷盗
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
