package com.m3c.an;

import com.m3c.an.sorters.MergeSort;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {

    private MergeSort mergeSort;

    @Before
    public void setup() {
        mergeSort = new MergeSort();
    }

    @Test
    public void TestMergeSort() {
        int[] array = {11, 3, 7, 9, 5};
        Assert.assertArrayEquals(new int[] {3, 5, 7, 9, 11}, mergeSort.sortArray(array));
    }

}