package StacksAndQueues;

import java.util.Stack;

/**
 * Sort a stack only using additional stack
 */
public class SortStack {

    /**
     * Pass stack to be sorted
     * @param toSort Stack to sort
     */
    public static void sortStack(Stack<Integer> toSort) {
        Stack<Integer> tempStack = new Stack<>();
        sortStack(toSort, tempStack);
    }

    /**
     * Uses temporary stack to sort a stack
     * @param toSort Stack to sort
     * @param tempStack Temp stack to help sorting
     */
    public static void sortStack(Stack<Integer> toSort, Stack<Integer> tempStack) {
        tempStack.push(toSort.pop());
        while (!toSort.isEmpty()) {
            if(toSort.peek() >= tempStack.peek()) {
                tempStack.push(toSort.pop());
            }
            else {
                int left = toSort.pop();
                int right = tempStack.pop();
                toSort.push(right);
                toSort.push(left);
            }
        }
        while (!tempStack.isEmpty()) {
            toSort.push(tempStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stackToSort = new Stack<>();
        stackToSort.push(2);
        stackToSort.push(4);
        stackToSort.push(3);
        stackToSort.push(5);
        stackToSort.push(8);
        stackToSort.push(1);
        stackToSort.push(4);
        stackToSort.push(5);
        stackToSort.push(1);
        stackToSort.push(8);
        stackToSort.push(2);
        stackToSort.push(1);

        System.out.println(stackToSort);
        sortStack(stackToSort);
        System.out.println(stackToSort);
        System.out.println(stackToSort.peek());


    }
}
