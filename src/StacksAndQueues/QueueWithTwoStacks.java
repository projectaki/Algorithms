package StacksAndQueues;

import java.util.NoSuchElementException;

/**
 * Implementation of a Queue with 2 stacks
 * @param <T>
 */
public class QueueWithTwoStacks<T> {

    private Node bufferHead = null;
    private Node queueHead = null;
    private boolean isQueueStackEmpty = true;

    private class Node {
        private T data;
        private Node next;
    }


    /**
     * Queue an item, always adds it to the buffer Stack
     * @param item Item to be pushed on the buffer stack
     */
    public void queue(T item) {
        Node x = new Node();
        x.data = item;
        if (bufferHead == null) {
            bufferHead = x;
            return;
        }
        x.next = bufferHead;
        bufferHead = x;
    }

    /**
     * Deque an item. The Queue stack gets all the values from buffer stack, which then when popped will be FIFO.
     * It will keep deque ing from the queue stack until it is empty. If queue stack is empty and a deque is called
     * it gets filled up again from the buffer stack
     * @return Returns the item from the front of the queue
     */
    public Node deque() {
        if (queueHead == null) {
            if (bufferHead == null) throw new NoSuchElementException("Queue is empty");
            isQueueStackEmpty = true;
        }

        if (isQueueStackEmpty) {
            // Transfer buffer stack to queue stack reversing the order

            for (Node x = bufferHead; x != null; x = x.next) {
                Node node = new Node();
                node.data = x.data;
                node.next = queueHead;
                queueHead = node;
                bufferHead = bufferHead.next;
            }
            isQueueStackEmpty = false;
        }

        Node deque = queueHead;
        queueHead = queueHead.next;
        return deque;


    }

    public static void main(String[] args) {
        QueueWithTwoStacks<Integer> queue = new QueueWithTwoStacks<>();
        queue.queue(1);
        queue.queue(2);
        queue.queue(3);
        queue.queue(4);
        queue.queue(5);
        queue.queue(6);
        System.out.println(queue.deque().data);
        System.out.println(queue.deque().data);
        queue.queue(7);
        System.out.println(queue.deque().data);
        System.out.println(queue.deque().data);
        System.out.println(queue.deque().data);
        queue.queue(8);
        System.out.println(queue.deque().data);
        System.out.println(queue.deque().data);
        System.out.println(queue.deque().data);

    }

}
