package LinkedLists;

/**
 * Sum of 2 lists Recursively
 * @param
 */
public class RecursionSolutions<T> extends LinkedList<Integer>{

    ////////////////////////// KTH ELEMENT

    /**
     * Wrapper class for index
     */
    private static class Index {
        public int value = 0;
    }

    /**
     * Initialize Recursion with Index at 0
     * @param node Head of linked list
     * @param k k before linked list
     * @return Returns the kth element from the back
     */
    public Node findKthElement(Node node, int k) {
        Index index = new Index();
        return findKthElement(node, k , index);
    }

    /**
     * Recursive method
     * @param node Head
     * @param k Given k
     * @param index Index passed further
     * @return Returns Node
     */
    public Node findKthElement(Node node, int k, Index index) {
        if (node == null) return null;

        Node x = findKthElement(node.next,k, index);
        if (index.value++ == k) return node;
        return x;
    }

    ///////////////////////////// Sum of lists

    public Node sum(Node one, Node two) {
        return sum(one, two, 0);
    }

    public Node sum(Node one, Node two, int carriedOver) {
        if (one == null && two == null && carriedOver == 0) return null;

        int value = carriedOver;
        if (one != null) value += one.data;
        if (two != null) value += two.data;

        Node resultHead = new Node();
        resultHead.data = value % 10;
        int resultCarry = value >= 10 ? 1 : 0;
        Node nextOne = one == null ? null : one.next;
        Node nextTwo = two == null ? null : two.next;

        if (one != null || two != null) {
            resultHead.next = sum(nextOne,nextTwo, resultCarry);
        }
        return resultHead;
    }




    public static void main(String[] args) {
        RecursionSolutions<Integer> list1 = new RecursionSolutions<>();
        RecursionSolutions<Integer> list2 = new RecursionSolutions<>();
        list1.addToTail(6);
        list1.addToTail(1);
        list1.addToTail(7);
        list2.addToTail(2);
        list2.addToTail(3);
        list2.addToTail(5);
        list2.addToTail(9);


        System.out.println(list1.sum(list1.head,list2.head).next.next.next.next.next.data);






    }







}
