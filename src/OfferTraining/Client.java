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
        int [] nums = {1,1,3};
        Questions questions = new Questions();
        System.out.println(Arrays.deepToString(questions.partition("google")));
    }

}
