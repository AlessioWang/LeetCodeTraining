package OfferTraining;

import OfferTraining.Code.ListNode;
import OfferTraining.Code.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @auther Alessio
 * @date 2022/1/8
 **/
public class Client {
    public static void main(String[] args) {
        int[] num1 = {-10, -4, 0, 0, 6};
        int[] num2 = {3, 5, 6, 7, 8, 100};
        Questions questions = new Questions();
        System.out.println(questions.kSmallestPairs(num1, num2, 10));
    }

}
