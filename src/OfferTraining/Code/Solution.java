package OfferTraining.Code;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.Arrays;

/**
 * @auther Alessio
 * @date 2022/8/29
 **/
public class Solution {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        String str1 = s.replaceAll("\\p{Punct}", "");
        String str = str1.replaceAll(" ", "").toLowerCase();
        char[] chars = str.toCharArray();

        int i = 0;
        int j = chars.length - 1;

        while (i <= j) {
            if (chars[i] == chars[j]) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }

}
