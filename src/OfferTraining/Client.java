package OfferTraining;

/**
 * @auther Alessio
 * @date 2022/1/8
 **/
public class Client {
    public static void main(String[] args) {
//        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(4);
//
//        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(2);
//        l2.next.next = new ListNode(3);

        ListNode l1 = new ListNode(1);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);

        Questions questions = new Questions();
        ListNode node = questions.addTwoNumbers(l1, l2);

        showList(node);
    }

    public static void showList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
