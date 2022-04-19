package Sort;

import OfferTraining.Code.ListNode;

import java.util.Arrays;
import java.util.List;

/**
 * @auther Alessio
 * @date 2022/4/18
 **/
public class MergeSort2 {

    public int[] mergeSort(int[] nums) {
        int[] opt = Arrays.copyOf(nums, nums.length);
        sort(nums, opt, 0, nums.length);
        return opt;
    }

    private void sort(int[] origin, int[] opt, int start, int end) {
        if (start + 1 >= end) {
            return;
        }

        int mid = (start + end) / 2;
        sort(opt, origin, start, mid);
        sort(opt, origin, mid, end);

        int i = start;
        int j = mid;
        int k = start;
        while (i < mid || j < end) {
            if (j == end || (i < mid && origin[i] < origin[j])) {
                opt[k] = origin[i];
                i++;
            } else {
                opt[k] = origin[j];
                j++;
            }
            k++;
        }
    }




}
