package OfferTraining;

/**
 * @auther Alessio
 * @date 2022/1/8
 **/
public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;

        for (int p1 = 0; p1 < nums.length; p1++) {
            System.out.println("%%");
            int p2 = p1;
            while (p2 < nums.length - 1 && sums(p1, p2, nums) <= target) {
                p2++;
            }
            System.out.println(p1);
            System.out.println(p2);
            if (p2 - p1 + 1 < minLength) {
                minLength = p2 - p1 + 1;
            }

        }

        if (minLength == Integer.MAX_VALUE) {
            minLength = 0;
        }

        return minLength;
    }

    public int sums(int p1, int p2, int[] nums) {
        int result = 0;
        for (int i = p1; i <= p2; i++) {
            result += nums[i];
        }
        return result;
    }




}
