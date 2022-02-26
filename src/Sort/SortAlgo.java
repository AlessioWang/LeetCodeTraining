package Sort;

/**
 * @auther Alessio
 * @date 2022/2/25
 **/
public class SortAlgo {

    /**
     * 计数排序（桶排序的额一种）
     * 不需要比较元素的大小，通过辅助空间来排序
     *
     * @param nums
     * @return
     */
    public static int[] countingSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            max = Integer.max(max, num);
            min = Integer.min(min, num);
        }

        int[] counter = new int[Math.abs(max - min) + 1];

        for (int num : nums) {
            counter[num - min]++;
        }

        int[] result = new int[nums.length];
        int index = 0;
        int c;
        for (int i = 0; i < counter.length; i++) {
            c = counter[i];
            while (c > 0) {
                result[index] = i;
                index++;
                c--;
            }
        }

        return result;
    }


}
