package LinkedLists;

import java.util.Stack;

public class LinkedListMethods2<T> extends LinkedList<T> {

    /**
     * Is this linked list a palindrome
     * @return Returns true if it is a palindrome
     */
    public boolean isLinkedListPalindrome() {
        Node first = head;
        Node second = head;
        boolean isEven = false;
        boolean isPalindrome = true;
        while (first != tail & first.next != tail) {
            first = first.next.next;
            second = second.next;
        }
        if (first.next == tail) isEven = true;
        Stack<T> stack = new Stack<>();
        if (isEven) {
            first = second.next;
            for(Node x = head; x != first; x = x.next) {
                stack.add(x.data);
            }

            for(Node x = first; x != null; x = x.next) {
                T data = stack.pop();
                if (x.data != data) isPalindrome = false;
            }
        }
        else {
            first = second;
            for(Node x = head; x != first; x = x.next) {
                stack.add(x.data);
            }

            for(Node x = first.next; x != null; x = x.next) {
                T data = stack.pop();
                if (x.data != data) isPalindrome = false;
            }
        }
        return isPalindrome;

    }

    /**
     * Gets the intersection of this Linked list with another linked list
     * @param list2 The comparing linked list
     * @return Returns the Node if there is an intersection, otherwise returns null
     */
    public Node getIntersection(LinkedList<T> list2) {
        // There is an intersection
        LinkedList<T> list1 = this;
        if (list1.tail == list2.tail) {
            LinkedList<T> longer = list1.size() > list2.size() ? list1 : list2;
            LinkedList<T> shorter = list1 != longer ? list1 : list2;
            int diff = longer.size()-shorter.size();
            Node longNode = longer.head;
            Node shortNode = shorter.head;
            while (longNode != null) {
                if (--diff < 0) {
                    if (longNode == shortNode) return longNode;
                    else {
                        longNode = longNode.next;
                        shortNode = shortNode.next;
                    }
                }
                else longNode = longNode.next;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        


    }







}
