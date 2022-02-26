package Sort;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * @auther Alessio
 * @date 2022/2/25
 **/
public class ClientTest {

    public static void main(String[] args) {
        int[] array = new int[]{2, 5, 3, 6, 8, 1, 3};
        System.out.println(Arrays.toString(SortAlgo.countingSort(array)));
    }

}
