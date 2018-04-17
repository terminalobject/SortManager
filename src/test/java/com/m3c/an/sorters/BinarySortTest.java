package com.m3c.an.sorters;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySortTest {

    private BinarySort binarySort;

    @Before
    public void setup() {
        binarySort = new BinarySort();
    }

    @Test
    public void TestBinarySort() {
        int[] array = {5, 8, 1, 3, 10};
        Assert.assertArrayEquals(new int[] {1, 3, 5, 8, 10}, binarySort.sortArray(array));
    }
}