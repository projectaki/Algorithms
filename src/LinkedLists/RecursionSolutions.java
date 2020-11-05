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

    ///////////////////////////// Sum of lists reverse order

    /**
     * Initialize recursion
     * @param one Linked list head
     * @param two Linked list head
     * @return Returns new Linked list head
     */
    public Node sum(Node one, Node two) {
        return sum(one, two, 0);
    }

    /**
     * Recursive method for sum stored in linked list reverse order
     * @param one Current Node
     * @param two Current Node
     * @param carriedOver Remainder of 10 after addition
     * @return Returns the Node
     */
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


    //////////////////////////////// Sum of list normal order (not finished yet)

    /**
     * Helper class to return 2 values
     */
    private class PassBack {
        private Node tail = null;
        private int carriedOver = 0;

    }

    /**
     * Initialize recursion, Do pre-padding
     * @param one Linked list head
     * @param two Linked list head
     * @return Returns the new Linked list Node
     */
    public PassBack sumOf(Node one, Node two) {
        PassBack obj = new PassBack();
        Node shorter = getLength(one) < getLength(two) ? one : two;
        Node other = getLength(one) < getLength(two) ? two : one;
        int longerBy = Math.abs(getLength(one) - getLength(two));
        Node padded = addPadding(shorter, longerBy);
        PassBack x = sumOf(padded, other, obj);

        if (x.carriedOver != 0) {
            Node prev = new Node();
            prev.data = x.carriedOver;
            prev.next = x.tail;
            x.tail = prev;
        }
        return x;
    }

    /**
     *
     * @param one Current Node
     * @param two Current Node
     * @param obj Passed object to return
     * @return Returns obj with Node and carriedOver
     */
    public PassBack sumOf(Node one, Node two, PassBack obj) {
        if (one == null) return obj;

        PassBack pb = sumOf(one.next, two.next, obj);
        int sum = (pb.carriedOver + one.data + two.data);
        int remain = sum  % 10;

        Node prev = new Node();
        prev.data = remain;
        prev.next = pb.tail;
        pb.tail = prev;
        pb.carriedOver = sum/10;
        return pb;
    }

    /**
     * Add padding to the list
     * @param shorter Linked list head
     * @param longerBy amount of padding
     * @return Returns padded linked list head
     */
    private Node addPadding(Node shorter, int longerBy) {


        for (int i = 0; i < longerBy; i++) {
            Node prev = new Node();
            prev.data = 0;
            prev.next = shorter;
            shorter = prev;
        }
        return shorter;
    }

    /**
     * Gets length of linked list
     * @param x Linked list head
     * @return Returns size
     */
    private int getLength(Node x) {
        int size = 0;
        while (x != null) {
            size++;
            x = x.next;
        }
        return size;
    }

    ///////////////////////////////////// Palindrome

    private class Helper {
        private boolean isPalindrome = true;
        private Node compare;
    }

    public boolean isPalindrome(Node x) {
        return isPalindrome(x, getLength(x)).isPalindrome;
    }

    public Helper isPalindrome(Node x, int length) {
        if (length == 1) {
            Helper h = new Helper();
            h.compare = x.next;
            return h;
        }
        else if (length == 0) {
            Helper h = new Helper();
            h.compare = x;
            return h;
        }

        Helper helper = isPalindrome(x.next, length - 2);

        if(!x.data.equals(helper.compare.data)) {
            helper.isPalindrome = false;
            return helper;
        }
        helper.compare = helper.compare.next;
        return helper;

    }


    public static void main(String[] args) {
        RecursionSolutions<Integer> list1 = new RecursionSolutions<>();
        RecursionSolutions<Integer> list2 = new RecursionSolutions<>();
        list1.addToTail(1);
        list1.addToTail(2);
        list1.addToTail(2);
        //list1.addToTail(3);
        list1.addToTail(2);
        list1.addToTail(2);
        list1.addToTail(1);


        list1.printList();
        System.out.println(list1.isPalindrome(list1.head));







    }







}
