package OfferTraining.Code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther Alessio
 * @date 2022/2/13
 **/
public class RecentCounter {

    int gap = 3000;
    Queue<Integer> counter;

    public RecentCounter() {
        counter = new LinkedList<>();
    }

    public int ping(int t) {
        if (counter.size() == 0) {
            counter.add(t);
            return counter.size();
        }

        if ((t - counter.peek()) < gap) {
            counter.add(t);
        } else {
            while ((t - counter.peek()) > gap) {
                counter.poll();
                if (counter.size() == 0)
                    break;
            }
            counter.add(t);
        }
        return counter.size();
    }
}
