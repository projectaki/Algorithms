package TreesAndGraphs;

/**
 * Find the next Node in a BST
 */
public class FindNext {

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

    private static class Next {
        private Node currentNode;
        private boolean foundRight;
        private boolean foundLeft;

        public Next() {

        }

        public Next(Node cr, boolean fr, boolean fl) {
            this.currentNode = cr;
            this.foundLeft = fl;
            this.foundRight = fr;
        }
    }

    /**
     * REcursive Depth first search to find Next Node on BST
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
                return new Next(z,true,false);
            }
            // if there is no right subtree, we have to pass up true for found, but not in right subtree
            else return new Next(null,false,true);
        }
        if(x.left == null && x.right == null) return new Next(null, false, false);

        Next temp;

        if (x.left != null){
            temp = findNext(x.left, Given);
        }
        else temp = new Next(null,false,false);

        // if we found the next in right subtree then just pass it up the recursive call
        if (temp.foundRight) return temp;

        // if foundLeft == true then we set found right to true and return the current Node
        // This happens if no right or left subtree and no parent to the right, meaning we have to skip a parent
        if (temp.foundLeft) return new Next(x,true,false);

        if (x.right != null){
            temp = findNext(x.right, Given);
        }
        else temp = new Next(null,false,false);

        return temp;
    }

    public static void main(String[] args) {
        Node e = new Node(55, null, null);
        Node f = new Node(66, null, null);
        Node nine = new Node(9, null, null);
        Node seven = new Node(7, null, null);
        Node eight = new Node(8, seven, nine);
        Node five = new Node(5, null, null);
        Node three = new Node(3, null, null);
        Node one = new Node(1, e, f);
        Node six = new Node(6, five, eight);
        Node two = new Node(2, one, three);
        Node four = new Node(4,two,six);

        System.out.println(findNext(four,f).currentNode.val);
    }

}
