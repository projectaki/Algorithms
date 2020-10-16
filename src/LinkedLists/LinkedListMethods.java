package LinkedLists;

import sun.awt.image.ImageWatched;

import java.util.HashSet;
import java.util.NoSuchElementException;

/**
 * Exercise methods for linked list
 * @param <T>
 */
public class LinkedListMethods<T> extends LinkedList<T>{

    /**
     * Finds the element : k before the end
     * @param k the kth element before the end
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
/*
    private Node testAccessNode(T test) {
        Node loop = head;
        while (loop.next.data != test) {
            loop = loop.next;
        }
        return loop.next;
    }
*/

    /**
     * Removes given Node
     * @param x x is the Node we are given access to
     */
    public void removeNode(Node x) {
        Node temp = x.next;
        x.data = temp.data;
        x.next = temp.next;
    }

    /**
     * Partitions list based on the given value
     * @param val The partition value
     */
    public void partitionLinkedList(int val) {
        for (Node x = head; x != null; x = x.next) {
            if ((int)x.next.data < val) {
                Node temp = x.next;
                x.next = x.next.next;
                temp.next = head;
                head = temp;
            }
        }
    }

   

    public static void main(String[] args) {
        LinkedListMethods<Integer> list = new LinkedListMethods<>();
        list.addToTail(3);
        list.addToTail(5);
        list.addToTail(8);
        list.addToTail(5);
        list.addToTail(10);
        list.addToTail(2);
        list.partitionLinkedList(5);
        list.printList();



    }




}
