package OfferTraining;

import OfferTraining.Code.ListNode;
import OfferTraining.Code.Questions;

/**
 * @auther Alessio
 * @date 2022/4/18
 **/
public class ListTest {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(0);

        ListNode l2 = new ListNode(0);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        Questions q = new Questions();

        ListNode l = q.sortList(l1);
        printList(l);
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
            if (head != null)
                System.out.print(" -> ");
        }
    }
}
