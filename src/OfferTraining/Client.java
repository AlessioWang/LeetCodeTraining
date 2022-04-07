package OfferTraining;

import OfferTraining.Code.ListNode;
import OfferTraining.Code.Questions;

/**
 * @auther Alessio
 * @date 2022/1/8
 **/
public class Client {
    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 6, 2, 3};
        String[] words = {"apple","app"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        Questions questions = new Questions();
        boolean b = questions.isAlienSorted(words, order);

        System.out.println(b);
    }

}
