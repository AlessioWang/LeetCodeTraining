package OfferTraining;

import java.util.Hashtable;

/**
 * @auther Alessio
 * @date 2022/1/10
 **/
public class QuestionCodes {
    /**
     * 不能这么写，因为没法判断s1的字母是否连续
     *
     * @param s1
     * @param s2
     * @return
     */

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        if (check(count)) {
            return true;
        } else {
            for (int i = s1.length(); i < s2.length(); i++) {
                count[s2.charAt(i - s1.length()) - 'a']++;
                count[s2.charAt(i) - 'a']--;
                if (check(count)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean check(int[] cnts) {
        for (int cnt : cnts) {
            if (cnt != 0) {
                return false;
            }
        }
        return true;
    }


    public boolean isPalindrome(String s) {
        String ss = s.replaceAll(" ", "");
        int i = 0;
        int j = ss.length() - 1;

        while (i < j) {
            while (!Character.isLetterOrDigit(ss.charAt(i)) && i < ss.length() - 2) {
                i++;
            }

            while (!Character.isLetterOrDigit(ss.charAt(j)) && j > 1) {
                j--;
            }

            char begin = ss.charAt(i);
            char end = ss.charAt(j);

            if (!Character.isLetterOrDigit(begin) && !Character.isLetterOrDigit(end)) {
                return true;
            }

            if (Character.toLowerCase(begin) != Character.toLowerCase(end)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }


}
