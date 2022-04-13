package Sort;

import java.util.Arrays;

/**
 * @auther Alessio
 * @date 2022/2/26
 **/
public class Client {

    public static void main(String[] args) {
        int[] array = new int[]{1,2,7,5,10,1,20,0,7,3,0};
        Selection.selSort(array);
        System.out.println(Arrays.toString(array));
    }

}
