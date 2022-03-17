package Sort;

import java.util.Arrays;

/**
 * @auther Alessio
 * @date 2022/2/26
 **/
public class Client {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,2,7,5,10,1,0};
        Shell.sort(array);
        System.out.println(Arrays.toString(array));
    }

}
