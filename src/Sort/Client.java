package Sort;

import Sort.Bubble;

import java.util.Arrays;

/**
 * @auther Alessio
 * @date 2022/2/26
 **/
public class Client {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{10,2,4,3,4,6,1,0};
        Selection.sort(array);
        System.out.println(Arrays.toString(array));
    }

}
