package OfferTraining.Code;

import org.w3c.dom.stylesheets.LinkStyle;

import javax.xml.stream.FactoryConfigurationError;
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
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                result[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return result;
    }

    //[496] 下一个更大的元素
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int length = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                map.put(nums2[stack.peek()], nums2[i]);
                stack.pop();
            }
            stack.push(i);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }

    //[1475]商品折扣后的最终价格
    public int[] finalPrices(int[] prices) {
        int length = prices.length;
        int[] result = new int[length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                result[stack.peek()] = prices[stack.peek()] - prices[i];
                stack.pop();
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int i = stack.pop();
            result[i] = prices[i];
        }

        return result;
    }

    //581最短无序连续子数组
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        boolean start = true;
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                if (start) {
                    left = i - 1;
                    start = false;
                }
                stack.pop();
                right = i + 1;
            }
            System.out.println("r " + right);
            stack.push(i);
        }
        System.out.println("l " + left);

        return right - left;
    }

    public int findUnsortedSubarray2(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int left = 0;
        int right = nums.length - 1;

        while (left <= nums.length - 1 && nums[left] == sorted[left]) {
            left++;
        }

        while (right >= left && nums[right] == sorted[right]) {
            right--;
        }

        return (right - left + 1);
    }

    public int findUnsortedSubarray3(int[] nums) {
        int length = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int left = 0, right = 0;

        for (int i = 0; i < length; i++) {
            if (max <= nums[i]) {
                max = nums[i];
            } else {
                right = i;
            }

            if (min >= nums[length - 1 - i]) {
                min = nums[length - 1 - i];
            } else {
                left = length - 1 - i;
            }
        }
        System.out.println("r " + right);
        System.out.println("l " + left);

        return right == left ? 0 : right - left + 1;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    //[47] 二叉树剪枝
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        } else {
            return root;
        }
    }

    //[74] 合并区间
    public int[][] merge(int[][] intervals) {
        List<int[]> resultList = new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparing(i -> i[0]));
        int num = intervals.length;
        int i = 0;
        int[] cur = null;

        while (i < num) {
            if (cur == null) {
                cur = intervals[i];
            }
            int startCur = cur[0];
            int endCur = cur[1];
            int startNext = intervals[i + 1 < num ? i + 1 : i][0];
            int endNext = intervals[i + 1 < num ? i + 1 : i][1];

            if (startCur < startNext && startNext < endCur) {
                cur = new int[]{startCur, Integer.max(endCur, endNext)};
            } else {
                resultList.add(cur);
                cur = null;
            }
            i++;
        }
        if (cur != null)
            resultList.add(cur);

        int[][] result = new int[resultList.size()][2];
        return resultList.toArray(result);
    }

    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(ints -> ints[0]));
        List<int[]> resultList = new LinkedList<>();
        int length = intervals.length;
        int i = 0;
        while (i < length) {
            int cur[] = intervals[i];
            while (i + 1 < length && cur[0] <= intervals[i + 1][0] && cur[1] >= intervals[i + 1][0]) {
                cur = new int[]{cur[0], Integer.max(intervals[i + 1][1], cur[1])};
                i++;
            }
            i++;
            resultList.add(cur);
        }
        int[][] result = new int[resultList.size()][2];
        return resultList.toArray(result);
    }

    public int[] countingSort(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i : nums) {
            min = Integer.min(min, i);
            max = Integer.max(max, i);
        }

        int[] counting = new int[max - min + 1];
        for (int i : nums) {
            counting[i - min]++;
        }

        int i = 0;
        for (int num = min; num <= max; num++) {
            while (counting[num - min] != 0) {
                nums[i] = num;
                counting[num - min]--;
                i++;
            }
        }

        return nums;
    }

    private int findPos(int[] origin, int start, int end) {
        int select = origin[end];
        int i = start;
        int j = start;
        for (; j < end; j++) {
            if (origin[j] < select) {
                exchange(origin, i, j);
                i++;
            }
        }
        exchange(origin, i, end);
        return i;
    }

    private void exchange(int[] origin, int i, int j) {
        int temp = origin[i];
        origin[i] = origin[j];
        origin[j] = temp;
    }

    //[76] 数组中的第k大的数字
    public int findKthLargest(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        int target = nums.length - k;
        int index = findPos(nums, start, end);
        while (index != target) {
            if (index < target) {
                start = index + 1;
            } else {
                end = index - 1;
            }

            index = findPos(nums, start, end);
        }
        return nums[index];
    }

    //[58] 最后一个单词的长度
    public int lengthOfLastWord(String s) {
        String[] strs = s.split(" ");
        String last = strs[strs.length - 1];
        return last.length();
    }

    public ListNode merge2List(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode cur = result;
        while (l1 != null || l2 != null) {
            if (l2 == null || (l1 != null && l1.val < l2.val)) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        result = result.next;
        return result;
    }

    public ListNode split(ListNode node) {
        ListNode slow = node;
        ListNode fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head = slow.next;
        //断开，把一个链表分成两个
        slow.next = null;
        return head;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node1 = head;
        ListNode node2 = split(head);

        node1 = sortList(node1);
        node2 = sortList(node2);

        return merge2List(node1, node2);
    }

    //[60]出现频率最高的k个数字
    public int[] topKFrequent(int[] nums, int k) {
        int[] target = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((n1, n2) -> n1.getValue() - n2.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else if (entry.getValue() > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }

        int i = 0;
        while (minHeap.iterator().hasNext()) {
            target[i] = minHeap.poll().getKey();
            i++;
        }

        return target;
    }

    //[61]和最小的k个数对
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> target = new LinkedList<>();
        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>((n1, n2) -> ((n2.get(0) + n2.get(1)) - (n1.get(0) + n1.get(1))));
        for (int j : nums1) {
            for (int value : nums2) {
                if (maxHeap.size() < k) {
                    maxHeap.offer(Arrays.asList(j, value));
                } else {
                    if (j + value < maxHeap.peek().get(0) + maxHeap.peek().get(1)) {
                        maxHeap.poll();
                        maxHeap.offer(Arrays.asList(j, value));
                    }
                }
            }
        }
        while (!maxHeap.isEmpty()) {
            target.add(maxHeap.poll());
        }
        return target;
    }

    //[68]查找插入位置
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        return nums.length;
    }

    //[69]山峰数组的顶部
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        if (arr.length == 1) {
            return 0;
        }

        if (arr.length == 0) {
            return -1;
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid == 0 || mid == arr.length - 1 || ((arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]))) {
                return mid;
            } else if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return -1;
    }

    //[70] 只出现一次的数字
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length / 2;

        while (left <= right) {
            int mid = (left + right) / 2;
            int i = mid * 2;
            if (i < nums.length - 1 && nums[i] != nums[i + 1]) {
                if (mid == 0 || nums[i - 2] == nums[i - 1]) {
                    return nums[i];
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[nums.length - 1];
    }

    //[72]求平方根
    public int mySqrt(int x) {
        int start = 0;
        int end = x;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (Math.pow(mid, 2) <= x && Math.pow((mid + 1), 2) > x) {
                return mid;
            } else if (Math.pow(mid, 2) > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    //[73]狒狒吃香蕉
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int start = 1;
        int end = piles[piles.length - 1];

        while (start <= end) {
            int mid = (start + end) / 2;
            int counter = 0;
            int before = 0;
            for (int n : piles) {
                counter += Math.ceil((double) n / mid);
                before += Math.ceil((double) n / (mid - 1));
            }

            if ((counter <= h && before > h) || (counter <= h && mid == 1)) {
                return mid;
            } else if (counter <= h) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    //[367]有效的完全平方数
    public boolean isPerfectSquare(int num) {
        long start = 0;
        long end = num;

        while (start <= end) {
            long mid = (start + end) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }

    //[34]排序数组中查找元素的第一个和最后一个位置
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int start = 0;
        int end = nums.length - 1;

        while (start <= end && Arrays.equals(result, new int[]{-1, -1})) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                result = new int[]{mid, mid};
                for (int n = mid; n <= nums.length - 1; n++) {
                    if (nums[n] == target) {
                        result[1] = n;
                    } else {
                        break;
                    }
                }
                for (int m = mid; m >= 0; m--) {
                    if (nums[m] == target) {
                        result[0] = m;
                    } else {
                        break;
                    }
                }
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    //[79]所有子集
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        dealIndex(nums, 0, new LinkedList<>(), result);
        return result;
    }

    private void dealIndex(int[] nums, int index, LinkedList<Integer> subset, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new LinkedList<>(subset));
        } else if (index < nums.length) {
            dealIndex(nums, index + 1, subset, result);
            subset.add(nums[index]);
            dealIndex(nums, index + 1, subset, result);
            subset.remove(subset.size() - 1);
        }
    }

    //[80]包含k个元素的集合
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        helper(nums, 0, k, new LinkedList<>(), result);
        return result;
    }

    private void helper(int[] nums, int index, int k, List<Integer> subset, List<List<Integer>> result) {
        if (subset.size() == k) {
            result.add(new LinkedList<>(subset));
        } else if (index <= nums.length - 1) {
            helper(nums, index + 1, k, subset, result);
            subset.add(nums[index]);
            helper(nums, index + 1, k, subset, result);
            subset.remove(subset.size() - 1);
        }
    }

    //[81] 允许重复选择元素的组合
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        helperCombine(candidates, 0, target, new LinkedList<>(), result);
        return result;
    }

    private void helperCombine(int[] nums, int index, int target, List<Integer> subset, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new LinkedList<>(subset));
        } else if (index <= nums.length - 1 && target > 0) {
            helperCombine(nums, index + 1, target, subset, result);
            subset.add(nums[index]);
            helperCombine(nums, index, target - nums[index], subset, result);
            subset.remove(subset.size() - 1);
        }
    }

    //[82]包含重复元素集合的组合
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(candidates);
        helpCom(candidates, 0, target, new LinkedList<>(), result);
        return result;
    }

    private void helpCom(int[] nums, int index, int target, List<Integer> subset, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new LinkedList<>(subset));
        } else if (target > 0 && index <= nums.length - 1) {
            helpCom(nums, getNext(nums, index), target, subset, result);
            subset.add(nums[index]);
            helpCom(nums, index + 1, target - nums[index], subset, result);
            subset.remove(subset.size() - 1);
        }
    }

    private int getNext(int[] nums, int index) {
        int cur = nums[index];
        for (int i = index; i < nums.length; i++) {
            if (cur != nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    //[83]没有重复元素集合的全排列
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        helper(nums, 0, result);
        return result;
    }

    private void helper(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length - 1) {
            List<Integer> subset = new LinkedList<>();
            for (int num : nums) {
                subset.add(num);
            }
            result.add(subset);
        } else {
            for (int j = index; j < nums.length; j++) {
                swap(nums, index, j);
                helper(nums, index + 1, result);
                swap(nums, index, j);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //[84]包含重复元素集合的全排列
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        help(nums, 0, result);
        return result;
    }

    private void help(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length - 1) {
            List<Integer> subset = new LinkedList<>();
            for (int n : nums) {
                subset.add(n);
            }
            result.add(subset);
        } else {
            Set<Integer> set = new HashSet<>();
            for (int j = index; j < nums.length; j++) {
                if (!set.contains(nums[j])) {
                    set.add(nums[j]);
                    swap(nums, index, j);
                    help(nums, index + 1, result);
                    swap(nums, index, j);
                }
            }
        }
    }

    //[85]生成匹配的括号
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        helpGen(n, n, "", result);
        return result;
    }

    private void helpGen(int left, int right, String str, List<String> result) {
        if (right == 0 && left == 0) {
            result.add(str);
        } else if (left >= 0 && right >= 0) {
            if (left > 0) {
                helpGen(left - 1, right, str + "(", result);
            }
            if (left < right) {
                helpGen(left, right - 1, str + ")", result);
            }
        }
    }

    //[86]切割回文字符串
    public String[][] partition(String s) {
        List<String[]> list = new LinkedList<>();
        dfs(s, 0, new LinkedList<>(), list);
        String[][] result = new String[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void dfs(String s, int index, List<String> strs, List<String[]> result) {
        if (index == s.length()) {
            String[] st = strs.toArray(new String[strs.size()]);
            result.add(st);
        } else {
            for (int i = index; i < s.length(); i++) {
                String sub = s.substring(index, i + 1);
                if (checkPal(sub)) {
                    strs.add(sub);
                    dfs(s, i + 1, strs, result);
                    strs.remove(strs.size() - 1);
                }
            }
        }
    }

    private boolean checkPal(String str) {
        char[] chars = str.toCharArray();
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (chars[left++] != chars[right--]) {
                return false;
            }
        }
        return true;
    }

    //[87]复原IP
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() > 12) {
            return result;
        }
        dfss(s, 0, new LinkedList<>(), result);
        return result;
    }

    public void dfss(String s, int index, List<String> cur, List<String> result) {
        if (index == s.length()) {
            if (transfer(cur) != null) {
                result.add(transfer(cur));
            }
        } else {
            for (int i = index; i < s.length(); i++) {
                String sub = s.substring(index, i + 1);
                if (checkIP(sub)) {
                    cur.add(sub);
                    dfss(s, i + 1, cur, result);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }


    public boolean checkIP(String str) {
        if (str.length() <= 3 && str.length() >= 1) {
            if (str.equals("0") || (str.charAt(0) != '0' && Integer.parseInt(str) <= 255)) {
                System.out.println(str);
                return true;
            }
        }
        return false;
    }

    public String transfer(List<String> stringList) {
        if (stringList.size() == 4) {
            StringBuilder sb = new StringBuilder(stringList.get(0));
            for (int i = 1; i < stringList.size(); i++) {
                sb.append(".");
                sb.append(stringList.get(i));
            }
            return sb.toString();
        }
        return null;
    }

    //【88】合并两个有序数组
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1;


        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[index] = nums1[i];
                i--;
            } else {
                nums1[index] = nums2[j];
                j--;
            }
            index--;
        }

        while (j >= 0) {
            nums1[index] = nums2[j];
            j--;
            index--;
        }
    }

    // [125] 验证回文字符串
    public boolean isPalindrome01(String s) {
        String str1 = s.replaceAll("\\p{Punct}", "");
        String str = str1.replaceAll(" ", "").toLowerCase();
        char[] chars = str.toCharArray();

        int i = 0;
        int j = chars.length - 1;

        while (i <= j) {
            if (chars[i] == chars[j]) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }
}


























