package DataStructure.tree.practice;

import javax.swing.undo.CannotUndoException;
import javax.xml.soap.Node;
import java.util.*;

/**
 * @auther Alessio
 * @date 2022/4/10
 **/
public class Practice {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<int[]> bfs(TreeNode root) {
        List<int[]> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        //判断输入的node是不是空
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] layer = new int[size];
            while (size > 0) {
                size--;
                TreeNode cur = queue.peek();
                queue.remove();
                layer[size] = cur.val;
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }

            result.add(layer);
        }

        return result;
    }

    public List<Integer> midOrderTraversal(TreeNode root) {
        //目标结果
        List<Integer> nodes = new LinkedList<>();
        dfs(root, nodes);
        return nodes;
    }

    /**
     * @param root  根节点
     * @param nodes 目标结果
     */
    private void dfs(TreeNode root, List<Integer> nodes) {
        if (root != null) {
            dfs(root.left, nodes);
            nodes.add(root.val);
            dfs(root.right, nodes);
        }
    }


    public List<Integer> stackMidTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
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


    public List<Integer> mid(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
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
