package Sort;

import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * 自己练习又写一遍
 * @auther Alessio
 * @date 2022/4/12
 **/
public class QuickSort2 {
    public static void sort(int[] nums) {
        divideArray(nums, 0, nums.length - 1);
    }

    private static void divideArray(int[] nums, int start, int end) {
        if (start < end) {
            int pivotPos = findPivotPos(nums, start, end);
            divideArray(nums, 0, pivotPos - 1);
            divideArray(nums, pivotPos + 1, end);
        }
    }

    private static int findPivotPos(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start, j = start;
        for (; j < end; j++) {
            if (nums[j] < pivot) {
                exchange(nums, i, j);
                i++;
            }
        }
        //换到pivot本身应该在的位置
        exchange(nums, i, end);
        return i;
    }

    private static void exchange(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
