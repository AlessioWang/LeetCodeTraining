package OfferTraining;

import OfferTraining.Code.ListNode;
import OfferTraining.Code.Questions;

/**
 * @auther Alessio
 * @date 2022/1/8
 **/
public class Client {
    public static void main(String[] args) {
        Questions questions = new Questions();
        int r = questions.countPrimeSetBits(6, 10);
        System.out.println("______");
        System.out.println(r);
    }

//    public static void main(String[] args) {
//        int n = 0;
//        int num = 9;
//        while (num != 0) {
//            num = num & (num - 1);
//            n++;
//        }
//
//        System.out.println(n);
//    }


}
