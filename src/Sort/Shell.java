package Sort;

/**
 * @auther Alessio
 * @date 2022/3/14
 **/
public class Shell {

    public static void sort(Comparable[] a) {
        //设定增量h的长度
        int h = 1;
        while (h < a.length / 2) {
            h = 2 * h + 1;
        }
        //排序
        while (h >= 1) {
            //获取要比较的元素
            for (int i = h; i < a.length; i++) {
                //将待插入的元素比较交换到指定位置
                for (int j = i; j >= h; j -= h) {
                    if (greater(a[j - h], a[j])) {
                        exchange(a, j - h, j);
                    } else {
                        break;
                    }
                }
            }

            h = h / 2;
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
