package TreesAndGraphs;

/**
 * Given 2 binary trees, check if 1 is the subtree of the other
 */
public class CheckSubTrees {

    /**
     * Binary tree Nodes
     */
    private static class Node {
        private int val;
        private Node left;
        private Node right;

        public Node() {

        }

        public Node(int v, Node l, Node r) {
            this.val = v;
            this.left = l;
            this.right = r;
        }
    }

    /**
     * Helper class to pass up information in recursive calls
     */
    private static class CompareClass {
        private Node base;
        private Node comp;
        private boolean isEqual = true;

        public CompareClass() {

        }

        public CompareClass(Node base, Node comp, boolean isEqual) {
            this.base = base;
            this.comp = comp;
            this.isEqual = isEqual;
        }
    }

    /**
     * Takes 2 trees and checks if the second is a subtree of the first
     * @param T1 First tree
     * @param T2 Second tree
     * @return Returns true if it is a subtree
     */
    public static boolean isSubTree(Node T1, Node T2) {
        if(T1.left == null && T1.right == null) return false;

        // if we find the root of t2 tree, in t1, we call the compare trees method
        // if the trees are equal then there is a subtree and it returns true
        if(T1.val == T2.val) {
            CompareClass comp = compare(T2, T1);
            return comp.isEqual;
        }

        boolean isSub;
        if(T1.left != null) {
            isSub = isSubTree(T1.left, T2);
            if(isSub) return true;
        }

        if(T1.right != null) {
            isSub = isSubTree(T1.right, T2);
            return isSub;
        }

        return false;
    }

    /**
     * Recursive method to compare if 2 trees are equal
     * @param base Base tree
     * @param comp Tree to compare base with
     * @return Returns CompareClass object, CompareClass isEqual is true if they are equal, false if not equal
     */
    public static CompareClass compare(Node base, Node comp) {

        // if the base is at at a leaf node then return the current Node of base tree, and comp tree
        if (base.left == null && base.right == null) return new CompareClass(base, comp, true);

        CompareClass passUp = new CompareClass();


        if(base.left != null) {
            // if there is a base node on the left but no left in the comp return false, trees are not equal
            if (comp.left == null) {
                passUp.isEqual = false;
                return passUp;
            }
            // if neither has null go left branch parallel
            passUp = compare(base.left, comp.left);
            // return false if passUp was already false
            if (!passUp.isEqual) return passUp;
            // if base and comp are not equal on either left or right node, the trees are not equal and isEqual is set to false and returned
            if (passUp.base.left != passUp.comp.left || passUp.base.right != passUp.comp.right) {
                passUp.isEqual = false;
                return passUp;
            }
        }

        if (base.right != null) {
            if (comp.right == null) {
                passUp.isEqual = false;
                return passUp;
            }
            passUp = compare(base.right, comp.right);
            if (!passUp.isEqual) return passUp;
            if (passUp.base.left != passUp.comp.left || passUp.base.right != passUp.comp.right) {
                passUp.isEqual = false;
                return passUp;
            }
        }

        return passUp;
    }








    public static void main(String[] args) {

        Node one = new Node(1, null, null);
        Node two = new Node(2, one, null);
        Node three = new Node(3, null, null);
        Node four = new Node(4, two, three);


        Node cone = new Node(1, null, null);
        Node ctwo = new Node(2, cone, null);
        Node cthree = new Node(3, null, null);
        Node cfour = new Node(4, ctwo, cthree);
        Node six = new Node(6, null, null);
        Node five = new Node(5, cfour, six);


        // System.out.println(compare(base, comp).isEqual);
        System.out.println(isSubTree(five, four));





    }
}
