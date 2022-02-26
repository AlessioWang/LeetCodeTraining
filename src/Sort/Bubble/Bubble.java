package Sort.Bubble;

import java.util.concurrent.RejectedExecutionHandler;

/**
 * @auther Alessio
 * @date 2022/2/26
 **/
public class Bubble {

    public static void sort(Comparable[] origin) {
        for (int i = origin.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (greater(origin[j], origin[j + 1])) {
                    exchange(origin, j, j+1);
                }
            }
        }
    }

    /**
     * a >= b，返回true
     * @param a
     * @param b
     * @return
     */
    private static boolean greater(Comparable a, Comparable b) {
        return a.compareTo(b) >= 0;
    }

    private static void exchange(Comparable[] array, int a, int b) {
        Comparable temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }


}
