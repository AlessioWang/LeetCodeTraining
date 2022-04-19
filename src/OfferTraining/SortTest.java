package OfferTraining;

import OfferTraining.Code.Questions;
import Sort.MergeSort;
import Sort.MergeSort2;

import java.util.Arrays;

/**
 * @auther Alessio
 * @date 2022/4/12
 **/
public class SortTest {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        MergeSort2 m = new MergeSort2();
        System.out.println(Arrays.toString(m.mergeSort(nums)));
    }
}