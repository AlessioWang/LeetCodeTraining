package DataStructure.tree.practice;

import javax.xml.soap.Node;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @auther Alessio
 * @date 2022/4/10
 **/
public class Test {
    public static void main(String[] args) {
        Practice.TreeNode root = new Practice.TreeNode(5);
        Practice.TreeNode rootL = new Practice.TreeNode(3);
        Practice.TreeNode rootR = new Practice.TreeNode(6);
        root.left = rootL;
        root.right = rootR;
        rootL.left = new Practice.TreeNode(2);
        rootL.right = new Practice.TreeNode(4);
        rootR.left = new Practice.TreeNode(5);

        Practice p = new Practice();
        System.out.println(Arrays.toString(p.bfs(root).get(2)));
    }


    public static List<Integer> inOrderTraversal(Practice.TreeNode root) {
        List<Integer> result = new LinkedList<>();
        dfsInOrder(root, result);
        return result;
    }

    private static void dfsInOrder(Practice.TreeNode root, List<Integer> nodes) {
        if (root != null) {
            dfsInOrder(root.left, nodes);
            nodes.add(root.val);
            dfsInOrder(root.right, nodes);
        }
    }

    public static List<Integer> traStack(Practice.TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<Practice.TreeNode> stack = new Stack<>();
        Practice.TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }

        return result;
    }
}
