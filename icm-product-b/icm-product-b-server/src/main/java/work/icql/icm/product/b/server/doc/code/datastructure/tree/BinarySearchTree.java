package work.icql.icm.product.b.server.doc.code.datastructure.tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
    private static class Node {
        private int e;
        private Node left;
        private Node right;

        public Node(int e) {
            this.e = e;
        }
    }

    private Node root;
    private int size;

    //region 增

    public void add(int e) {
        root = add(root, e);
    }

    /**
     * 返回传入的结点
     */
    private Node add(Node node, int e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        int diff = e - node.e;
        if (diff == 0) {
            return node;
        }
        if (diff < 0) {
            node.left = add(node.left, e);
        } else {
            node.right = add(node.right, e);
        }
        return node;
    }

    //endregion

    //region 查

    public boolean contains(int e) {
        return contains(root, e);
    }

    private boolean contains(Node node, int e) {
        if (node == null) {
            return false;
        }
        int diff = e - node.e;
        if (diff == 0) {
            return true;
        }
        if (diff < 0) {
            return contains(node.left, e);
        }
        return contains(node.right, e);
    }

    //endregion

    //region 删

    public void remove(int e) {
        root = remove(root, e);
    }

    private Node remove(Node node, int e) {
        if (node == null) {
            return null;
        }
        int diff = e - node.e;
        if (diff < 0) {
            node.left = remove(node.left, e);
            return node;
        }
        if (diff > 0) {
            node.right = remove(node.right, e);
            return node;
        }
        //找到删除的结点进行删除

        //只有右结点
        if (node.left == null) {
            Node right = node.right;
            //node.right = null;
            size--;
            return right;
        }
        //只有左结点
        if (node.right == null) {
            Node left = node.left;
            size--;
            return left;
        }
        //左右结点都有

        //找到比当前结点大的最小结点进行替换
        //或者找到比当前结点小的最大结点进行替换
        Node successor = min(node.right);
        successor.right = removeMin(node.right);
        successor.left = node.left;
        node.left = node.right = null;

        return successor;
    }

    private Node min(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    //endregion

    //region 高度

    public int maxHeight() {
        return maxHeight(root);
    }

    private int maxHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxHeight(node.left), maxHeight(node.right)) + 1;
    }

    public int minHeight() {
        return minHeight(root);
    }

    private int minHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.min(maxHeight(node.left), maxHeight(node.right)) + 1;
    }

    //endregion

    //region 前序遍历

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrder1() {
        preOrder1(root);
    }

    private void preOrder1(Node node) {
        if (node == null) {
            return;
        }

        Node left = node.left;
        Node right = node.right;
        node.left = right;
        node.right = left;

        preOrder1(left);
        preOrder1(right);
    }

    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    //endregion

    //region 中序遍历

    public void midOrder() {
        midOrder(root);
    }

    private void midOrder(Node node) {
        if (node == null) {
            return;
        }
        midOrder(node.left);
        System.out.println(node.e);
        midOrder(node.right);
    }

    //endregion

    //region 后序遍历

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    //endregion

    //region 层序遍历

    public void levelOrderNR() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        levelOrder(root, queue);
    }

    public void levelOrder(Node node, Queue<Node> queue) {
        if (Objects.isNull(node)) {
            return;
        }
        queue.remove();
        System.out.println(node.e);
        queue.add(node.left);
        queue.add(node.right);
        levelOrder(node.left, queue);
        levelOrder(node.right, queue);
    }

    //endregion


    public static void main(String[] args) {
        //5
        //2 7
        //  6 8
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(2);
        tree.add(7);
        tree.add(6);
        tree.add(8);

        tree.levelOrder();

        tree.preOrder1();

        tree.levelOrder();


        //tree.preOrderNR();
        //tree.midOrder();
        //tree.postOrder();
        //tree.levelOrderNR();
        //tree.levelOrder();

    }
}
