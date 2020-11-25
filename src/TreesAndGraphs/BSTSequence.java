package TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This implementation prints all of the arrays that would result in a 1 b1 1 add to the given BST
 */
public class BSTSequence {

    private static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node() {

        }

        public Node(int v, Node l, Node r) {
            this.value = v;
            this.left = l;
            this.right = r;
        }
    }

    public static void printPerm(Node root) {
        HashMap<Integer, Node> newOptions = new HashMap<>();
        ArrayList<Integer> arraySoFar = new ArrayList<>();
        printPerm(root, newOptions, arraySoFar);
    }

    public static void printPerm(Node x, HashMap<Integer, Node> newOptions, ArrayList<Integer> arraySoFar) {
        HashMap<Integer, Node> temp = new HashMap<>(newOptions);
        if(x.left != null) temp.put(x.left.value, x.left);
        if(x.right != null) temp.put(x.right.value, x.right);

        arraySoFar.add(x.value);
        temp.remove(x.value);

        if(temp.isEmpty()){
            System.out.println(arraySoFar);
            return;
        }

        for(Node z : temp.values()) {
            printPerm(z, temp, arraySoFar);
            arraySoFar.remove(arraySoFar.size() - 1);
        }
    }

    public static void main(String[] args) {

        Node one = new Node(1, null, null);
        Node five = new Node(5, null, null);
        Node two = new Node(2, one, null);
        Node four = new Node(4, null, five);
        Node three = new Node(3, two, four);

        printPerm(three);
    }


}
