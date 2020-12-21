package Sorting;

import java.util.Arrays;

/**
 * @author akos madarasz
 * @date 20/12/2020 - 21:44
 * @project Algorithms
 */
public class MergeSort {

    /**
     * Recursively merge sort
     * @param array Given array to sort
     */
    public static void mergesort(int[] array) {
        int[] auxiliary = new int[array.length];
        mergesort(array, auxiliary, 0, array.length - 1);
    }

    /*
        Helper method
     */
    public static void mergesort(int[] array, int[] auxiliary, int left, int right) {
        if (right <= left) return;
        int middle = (left + right)/2;
        mergesort(array, auxiliary, left, middle);
        mergesort(array, auxiliary, middle + 1, right);
        mergeArrays(array, auxiliary, left, right);
    }

    /**
     * Merge 2 arrays
     * @param array Given array
     * @param auxiliary Auxiliary array
     * @param left left bound
     * @param right right bound
     */
    public static void mergeArrays(int[] array, int[] auxiliary, int left, int right) {

        int rightIndex =  (left + right)/2 + 1;
        int leftIndex = left;
        int auxIndex = left;

        // copy the bigger element from the array to aux
        while (leftIndex <= (left + right)/2 && rightIndex <= right) {
            if (array[leftIndex] <= array[rightIndex]) {
                auxiliary[auxIndex++] = array[leftIndex++];
            }
            else {
                auxiliary[auxIndex++] = array[rightIndex++];
            }
        }

        // when one of them runs out of elements, copy the rest from the other to aux
        while (leftIndex <= (left + right)/2) {
            auxiliary[auxIndex++] = array[leftIndex++];
        }
        while (rightIndex <= right) {
            auxiliary[auxIndex++] = array[rightIndex++];
        }

        //from aux copy elements to original array
        for (int i = 0; i < (right - left) + 1; i++) {
            array[i] = auxiliary[i];
        }
    }







    public static void main(String[] args) {

        int[] arr = {3,2,1,5,7,6,10};
        mergesort(arr);
        System.out.println(Arrays.toString(arr));




    }
}
