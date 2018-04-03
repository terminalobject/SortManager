package com.m3c.an.controller;

import com.m3c.an.display.DisplayManager;
import com.m3c.an.sorters.Sorter;

import java.util.Random;

public class SortManager {

    public void sortArray() {
        DisplayManager displayManager = new DisplayManager();
        try {
            Sorter sorter = SortFactory.getInstance();
            int[] arrayToSort = createArray(100);

            displayManager.displayUnsortedArray(sorter, arrayToSort);
            long start = System.nanoTime();
            int[] sortedArray = sorter.sortArray(arrayToSort);
            long end = System.nanoTime();
            displayManager.displaySorted(sortedArray, (end - start));
        } catch (SortManagerException sme) {
            displayManager.displayExceptionMessage(sme.getMessage());
        }
    }

    private int[] createArray(int size) {
        Random random = new Random();
        int[] unsortedArray = new int[size];
        for (int i = 0; i < size; i++) {
            unsortedArray[i] = random.nextInt(size*10) + 1;
        }
        return unsortedArray;
    }
}
