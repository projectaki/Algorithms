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

    public static void main(String[] args) {
        LinkedListMethods2<String> list1 = new LinkedListMethods2<>();
        list1.addToTail("a");
        list1.addToTail("a");
        list1.addToTail("b");
        list1.addToTail("b");
        list1.addToTail("b");
        list1.addToTail("a");
        list1.addToTail("a");
        list1.printList();
        System.out.println(list1.isLinkedListPalindrome());




    }







}
