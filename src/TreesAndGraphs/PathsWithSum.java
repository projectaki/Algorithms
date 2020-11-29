package TreesAndGraphs;

import java.util.ArrayList;

/**
 * Class for finding the number of paths to a given number, in a Binary tree with an integer value at each node
 */
public class PathsWithSum {

    private static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node() {}

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Recursive method that prints the path number
     * @param root BT root
     * @param given Given number
     */
    public static void findPaths(Node root, int given) {
        ArrayList<Integer> paths = new ArrayList<>();
        System.out.println(findPaths(root, paths, given));
    }

    /**
     * Recursive method to find all paths of the given sum
     * @param x Current Node
     * @param paths Path sums so far
     * @param given Given value
     * @return Returns the found paths of the subtree at that node
     */
    public static int findPaths(Node x, ArrayList<Integer> paths, int given) {
        // pathsFound is the number of paths that added to given number at that level
        int pathsFound = 0;
        for (int i = 0; i < paths.size(); i++) {
            int newVal = paths.get(i) + x.value;
            paths.set(i, newVal);
            if(newVal == given) pathsFound += 1;
        }
        paths.add(x.value);
        if(x.value == given) pathsFound += 1;

        // passedUpPaths is the number of paths found in the left and right subtree of current Node
        int passedUpPaths = 0;
        if(x.left != null) {
            passedUpPaths += findPaths(x.left, paths, given);
            // backtracking
            paths.remove(paths.size() - 1);
            for (int i = 0; i < paths.size(); i++) {
                int newVal = paths.get(i) - x.left.value;
                paths.set(i, newVal);
            }
        }

        if(x.right != null) {
            passedUpPaths += findPaths(x.right, paths, given);
            paths.remove(paths.size() - 1);
            for (int i = 0; i < paths.size(); i++) {
                int newVal = paths.get(i) - x.right.value;
                paths.set(i, newVal);
            }
        }

        // return the paths found on this level and the levels below
        return passedUpPaths + pathsFound;
    }

    public static void main(String[] args) {

        Node one = new Node(2, null, null);
        Node two = new Node(1, one, null);
        Node three = new Node(3, null, null);
        Node four = new Node(10, null, null);
        Node five = new Node(1, two, three);
        Node six = new Node(-5, null, four);
        Node root = new Node(1, five, six);

        findPaths(root, 5);
    }
}
