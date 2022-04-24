package binarySearch;

/**
 * @auther Alessio
 * @date 2022/4/24
 **/
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5};
        int target = 4;
        System.out.println(search(nums, target, 0, nums.length));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static int search(int[] nums, int target, int start, int end) {
        int mid = (start + end) / 2;

        //结束递归条件
        if (start > end) {
            return -1;
        }

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return search(nums, target, mid+1, end);
        } else {
            return search(nums, target, start, mid-1);
        }

    }


}
