package StacksAndQueues;

import java.util.NoSuchElementException;

/**
 * Stack Min Implementation
 * Keeps a stack only adding if we have an element smaller or equals, and deleting if it equals to popped element
 * This provides constant time access to the min, if we remove the min we have the last smallest on the top of the stack
 *
 * @param <T> Generic
 */
public class StackMin<T> {

    /**
     * Node inner class
     */
    private class Node {
        private T data;
        private Node next;
    }

    private Node head = null;
    private Node minHead = null;

    /**
     * Stack push
     * @param data Generic data
     */
    public void push(T data) {
        Node x = new Node();
        x.data = data;
        if (head == null) {
            head = x;
            minHead = x;
            return;
        }
        x.next = head;
        head = x;
        if ((int)data <= (int)minHead.data) {
            Node newMin = new Node();
            newMin.data = data;
            newMin.next = minHead;
            minHead = newMin;
        }
    }

    /**
     * Stack pop
     * @return Returns popped Item
     */
    public Node pop() {
        if (head == null) throw new NoSuchElementException("Stack is empty");
        Node x = head;
        head = x.next;
        if (x.data == minHead.data) {
            minHead = minHead.next;
        }
        return x;
    }

    /**
     * Stack peek
     * @return Returns top of the stack
     */
    public Node peek() {
        if (head == null) throw new NoSuchElementException("Stack is empty");
        return head;
    }

    /**
     * Returns min of stack in constant time
     * @return Returns min element
     */
    public Node min() {
        return minHead;
    }

    public static void main(String[] args) {
        StackMin<Integer> stack = new StackMin<>();
        System.out.println(stack.head);
        stack.push(8);
        stack.push(7);
        stack.push(10);
        stack.push(5);
        stack.push(3);
        stack.push(2);
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.min().data);

    }



}
