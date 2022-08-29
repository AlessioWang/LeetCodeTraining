package OfferTraining;

import OfferTraining.Code.ListNode;

import java.util.List;

/**
 * @auther Alessio
 * @date 2022/1/14
 **/
public class TestClient {

    public static void main(String[] args) {

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = v1 + v2 + carry;

            carry = sum / 10;
            int value = sum - carry * 10;
            cur.next = new ListNode(value);

            if (l1.next != null) {
                l1 = l1.next;
            }
            if (l2.next != null) {
                l2 = l2.next;
            }

            cur = cur.next;
        }

        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }


}
