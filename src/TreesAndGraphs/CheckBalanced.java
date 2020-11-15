package TreesAndGraphs;

/**
 * Implementation to check if a given Binary tree is balanced
 */
public class CheckBalanced {

    private static class Node {
        private String name;
        private Node left;
        private Node right;

        public Node() {

        }

        public Node(String n) {
            this.name = n;
        }

        public Node(String n, Node l, Node r) {
            this.name = n;
            this.left = l;
            this.right = r;
        }
    }
    protected static class Checker {
        protected boolean isBalanced;
        protected int leftHeight;
        protected int rightHeight;

        public Checker() {

        }

        public Checker(boolean isBalanced, int leftHeight, int rightHeight) {
            this.isBalanced = isBalanced;
            this.leftHeight = leftHeight;
            this.rightHeight = rightHeight;
        }
    }

    /**
     * Given a root Node of a Binary tree, it checks if it is balanced (if at any node the subtrees length differs by at most 1)
     * @param x Root of Binary tree
     * @return Returns Checker class, with isBalanced boolean
     */
    public static Checker checkBalanced(Node x) {
        if (x.left == null && x.right == null) return new Checker(true, 0, 0);

        Checker checker = new Checker(true, 0, 0);
        if (x.left == null) checker.leftHeight = 0;
        else {
            Checker left = checkBalanced(x.left);
            checker.leftHeight = left.leftHeight + left.rightHeight + 1;
            checker.isBalanced = left.isBalanced;
        }

        if (x.right == null) checker.rightHeight = 0;
        else {
            Checker right = checkBalanced(x.right);
            checker.rightHeight = right.rightHeight + right.leftHeight + 1;
            if (!right.isBalanced) checker.isBalanced = false;
        }

        if(!checker.isBalanced) return checker;
        checker.isBalanced = Math.abs(checker.leftHeight - checker.rightHeight) == 1 || Math.abs(checker.leftHeight - checker.rightHeight) == 0;

        return checker;
    }

    public static void main(String[] args) {

        Node nine = new Node("eight");
        Node eight = new Node("eight");
        Node seven = new Node("seven", null, null);
        Node six = new Node("six", null, null);
        Node five = new Node("five");
        Node four = new Node("four", null, null);
        Node three = new Node("three", null, null);
        Node two = new Node("two", null, null);
        Node one = new Node("one", null, null);
        Node root = new Node("root", one, two);

        System.out.println(checkBalanced(root).isBalanced);
    }




}
