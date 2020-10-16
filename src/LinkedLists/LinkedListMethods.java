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

   public static LinkedList<Integer> sumOf2Numbers(LinkedList<Integer> list1, LinkedList<Integer> list2) {
       int list1CurrentVal;
       int list2CurrentVal;
       int carriedOver = 0;
       LinkedList<Integer> sumList = new LinkedList<>();
       LinkedList<Integer>.Node i = list1.head;
       LinkedList<Integer>.Node j = list2.head;
       while(i != null | j != null) {
           if (i == null) list1CurrentVal = 0;
           else list1CurrentVal = i.data;
           if (j == null) list2CurrentVal = 0;
           else list2CurrentVal = j.data;
           int currentSum = carriedOver + list1CurrentVal + list2CurrentVal;
           sumList.addToTail((currentSum)%10);
           carriedOver = currentSum/10;
           if (i != null) i = i.next;
           if (j != null) j = j.next;
       }
       if (carriedOver != 0) sumList.addToTail(carriedOver);
       return  sumList;
   }

    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedListMethods<>();
        LinkedList<Integer> list2 = new LinkedListMethods<>();
        list1.addToTail(9);
        list1.addToTail(7);
        list1.addToTail(8);
        list2.addToTail(6);
        list2.addToTail(8);
        list2.addToTail(5);



        list1.printList();
        list2.printList();
        LinkedList<Integer> sumList = sumOf2Numbers(list1,list2);
        sumList.printList();



    }




}
