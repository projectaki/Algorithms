package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root node of a binary tree, creates a linked list for each depth of the tree
 */
public class ListOfDepths {

    private final ArrayList<LinkedList<MinimalTree.Node>> arr = new ArrayList<>();
    private int depth = 0;

    /**
     * Helper class for adding to queue, to keep track of depth
     */
    private static class cont {
        MinimalTree.Node Node;
        int depth;
    }

    /**
     * Given a root Node of a Binary tree, fills the ArrayList with a LinkedList of each depth
     * @param root The root of the given Binary tree
     */
    public void makeLists(MinimalTree.Node root) {
        Queue<cont> queue = new LinkedList<>();
        cont temp = new cont();
        temp.Node = root;
        temp.depth = 1;
        queue.add(temp);
        LinkedList<MinimalTree.Node> list = new LinkedList<>();

        while(!queue.isEmpty()) {
            cont x = queue.poll();
            if (x.depth - 1 == depth) {
                list.add(x.Node);
            } else {
                depth += 1;
                arr.add(list);
                list = new LinkedList<>();
                list.add(x.Node);
            }

            if (x.Node.left != null ) {
                cont leftCont = new cont();
                leftCont.Node = x.Node.left;
                leftCont.depth = x.depth + 1;
                queue.add(leftCont);
            }

            if (x.Node.right != null ) {
                cont rightCont = new cont();
                rightCont.Node = x.Node.right;
                rightCont.depth = x.depth + 1;
                queue.add(rightCont);
            }
        }
        if (!list.isEmpty()) arr.add(list);
    }

    /**
     * Print each depth
     */
    public void printLists() {
        for (LinkedList<MinimalTree.Node> x : arr) {
            for (MinimalTree.Node z : x) {
                System.out.print(z.name + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        MinimalTree.Node root = new MinimalTree.Node("root");

        MinimalTree.Node one = new MinimalTree.Node("1");

        MinimalTree.Node two = new MinimalTree.Node("2");

        MinimalTree.Node three = new MinimalTree.Node("3");

        MinimalTree.Node four = new MinimalTree.Node("4");

        MinimalTree.Node five = new MinimalTree.Node("5");

        MinimalTree.Node six = new MinimalTree.Node("6");

        root.left = one;
        root.right = two;

        one.left = three;

        two.right = four;

        four.left = five;
        four.right = six;


        ListOfDepths l = new ListOfDepths();
        l.makeLists(root);
        l.printLists();
    }


}
