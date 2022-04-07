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
        List<String> strs = Arrays.asList("00:00","04:00","22:00");

        Questions questions = new Questions();
        int n = questions.findMinDifference(strs);

        System.out.println(n);
    }

}
