package StacksAndQueues;

import java.util.NoSuchElementException;

/**
 * Implementation of multiple stacks, after threshold is reached, a new stack starts. The stacks heads are stored in an array
 * Non-generic implementation
 */
public class StackOfPlates {

    public static class Node {
        private int data;
        private Node next;
        private int chainLength;
    }

    private final Node[] arr = new Node[10];
    private int currentIndex = 0;
    private Node head = null;
    private static final int THRESHOLD = 5;

    /**
     * Push to stack, if the defined threshold is reached, it will start a new stack
     * @param item Item to push to stack
     */
    public void push(int item) {
        Node x = new Node();
        x.data = item;
        if (head == null) {
            x.chainLength = 1;
            arr[currentIndex] = x;
            head = x;
            return;
        }
        if (head.chainLength == THRESHOLD) {
            x.chainLength = 1;
            x.next = head;
            arr[++currentIndex] = x;
            head = x;
            return;
        }
        x.chainLength = head.chainLength + 1;
        x.next = head;
        arr[currentIndex] = x;
        head = x;

    }

    /**
     * Pop from the top of the stack
     * @return Returns popped node
     */
    public Node pop() {
        if (head == null) throw new NoSuchElementException("Stack empty");
        Node x = head;
        if (head.chainLength == 1) {
            head = head.next;
            arr[currentIndex--] = null;
            return x;
        }
        head = head.next;
        arr[currentIndex] = head;
        return x;

    }

    /**
     * Pop from the given sub stack
     * @param index Index of sub stack to pop from
     * @return Returns popped node
     */
    public Node popAt(int index) {
        Node x = new Node();
        x.data = arr[index].data;
        x.next = arr[index].next;
        Node del = arr[index];
        del.data = del.next.data;
        del.next = del.next.next;
        arr[index] = del;
        return x;
    }

    public static void main(String[] args) {
        StackOfPlates stack = new StackOfPlates();
        int n = 10;
        for (int i = 0; i < 18; i++) {
            stack.push(n++);
        }

        Node a = stack.pop();
        Node b = stack.popAt(0);

        System.out.println(a + " " + b);

        int p = 0;
        while(stack.arr[p] != null) {
            Node temp = stack.arr[p];
            while (temp.chainLength > 1) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.print(temp.data + " ");
            System.out.println();
            p++;
        }

        System.out.println(stack.arr[1].next.next.next.next.next.next.data);






    }
}
