package DataStructure.tree;



import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @auther Alessio
 * @date 2022/2/15
 **/
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private class Node {
        public Key key;
        private Value value;
        //左侧节点，比较小
        public Node left;
        //右侧节点，比较大
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    //根节点
    private Node root;
    //元素的个数
    private int size;

    public Node getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    //向树root中插入，返回新的树
    private Node put(Node x, Key key, Value value) {
        //找不到就直接创建一个子树
        if (x == null) {
            size++;
            return new Node(key, value, null, null);
        }

        //无法直接比较的值
        int cmp = key.compareTo(x.key);

        //每次递归都是向下找子树s
        if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else {
            //找到了对节点进行替换
            x.value = value;
        }
        return x;
    }

    //整个树中进行查找
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        //循环调用，cmp的大小决定是往左右那个子树找
        if (cmp > 0) {
            return get(x.right, key);
        } else if (cmp < 0) {
            return get(x.left, key);
        } else {
            return x.value;
        }
    }

    public void delete(Key key) {
        delete(root, key);
    }

    //在子树x之中删除node，并返回新的子树
    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            x.right = delete(x.right, key);
        } else if (cmp < 0) {
            x.left = delete(x.left, key);
        } else {
            //元素个数减一
            size--;
            //找到右子树中最小的节点
            if (x.right == null) {
                return x.left;
            }

            if (x.left == null) {
                return x.right;
            }

            Node minNode = x.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }

            //删除最小的节点
            Node n = x.right;
            while (n.left != null) {
                if (n.left.left == null) {
                    n.left = null;
                } else {
                    n = n.left;
                }
            }

            minNode.left = x.left;
            minNode.right = x.right;

            x = minNode;
        }

        return x;
    }

    /**
     * 获取整个树中最小的key
     *
     * @return
     */
    public Key minKey() {
        return minKey(root).key;
    }

    //获取指定树下的最小key值的Node
    private Node minKey(Node x) {
        if (x == null) {
            return null;
        }

        while (x.left != null) {
            x = x.left;
        }

        return x;
    }

    public Key maxKey() {
        return maxKey(root).key;
    }

    //递归写法
    private Node maxKey(Node x) {
        if (x == null) {
            return null;
        }

        if (x.right != null) {
            return maxKey(x.right);
        } else {
            return x;
        }
    }

    //前序遍历
    public Queue<Key> preErgodic() {
        Queue<Key> queue = new LinkedList<Key>();
        preErgodic(root, queue);
        return queue;
    }

    //    遍历子树x中的所有节点
    private void preErgodic(Node x, Queue<Key> queue) {
        if (x == null) {
            return;
        }
        queue.add(x.key);

        if (x.left != null) {
            preErgodic(x.left, queue);
        }
        if (x.right != null) {
            preErgodic(x.right, queue);
        }
    }

    //中序遍历
    public Queue<Key> midErgodic() {
        Queue<Key> queue = new LinkedList<>();
        midErgodic(root, queue);
        return queue;
    }

    private void midErgodic(Node x, Queue<Key> queue) {
        if (x == null) {
            return;
        }

        //如果有左子树就继续往下找，没有就是node本身了
        if (x.left != null) {
            midErgodic(x.left, queue);
        }
        //实际操作，把key加入
        queue.add(x.key);

        if (x.right != null) {
            midErgodic(x.right, queue);
        }
    }

    public Queue<Key> midTraversal() {
        Queue<Key> result = new LinkedList<>();
        //记录路径
        Stack<Node> nodes = new Stack<>();
        Node cur = root;
        while (cur != null || !nodes.isEmpty()) {
            while (cur != null) {
                nodes.push(cur);
                cur = cur.left;
            }

            //反向顺着节点往回找
            cur = nodes.pop();
            result.add(cur.key);
            cur = cur.right;
        }

        return result;
    }

    public Queue<Key> myMidTraversal() {
        Stack<Node> nodes = new Stack();
        Queue<Key> result = new LinkedList<>();
        Node cur = root;

        while (cur != null || !nodes.isEmpty()) {
            while (cur != null) {
                nodes.push(cur);
                cur = cur.left;
            }

            cur = nodes.pop();
            result.add(cur.key);
            cur = cur.right;
        }

        return result;
    }

    public Queue<Key> myPreTraversal() {
        Queue<Key> result = new LinkedList<>();
        Stack<Node> nodes = new Stack<>();
        Node cur = root;

        while (cur != null || !nodes.isEmpty()) {
            while (cur != null) {
                result.add(cur.key);
                nodes.push(cur);
                cur = cur.left;
            }

            cur = nodes.pop();
            cur = cur.right;
        }

        return result;
    }

    public Queue<Key> myPostTraversal() {
        Queue<Key> result = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node pre = null;

        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.peek();
            if (cur.right == null || cur.right == pre) {
                cur = stack.pop();
                result.add(cur.key);
                pre = cur;
                cur = null;
            } else {
                cur = cur.right;
            }
        }

        return result;
    }

    //后序遍历(左 -> 右 -> 根)
    public Queue<Key> afterErgodic() {
        Queue<Key> queue = new LinkedList<>();
        afterErgodic(root, queue);
        return queue;
    }

    private void afterErgodic(Node x, Queue<Key> queue) {
        if (x == null) {
            return;
        }

        if (x.left != null) {
            afterErgodic(x.left, queue);
        }

        if (x.right != null) {
            afterErgodic(x.right, queue);
        }

        queue.add(x.key);
    }

    //层序遍历，广度优先
    public Queue<Key> layerErgodic() {
        Queue<Node> tempNodes = new LinkedList<>();
        Queue<Key> result = new LinkedList<>();
        tempNodes.add(root);

        while (!tempNodes.isEmpty()) {
            Node x = tempNodes.poll();
            result.add(x.key);

            if (x.left != null) {
                tempNodes.add(x.left);
            }
            if (x.right != null) {
                tempNodes.add(x.right);
            }
        }

        return result;
    }

    //整棵树的最大深度
    public int maxDepth() {
        return maxDepth(root);
    }

    //子树的最大深度
    public int maxDepth(Node x) {
        if (x == null) {
            return 0;
        }

        int numL = maxDepth(x.left);
        int numR = maxDepth(x.right);
        return Integer.max(numL, numR) + 1;
    }

}

