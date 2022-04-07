package OfferTraining.Code;

import java.awt.geom.Area;
import java.util.*;

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

    //[24]
    public boolean hasCycle(ListNode head) {
        ListNode n = head;
        HashSet set = new HashSet();

        while (n != null) {
            if (!set.contains(n)) {
                set.add(n);
            } else {
                return true;
            }
            n = n.next;
        }

        return false;
    }

    public boolean hasCycle2(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = dummy.next;
        ListNode slow = dummy;

        while (fast != null && slow != null) {
            if (fast == slow) {
                return true;
            }

            if (fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                break;
            }
        }

        return false;
    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }

        return (n & (n - 1)) == 0 && (n % 3 == 1);
    }

    public int hammingWeight(int n) {
        int counter = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                counter++;
            }
        }
        return counter;
    }

    public int[] swapNumbers(int[] numbers) {
        int a = numbers[0];
        int b = numbers[1];

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        return new int[]{a, b};
    }

    public int singleNumber(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = nums[i] ^ sum;
        }
        return sum;
    }

    public boolean hasAlternatingBits(int n) {
        while (n != 0) {
            if (((n & 3) == 2) || ((n & 3) == 1)) {
                n = n >> 1;
            } else {
                return false;
            }
        }
        return true;
    }

    public int countPrimeSetBits(int left, int right) {
        int result = 0;
        for (int i = left; i < right; i++) {
            //有几个计算置位
            int n = 0;

            int num = i;
            //消掉几个1
            while (num != 0) {
                num = num & (num - 1);
                n++;
            }
            System.out.println(n);

            //检测n是不是质数
            if (check(n)) {
                result++;
            }
        }

        return result;
    }

    private boolean check(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i < n - 1; i++) {
            double r = n % i;
            if (r == 0) {
                return false;
            }
        }
        return true;
    }

    public int countPrimes(int n) {
        int counter = 0;
        for (int i = 0; i < n; i++) {
            if (checkPrimes(i)) {
                counter++;
            }
        }
        return counter;
    }

    private boolean checkPrimes(int n) {
        if (n < 2 || (n % 2 == 0) && n > 2) {
            return false;
        }

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int singleNumber2(int[] nums) {
        int[] counter = new int[32];

        for (int i = 0; i < nums.length; i++) {
            int j = 0;
            int num = nums[i];
            while (num != 0) {
                counter[j] += num % 2;
                num /= 2;
                j++;
            }
        }

        int result = 0;
        for (int i = 0; i < counter.length; i++) {
            result += (counter[i] % 3) * (1 << i);
        }

        return result;
    }

    //[39] 直方图最大矩形面积
    public int largestRectangleAreaRaw(int[] heights) {
        int start = 0;
        int maxArea = Integer.MIN_VALUE;
        for (; start < heights.length; start++) {
            int h = Integer.MAX_VALUE;
            for (int end = start; end < heights.length; end++) {
                h = h < heights[end] ? h : heights[end];
                int w = end - start + 1;
                maxArea = maxArea > h * w ? maxArea : h * w;
            }
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        return smallest(heights, 0, heights.length);
    }

    private int smallest(int[] heights, int start, int end) {
        if (start == end) {
            return 0;
        }

        if (start + 1 == end) {
            return heights[start];
        }

        int shortest = Integer.MAX_VALUE;
        int index = 0;
        for (int i = start; i < end; i++) {
            int h = heights[i];
            if (shortest > h) {
                shortest = h;
                index = i;
            }
        }

        int curArea = shortest * (end - start);
        int leftArea = smallest(heights, 0, index);
        int rightArea = smallest(heights, index + 1, end);

        return Integer.max(curArea, Integer.max(leftArea, rightArea));
    }


    public int largestRectangleAreaStack(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        //初始化栈
        Stack<Integer> positions = new Stack<>();
        positions.push(-1);

        for (int i = 0; i < heights.length; i++) {
            while (positions.peek() != -1 && heights[i] <= heights[positions.peek()]) {
                int h = heights[positions.pop()];
                int w = i - positions.peek() - 1;
                maxArea = Integer.max(w * h, maxArea);
            }
            positions.push(i);
        }

        while (positions.peek() != -1) {
            maxArea = Integer.max(maxArea, heights[positions.pop()] * (heights.length - positions.peek() - 1));
        }

        return maxArea;
    }

    public boolean isAlienSorted(String[] words, String order) {
        char[] orders = order.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        //初始化顺序表
        for (int i = 0; i < orders.length; i++) {
            map.put(orders[i], i);
        }

        int length = words.length;
        for (int i = 0; i < length - 1; i++) {
            String former = words[i];
            String later = words[i + 1];

            if (former.equals(later)) {
                return true;
            }

            //比较两个字母的顺序
            int pos = 0;
            int v1 = map.get(former.charAt(pos));
            int v2 = map.get(later.charAt(pos));

            while (v1 == v2) {
                pos++;
                if (pos == former.length()) {
                    v1 = Integer.MIN_VALUE;
                } else {
                    v1 = map.get(former.charAt(pos));
                }

                if (pos == later.length()) {
                    v2 = Integer.MIN_VALUE;
                } else {
                    v2 = map.get(later.charAt(pos));
                }
            }

            if (v1 > v2) {
                return false;
            }
        }

        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<Integer, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] record = new int[26];

            for (int i = 0; i < s.length(); i++) {
                record[s.charAt(i) - 'a']++;
            }

            if (map.containsKey(Arrays.hashCode(record))) {
                map.get(Arrays.hashCode(record)).add(s);
            } else {
                List<String> stringList = new ArrayList<>();
                stringList.add(s);
                map.put(Arrays.hashCode(record), stringList);
            }
        }

        List<List<String>> result = new LinkedList<>(map.values());

        return result;
    }

    public int findMinDifference(List<String> timePoints) {
        //时间转换为分钟
        int[] times = new int[timePoints.size() + 1];
        times[times.length - 1] = Integer.MAX_VALUE;
        for (int i = 0; i < times.length - 1; i++) {
            times[i] = transferMinute(timePoints.get(i));
        }
        //将时间进行排序
        Arrays.sort(times);
        times[times.length - 1] = times[0];

        int minTime = Integer.MAX_VALUE;
        for (int i = 0; i < times.length - 1; i++) {
            int t1 = times[i];
            int t2 = times[i + 1];
            int gap = Integer.min(Math.abs(t2 - t1), 24 * 60 - Math.abs(t2 - t1));
            minTime = Integer.min(minTime, gap);

        }

        return minTime;
    }

    private int transferMinute(String time) {
        String[] strs = time.split(":");
        return Integer.parseInt(strs[0]) * 60 + Integer.parseInt(strs[1]);
    }

    //[37]小星星碰撞
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i : asteroids) {
            if (stack.isEmpty() || !(stack.peek() > 0 && i < 0)) {
                stack.push(i);
            } else {
                int pushNum = 0;
                while (!stack.isEmpty() && stack.peek() * i < 0) {
                    int last = stack.pop();
                    if (Math.abs(last) < Math.abs(i)) {
                        pushNum = i;
                    } else if (Math.abs(last) == Math.abs(i) && last * i < 0) {
                        pushNum = 0;
                        break;
                    } else {
                        pushNum = last;
                        break;
                    }
                }
                if (pushNum != 0) {
                    stack.push(pushNum);
                }
            }
        }
        return stack.stream().mapToInt(a -> a).toArray();
    }

    //[38]每日温度
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MIN_VALUE);



        return result;
    }

}

























