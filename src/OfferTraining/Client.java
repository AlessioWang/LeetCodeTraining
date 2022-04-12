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
        int[][] input = new int[4][2];
        input[0] = new int[]{4, 5};
        input[1] = new int[]{1, 3};
        input[2] = new int[]{2, 6};
        input[3] = new int[]{8, 9};

        Questions questions = new Questions();
        System.out.println(Arrays.toString(questions.merge2(input)[0]));

    }

}
