package Sort;

import OfferTraining.MinSubArrayLen;

import javax.print.attribute.standard.JobOriginatingUserName;

/**
 * 选择排序
 * 时间复杂度为O（n^2）
 * @auther Alessio
 * @date 2022/2/26
 **/
public class Selection {

    public static void sort(Comparable[] origin) {
        //i 表示当前数组最前面的元素的下标
        for (int i = 0; i < origin.length - 1; i++) {
            int indexMin = i;
            //找到剩余数组最小元素的下标
            for (int j = i + 1; j < origin.length; j++) {
                if (greater(origin[indexMin], origin[j])) {
                    indexMin = j;
                }
            }
            exchange(origin, i, indexMin);
        }

    }

    private static boolean greater(Comparable a, Comparable b) {
        return a.compareTo(b) >= 0;
    }

    private static void exchange(Comparable[] array, int a, int b) {
        Comparable temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }


}
