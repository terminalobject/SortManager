package com.m3c.an;

import com.m3c.an.sorters.MergeSort;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {

    MergeSort mergeSort;

    @Before
    public void setup() {
        MergeSort mergeSort = new MergeSort();
    }

    @Test
    public void TestMergeSort() {
        int[] array = {8, 4, 6, 2};
        Assert.assertArrayEquals(array, mergeSort.sortArray(array));
    }

}