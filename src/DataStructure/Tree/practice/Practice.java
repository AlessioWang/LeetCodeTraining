package DataStructure.Tree.practice;

import java.util.LinkedList;
import java.util.List;

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
    public void dfs(TreeNode root, List<Integer> nodes) {
        if(root != null){
            dfs(root.left, nodes);
            nodes.add(root.val);
            dfs(root.right,nodes);
        }
    }


}
