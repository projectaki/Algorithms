package TreesAndGraphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimalTree {

    private static class Node {
        private final String name;
        private Node left;
        private Node right;

        public Node(String n) {
            name = n;
        }
    }

    /**
     * Initialize Recursion
     * @param ascendingIntArray Array with ascending order
     * @return Returns root node
     */
    public static Node buildBST(int[] ascendingIntArray) {
        return buildBST(ascendingIntArray[0], ascendingIntArray[ascendingIntArray.length - 1]);
    }

    /**
     * Recursive methods
     * @param startIndex Start Index of next interval
     * @param end End Index of next interval
     * @return Returns node
     */
    public static Node buildBST(int startIndex, int end) {
        int arraySize = end - (startIndex - 1);
        int middle = findMiddle(startIndex, end);
        if(startIndex > end) return null;
        if(arraySize == 1) return new Node(Integer.toString(middle));
        Node x = new Node(Integer.toString(middle));
        x.left = buildBST(startIndex, middle - 1);
        x.right = buildBST(middle + 1, end);
        return x;
    }

    /**
     * Helper method to find the root node of an ordered array to maintain minimum height
     * @param start Start index
     * @param end End index
     * @return Returns middle entry
     */
    public static int findMiddle(int start, int end) {
        int size = end - (start - 1);
        int lastBalancedNodeNumber = 0;
        int power = 0;
        while (lastBalancedNodeNumber <= size) {
            lastBalancedNodeNumber += Math.pow(2,power++);
        }
        lastBalancedNodeNumber = lastBalancedNodeNumber - (int)Math.pow(2,--power);
        int thatLevelNodesHalf = (int)Math.pow(2,power)/2;
        int surplus = size - lastBalancedNodeNumber;
        int amountBeforeMiddle = Math.min(surplus, thatLevelNodesHalf);
        int nodesPerSide = lastBalancedNodeNumber/2;
        return start + nodesPerSide + amountBeforeMiddle;
    }

    /**
     * Helper method for getting tree height base on tree node amount
     * @param nodes Number of nodes
     * @return Returns tree s height
     */
    public static int getTreeHeight(int nodes) {
        int height = 0;
        int power = 0;
        int sum = 0;
        while (sum < nodes) {
            sum += Math.pow(2,power++);
            height++;
        }
        return height;
    }

    /**
     * Funky print method to print tree (really whacky)
     * @param root Root node
     * @param nodes Number of nodes
     */
    public static void BFSPrint(Node root, int nodes) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int power = 0;
        int counter = 0;
        double treeHeight = getTreeHeight(nodes) * 5;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < treeHeight; i++) {
            sb.append(" ");
        }
        treeHeight--;
        System.out.print(sb.toString());
        while (!queue.isEmpty()) {
            Node x = queue.poll();
            System.out.print(x.name + ", ");
            if (++counter == Math.pow(2,power)) {
                System.out.println();
                StringBuilder nsb = new StringBuilder();
                for (int i = 0; i < treeHeight; i++) {
                    nsb.append(" ");
                }
                treeHeight--;
                System.out.print(nsb.toString());
                counter = 0;
                power++;
            }


            if (x.left != null) queue.add(x.left);
            if (x.right != null) queue.add(x.right);
        }
    }


    public static void main(String[] args) {
        int size = 100;
        int counter = 1;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = counter++;
        }
        Node root = buildBST(arr);
        BFSPrint(root, arr.length);
        //System.out.println(findMiddle(1,2));


    }

}
