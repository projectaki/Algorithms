package TreesAndGraphs;

/**
 * Given 2 Nodes in a binary tree, find their first common ancestor
 */
public class FirstCommonAncestor {

    /**
     * Help class for passing up information in the recursive call
     */
    private static class ReturnObject {
        private Node node;
        private boolean foundFirst;
        private boolean foundSecond;
    }

    /**
     * Binary tree class
     */
    private static class Node {
        private String data;
        private Node left;
        private Node right;

        public Node() {

        }

        public Node(String d, Node l, Node r) {
            this.data = d;
            this.left = l;
            this.right = r;
        }
    }

    /**
     * Given a BT root Node, and 2 other given nodes in the BT, finds the first common ancestor
     * @param x BT root Node
     * @param givenOne First Given Node
     * @param givenTwo Second Given Node
     * @return Returns the helper class object with the FCA node of the 2 given nodes
     */
    public static ReturnObject findFCA(Node x, Node givenOne, Node givenTwo) {
        ReturnObject obj = new ReturnObject();
        if (x == givenOne) obj.foundFirst = true;
        if (x == givenTwo) obj.foundSecond = true;
        if(x.left == null && x.right == null) return obj;



        if(x.left != null) {
            ReturnObject left = findFCA(x.left, givenOne, givenTwo);
            if (left.foundFirst && left.foundSecond) return left;
            if(left.foundFirst) obj.foundFirst = true;
            if(left.foundSecond) obj.foundSecond = true;

        }
        if (obj.foundFirst && obj.foundSecond) obj.node = x;

        if(x.right != null) {
            ReturnObject right = findFCA(x.right, givenOne, givenTwo);
            if (right.foundFirst && right.foundSecond) return right;
            if(right.foundFirst) obj.foundFirst = true;
            if(right.foundSecond) obj.foundSecond = true;

        }
        if (obj.foundFirst && obj.foundSecond) obj.node = x;

        return obj;
    }


    public static void main(String[] args) {
        Node j = new Node("j", null, null);
        Node k = new Node("k", null, j);
        Node i = new Node("i", null, null);
        Node d = new Node("d", null, null);
        Node a = new Node("a", null, null);
        Node g = new Node("g", i, k);
        Node h = new Node("h", null, null);
        Node b = new Node("b", a, d);
        Node e = new Node("e", null, null);
        Node f = new Node("f", g, h);
        Node c = new Node("c", b, e);
        Node root = new Node("root", c, f);

        System.out.println(findFCA(root,k, e).node.data);

    }



}
