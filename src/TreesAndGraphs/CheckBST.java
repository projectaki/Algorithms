package TreesAndGraphs;

/**
 * Check if a given binary tree is a Binary search tree
 */
public class CheckBST {

    private static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node() {

        }

        public Node(int val, Node left, Node right) {
            this.value = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Helper class for passing up information in recursive call, the current Nodes value, current nodes subtree min/max
     * and a bool if the tree is a BST so far
     */
    private static class Params {

        boolean isTreeBst;
        int val;
        int treeMin;
        int treeMax;

        public Params() {

        }

        public Params(boolean isBst) {
            this.isTreeBst = isBst;
        }

        public Params(boolean isBst, int val, int min, int max) {
            this.isTreeBst = isBst;
            this.val = val;
            this.treeMin = min;
            this.treeMax = max;
        }
    }

    /**
     * Given a root Node of a Binary tree, checks if it is a Binary search tree
     * @param x The given root Node
     * @return Returns a Params object, Params.isTreeBst is true if it is a BST
     */
    public static Params checkBST(Node x) {
        if (x.left == null && x.right == null) return new Params(true, x.value, x.value, x.value);

        Params currentNode = new Params();
        Params left;
        Params right;

        if (x.left == null) {
            left = new Params(true, x.value, x.value, x.value);
        }
        else {
            left = checkBST(x.left);
        }
        if (x.right == null) right = new Params(true, x.value, x.value, x.value);
        else {
            right = checkBST(x.right);
        }

        if (!left.isTreeBst || !right.isTreeBst) return new Params(false);
        currentNode.val = x.value;
        if(left.val <= x.value && x.value <= right.val && left.treeMax <= x.value && x.value <= right.treeMin) currentNode.isTreeBst = true;
        currentNode.treeMin = left.treeMin;
        currentNode.treeMax = right.treeMax;
        return currentNode;
    }

    public static void main(String[] args) {

        Node eight = new Node(8, null, null);
        Node six = new Node(6, null, null);
        Node seven = new Node(7, six, eight);
        Node four = new Node(4, null, null);
        Node one = new Node(1, null, null);
        Node two = new Node(2, one, null);
        Node three = new Node(3, two, four);
        Node root = new Node(5, three, seven);

        System.out.println(checkBST(root).isTreeBst);
    }





}
