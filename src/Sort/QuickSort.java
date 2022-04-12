package Sort;

import java.awt.*;

/**
 * @auther Alessio
 * @date 2022/4/12
 **/
public class QuickSort {

    public static void sort(int[] nums) {
        divideSort(nums, 0, nums.length-1);
    }

    private static void divideSort(int[] nums, int start, int end) {
        if (start < end) {
            int pivot = getPivot(nums, start, end);
            divideSort(nums, 0, pivot - 1);
            divideSort(nums, pivot + 1, end);
        }
    }

    /**
     * @param nums  排序的数组
     * @param start 起点
     * @param end   终点
     * @return 划分的位置
     */
    private static int getPivot(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start, j = start;
        for (; j < end; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, end);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

}
