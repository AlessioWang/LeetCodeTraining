package OfferTraining;

import OfferTraining.Code.Questions;

import java.util.Arrays;

/**
 * @auther Alessio
 * @date 2022/4/12
 **/
public class SortTest {
    public static void main(String[] args) {
        int[] nums = {3,2,1,1,15,2,1,};
        Questions questions = new Questions();
        System.out.println(Arrays.toString(questions.countingSort(nums)));
    }
}