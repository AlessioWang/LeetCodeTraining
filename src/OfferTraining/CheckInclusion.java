package OfferTraining;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther Alessio
 * @date 2022/1/14
 **/
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map1 = iniMap(s1);

        Map<Character, Integer> map2 = iniMap(s2);

        boolean flag = true;

        for (int i = 0; i < s1.length(); i++) {
            if (map1.get(s1.charAt(i)) != map2.get(s2.charAt(i))) {
                flag = false;
            }
        }

        return flag;
    }

    private Map iniMap(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int temp = map.get(s.charAt(i)) + 1;
                map.put(s.charAt(i), temp);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        return map;
    }


}
