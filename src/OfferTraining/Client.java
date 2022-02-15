package OfferTraining;

import OfferTraining.MinSubArrayLen;

/**
 * @auther Alessio
 * @date 2022/1/8
 **/
public class Client {
    public static void main(String[] args) {
        RecentCounter rc = new RecentCounter();
        System.out.println(rc.ping(642));
        System.out.println(rc.ping(1849));
        System.out.println(rc.ping(4921));
        System.out.println(rc.ping(5936));
        System.out.println(rc.ping(5957));

    }

}
