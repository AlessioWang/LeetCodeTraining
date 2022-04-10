package DataStructure.Tree.practice;

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

        Practice p = new Practice();
        System.out.println(p.midOrderTraversal(root));
    }
}
