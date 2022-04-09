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

//        int[] num1 = {2,6,4,8,10,9,15};
        int[] num1 = {2};
//        int[] num1 = {1,3,2,2,2};
//        int[] num1 = {1,2,3,4};
        Questions questions = new Questions();
        int n = questions.findUnsortedSubarray2(num1);
        System.out.println(n);
    }

}
