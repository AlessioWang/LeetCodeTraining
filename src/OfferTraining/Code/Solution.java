package OfferTraining.Code;

import DataStructure.tree.practice.Practice;
import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther Alessio
 * @date 2022/8/29
 **/
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(15);


        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
        }

        boolean flag = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] layer = new int[size];
            while (size > 0) {
                TreeNode cur = queue.peek();
                queue.remove();
                layer[size - 1] = cur.val;
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null)
                    queue.add(cur.right);
                size--;
            }

            if (!ifMirror(layer)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    //    判断一个数组是否镜像对称
    private static boolean ifMirror(int[] set) {
        int i = 0;
        int j = set.length - 1;
        boolean flag = true;

        while (i <= j && i < set.length - 1) {
            if (set[i] != set[j]) {
                flag = false;
                break;
            }
            i++;
            j--;
        }

        return flag;
    }


}
