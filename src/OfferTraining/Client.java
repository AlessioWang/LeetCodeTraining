package OfferTraining;

import java.util.*;

/**
 * @auther Alessio
 * @date 2022/1/8
 **/
public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        int[] can = {2, 3, 6, 7};

        System.out.println(client.add(5, 7));
        System.out.println(client.add2(3, 34));
    }

    //^相当于无进位的加法
    //&相当于求每一位的进位数
    //（a^b）^((a&b)<<1)
    public int add(int a, int b) {
        if (b == 0) return a;
        return add((a ^ b), ((a & b) << 1));
    }

    public int add2(int a, int b) {
        while (b != 0) {
            int carry = (a & b);
            a = (a ^ b) ^ carry;
            b = carry << 1;
        }

        return a;
    }

}
