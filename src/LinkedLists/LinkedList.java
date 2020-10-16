package LinkedLists;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Singly linked list implementation
 * @param <T>
 */
public class LinkedList<T> implements Iterable<T>{

    protected Node head;
    protected Node tail;

    /**
     *  inner class node for linked list nodes
     */
    protected class Node {
        protected T data;
        protected Node next;

        public Node() {

        }

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * Adds the @param to the end of the list
     * @param data Generic data to add to list
     *
     */
    public void addToTail(T data) {
        Node x = new Node(data);
        if (head == null) {
            head = tail = x;
            return ;
        }
        tail.next = x;
        tail = x;
    }

    /**
     * Adds the @param to then head of the list
     * @param data
     */
    public void addToHead(T data) {
        Node x = new Node(data);
        if (head == null) {
            head = tail = x;
            return;
        }
        x.next = head;
        head = x;
    }

    /**
     *  Removes and returns the head of the list
     * @return <T>
     */
    public T removeHead() {
        if(head == null) throw new NoSuchElementException();
        Node x = head;
        head = x.next;
        x.next = null;
        return x.data;
    }

    /**
     * Returns an iterator for the linked list
     * @return Iterator<T>
     */
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node current = head;
            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                if (hasNext()) {
                    T data = current.data;
                    current = current.next;
                    return data;
                }
                return null;
            }
        };
    }

    /**
     *  Prints the linked list
     */
    public void printList() {
        System.out.print("[");
        for (Node x = head; x != null; x = x.next) {
            System.out.print(x.data);
            if (x.next != null) System.out.print(",");
        }
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args) {


    }
}

