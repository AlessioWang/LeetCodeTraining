package DataStructure.Tree.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @auther Alessio
 * @date 2022/4/10
 **/
public class Practice {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> midOrderTraversal(TreeNode root) {
        //目标结果
        List<Integer> nodes = new LinkedList<>();
        dfs(root, nodes);
        return nodes;
    }

    /**
     * 
     * @param root 根节点
     * @param nodes 目标结果
     */
    private void dfs(TreeNode root, List<Integer> nodes) {
        if(root != null){
            dfs(root.left, nodes);
            nodes.add(root.val);
            dfs(root.right,nodes);
        }
    }


    public List<Integer> stackMidTraversal(TreeNode root){
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }

        return result;
    }


    public List<Integer> mid(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while(cur != null){
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
