package OfferTraining.Code;

import java.util.*;

/**
 * @auther Alessio
 * @date 2022/4/13
 **/
public class NewCode {

//    一、对于给定的整数数组Input[]，
//    1. 输出所有出现过的数字。
//    例：Input[] = [4,9,1,1,3,3,3,4,4]
//    输出：[1,3,4,9]

    public static void main(String[] args) {
        int[] input = {0, 0, 4, 9, 1, 1, 3, 3, 3, 4, 4};
        output3(input);
    }

    public static void output(int[] input) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> result = new LinkedList<>();
        for (int i : input) {
            if (!set.contains(i)) {
                set.add(i);
                result.add(i);
            }
        }

        System.out.println(result);
    }

//    2.	按首次出现的顺序输出所有出现过的数字。
//    例：Input[] = [4,9,1,1,3,3,3,4,4]
//    输出：[4,9,1,3]

    public static void output2(int[] input) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> result = new LinkedList<>();
        for (int i : input) {
            if (!set.contains(i)) {
                set.add(i);
                result.add(i);
            }
        }
        set.forEach(System.out::println);
    }

    //    过滤数组，当存在连续重复的数字时，去掉重复部分只保留一个。
//    例：Input[] = [4,9,1,1,3,3,3,4,4]
//    输出：[4,9,1,3,4]
    public static void output3(int[] input) {
        List<Integer> result = new LinkedList<>();
        int flag = 0;
        for (int i : input) {
            if (flag != i || flag== input[0]) {
                result.add(i);
                flag = i;
            }
        }

        System.out.println(result);
    }

//    三、设计一个函数，可以将阿拉伯数字转换成中文读法的数字。
//    例： 输入：1 输出：一
//    输入：101 输出：一百零一


    //1. 不同数位的数字需要测试
    //2. 1001， 1101， 1011 位数上有0的数字
    //3. 0-9所有的数字都需要出现在测试用例之中，以保证各个数字的输出方法都是正确的
    //4. 涉及到小数，测试小数点以及小数部分是否正确输出
    //5. 测试巨大的数字来保证汉语的数量单位规则是否正确
    //6. 测试Integer.MAXVALUE与Integer.MINVALUE是否会导致函数内部的数据溢出
    //7. 110 语言习惯问题
}
