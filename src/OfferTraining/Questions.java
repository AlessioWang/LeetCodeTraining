package OfferTraining;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @auther Alessio
 * @date 2022/3/28
 **/
public class Questions {


    //[21] 合并有序链表
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        LinkedList<ListNode> target = new LinkedList<>();

        while (list1 != null || list2 != null) {
            if (list2 == null) {
                target.add(list1);
                list1 = list1.next;
            } else if (list1 == null) {
                target.add(list2);
                list2 = list2.next;
            } else {
                if (list1.val <= list2.val) {
                    target.add(list1);
                    list1 = list1.next;
                } else {
                    target.add(list2);
                    System.out.println(list2);
                    list2 = list2.next;
                }
            }
        }

        if (!target.isEmpty()) {
            return sortList(target);
        } else {
            return null;
        }
    }

    public ListNode sortList(LinkedList<ListNode> target) {
        for (int i = 0; i < target.size() - 1; i++) {
            target.get(i).next = target.get(i + 1);
        }
        return target.get(0);
    }

    public ListNode mergeTwoListsRecursion(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    //[21] 删除链表的倒数第n个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);

        ListNode right = head;
        ListNode left = dummy;

        for (int i = 0; i < n; i++) {
            right = right.next;
        }

        while (right != null) {
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;

        return dummy.next;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode inLoop = getNodeInLoop(head);
        //不存在环
        if (inLoop == null) {
            return null;
        }

        ListNode node = head;
        while (node != inLoop) {
            node = node.next;
            inLoop = inLoop.next;
        }
        return node;
    }

    public ListNode getNodeInLoop(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        do {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            if (slow == fast) {
                return slow;
            }
        } while (slow != null && fast != null);

        return null;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        Stack<ListNode> nodes = new Stack<>();
        ListNode p = head;

        while (p != null) {
            nodes.push(p);
            p = p.next;
        }

        ListNode newHead = nodes.peek();
        ListNode temp = newHead;

        while (!nodes.isEmpty()) {
            temp.next = nodes.pop();
            temp = temp.next;
            if (nodes.isEmpty()) {
                temp.next = null;
            }
        }

        return newHead;
    }

    //[53]最大子数组和
    //动态规划
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int curSum = 0;
        int max = Integer.MIN_VALUE;

        for (int n : nums) {
            curSum = Integer.max(curSum + n, n);
            max = Integer.max(max, curSum);
        }

        return max;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.add(l2.val);
            l2 = l2.next;
        }

        ListNode nextNode = null;
        ListNode cur = null;
        int num = 0;

        while (!s1.isEmpty() || !s2.isEmpty() || num != 0) {
            int v1 = s1.isEmpty() ? 0 : s1.pop();
            int v2 = s2.isEmpty() ? 0 : s2.pop();
            ListNode temp = new ListNode(((v1 + v2) % 10 + num) % 10);
            num = (v1 + v2) / 10 + ((v1 + v2) % 10 + num) / 10;

            cur = temp;
            cur.next = nextNode;
            nextNode = temp;
        }

        return cur;
    }

}
