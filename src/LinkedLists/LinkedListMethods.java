package LinkedLists;

import java.util.HashSet;
import java.util.NoSuchElementException;

/**
 * Exercise methods for linked list
 * @param <T>
 */
public class LinkedListMethods<T> extends LinkedList<T>{

    /**
     * Finds the element : k before the end
     * @param k
     * @return <T>
     */
    public T findKthToLastElement(int k) {
        Node second = head;
        for (Node first = head; first != null; first = first.next) {

            if (k-- < 0) second = second.next;
        }
        assert second != null;
        return second.data;
    }

    /**
     * Removes duplicate from an unordered linked list
     */
    public void removeDuplicates() {
        HashSet<T> tracker = new HashSet<>();
        Node x = head;
        tracker.add(x.data);
        while (x.next != null) {
            if (tracker.contains(x.next.data))
            {
                x.next = x.next.next;
            }
            else {tracker.add(x.next.data); x = x.next;}
        }
    }

    /**
     * Removes duplicates from an unordered linked list without using extra space but O(n^2)
     */
    public void removeDuplicatesNoBuffer() {
        Node i = head;
        while (i != null) {
            Node j = i;
            while (j.next != null) {
                if (i.data.equals(j.next.data))
                {
                    j.next = j.next.next;
                }
                else j = j.next;
            }
            i = i.next;
        }
    }

    public static void main(String[] args) {
        LinkedListMethods<String> list = new LinkedListMethods<>();
        list.addToTail("a");
        list.addToTail("a");
        list.addToTail("b");
        list.addToTail("c");
        list.addToTail("c");
        list.addToTail("c");
        list.addToTail("d");
        list.addToTail("e");
        list.addToTail("f");
        list.addToTail("c");
        list.addToTail("f");
        list.addToTail("a");
        list.addToTail("j");
        list.addToTail("a");
        list.addToTail("b");
        list.addToTail("b");
        list.addToTail("b");
        list.printList();
        list.removeDuplicatesNoBuffer();
        list.printList();

    }




}
