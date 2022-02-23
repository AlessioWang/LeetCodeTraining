package OfferTraining;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @auther Alessio
 * @date 2022/2/22
 **/
public class TreeSerialize {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        TreeNode cur = null;

        while (!nodes.isEmpty()) {
            cur = nodes.poll();
            if (cur != null) {
                nodes.add(root.left);
                nodes.add(root.right);
                sb.append(cur.val);
            }else{
                sb.append("null");
            }
            sb.append(",");
        }

        return sb.toString();
    }

}
