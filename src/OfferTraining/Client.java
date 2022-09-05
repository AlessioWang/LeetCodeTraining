package OfferTraining;

import java.util.*;

/**
 * @auther Alessio
 * @date 2022/1/8
 **/
public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        int[] can = {2, 3, 6, 7};
        System.out.println(client.combinationSum(can, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();

        if (candidates.length == 0) {
            return result;
        }

        backTracking39(candidates, target, 0, new LinkedList<Integer>(), result);
        return result;
    }

    public void backTracking39(int[] candidates, int target, int index, List<Integer> subset, List<List<Integer>> result) {

        if (sumAll(subset) == target) {
            result.add(new LinkedList<>(subset));
        } else if (sumAll(subset) < target && index < candidates.length) {
            backTracking39(candidates, target, index + 1, subset, result);
            subset.add(candidates[index]);
            backTracking39(candidates, target, index, subset, result);
            subset.remove(subset.size() - 1);
        }
    }

    public int sumAll(List<Integer> subset) {
        int result = 0;
        for (int n : subset) {
            result += n;
        }
        return result;
    }
}
