package OfferTraining;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther Alessio
 * @date 2022/2/10
 **/
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        int length = s.length();

        if (s.length() != t.length() || s.equals(t)) {
            return false;
        }

        HashMap map = new HashMap();
        for (int i = 0; i < length; i++) {
            map.put(s.charAt(i), (int) map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), (int) map.getOrDefault(t.charAt(i), 0) - 1);
        }

        return check(map);
    }

    private boolean check(Map map) {
        for(Object v :map.values()){
            if(!v.equals(0)){
                return false;
            }
        }
        return true;
    }
}