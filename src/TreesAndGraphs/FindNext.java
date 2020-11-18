package TreesAndGraphs;

/**
 * Find the next Node in a BST
 */
public class FindNext {

    /**
     * Binary tree
     */
    private static class Node {
        private int val;
        private Node left;
        private Node right;

        public Node() {

        }

        private Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Helper class for passing up recursive calls
     */
    private static class Next {
        private Node currentNode;
        private boolean passUp;
        private boolean passUpWithoutRightSubTree;

        public Next() {

        }

        public Next(Node cr, boolean fr) {
            this.currentNode = cr;
            this.passUp = fr;
        }

        public Next(Node cr, boolean fr, boolean fl) {
            this.currentNode = cr;
            this.passUp = fr;
            this.passUpWithoutRightSubTree = fl;
        }
    }

    /**
     * Recursive Depth first search to find Next Node on BST
     * @param x Root of BST
     * @param Given Node to find the successor for
     * @return Returns the next Node
     */
    public static Next findNext(Node x, Node Given) {
        // If we found a the given Node
        if(x == Given) {
            // if the found node has a right subtree find the minimum (most left node)
            if(x.right != null) {
                Node z = x.right;
                while (z.left != null) {
                    z = z.left;
                }
                // return most left Node, found right subtree = true
                return new Next(z,true);
            }
            // if there is no right subtree, we have to pass up true for found, but not in right subtree
            else return new Next(null,false,true);
        }
        if(x.left == null && x.right == null) return new Next(null, false);

        Next temp;

        if (x.left != null){
            temp = findNext(x.left, Given);
        }
        else temp = new Next(null,false);

        // if we found the next in right subtree then just pass it up the recursive call
        if (temp.passUp) return temp;

        // if we are after a left search and we found in not right subtree, then we just return x, and set isRightSUb tree
        // to true to pass it up
        if (temp.passUpWithoutRightSubTree) return new Next(x,true);

        if (x.right != null){
            temp = findNext(x.right, Given);
        }
        else temp = new Next(null,false);

        // if we found the next in right subtree then just pass it up the recursive call
        if (temp.passUp) return temp;

        // if we are after right search and we have a found but not in right subtree, then we cant go right,
        // we have to go one up the recursive call, and then one up again, then return x;
        // this is done by just setting the notRightSubtree to true again, which in the one up level will set the rightSub to true
        // which will return the correct x
        if (temp.passUpWithoutRightSubTree) return new Next(x,false,true);

        return temp;
    }

    public static void main(String[] args) {
        //Node e = new Node(55, null, null);
        //Node f = new Node(66, null, null);
        Node nine = new Node(9, null, null);
        Node seven = new Node(7, null, null);
        Node eight = new Node(8, seven, nine);
        Node five = new Node(5, null, null);
        Node three = new Node(3, null, null);
        Node one = new Node(1, null, null);
        Node six = new Node(6, five, eight);
        Node two = new Node(2, one, three);
        Node four = new Node(4,two,six);

        System.out.println(findNext(four,three).currentNode.val);
    }

}
