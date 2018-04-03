package com.m3c.an.sorters;
import java.util.Arrays;

public class MergeSort implements Sorter {

    public int[] sortArray(int[] array) {
        int size = array.length;
        if (size < 2)
            return array;
        int mid = size / 2;
        int leftSize = mid;
        int rightSize = size - mid;
        int[] left = Arrays.copyOfRange(array, 0, leftSize);
        int[] right = Arrays.copyOfRange(array, rightSize, array.length);
        sortArray(left);
        sortArray(right);
        merge(left, right, array);
        return array;
    }

    public static void merge(int[] left, int[] right, int[] arr) {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < leftSize) {
            arr[k++] = left[i++];
        }
        while (j < rightSize) {
            arr[k++] = right[j++];
        }
    }
    @Override
    public String toString() {
        return "MergeSort";
    }
}
