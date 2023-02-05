package leetcode;

public class PopulatingNextRightPointersInEachNode {
    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    private Node connect(Node root) {
        if(root == null) return null;
        if(root.left != null) root.left.next = root.right;
        if(root.right != null && root.next != null) root.right.next = root.next.left;

        connect(root.left);
        connect(root.right);
        return root;
    }

    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNode populate = new PopulatingNextRightPointersInEachNode();
        int[] arr = new int[]{1,2,3,4,5,6,7};
    }
}
