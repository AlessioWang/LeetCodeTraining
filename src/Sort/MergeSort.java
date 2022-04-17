package Sort;

import java.util.Arrays;

/**
 * @auther Alessio
 * @date 2022/4/17
 **/
public class MergeSort {

    public int[] mergeSort(int[] origin) {
        //实际操作的数组
        int[] dst = Arrays.copyOf(origin, origin.length);
        sort(origin, dst, 0, origin.length);
        return dst;
    }

    private void sort(int[] origin, int[] dst, int start, int end) {
        //每组内部只有1个元素
        if (start + 1 >= end) {
            return;
        }

        int mid = (end + start) / 2;
        sort(dst, origin, 0, mid);
        sort(dst, origin, mid + 1, end);

        int i = start;
        int j = mid;
        int k = start;
        while (i < mid || j < end) {
            if (j == end || (origin[i] < origin[j] && i < mid)) {
                dst[k] = origin[i];
                i++;
            } else {
                dst[k] = origin[j];
                j++;
            }
            k++;
        }
    }

}
