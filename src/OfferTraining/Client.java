package OfferTraining;

import OfferTraining.Code.ListNode;
import OfferTraining.Code.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther Alessio
 * @date 2022/1/8
 **/
public class Client {
    public static void main(String[] args) {
//        int[] ast = {5,10,-5};
//        int[] ast = {10,2,-5};
//        int[] ast = {5,-5};
//        int[] ast = {-2,-2,1,-2};
        int[] ast = {73, 74, 75, 71, 69, 72, 76, 73};
        Questions questions = new Questions();
        int[] n = questions.dailyTemperatures(ast);
        System.out.println(Arrays.toString(n));
    }

}
