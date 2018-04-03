package com.m3c.an;

import com.m3c.an.sorters.BubbleSort;
import com.m3c.an.sorters.Sorter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SortTest {

    public Sorter sorter;

    @Before
    public void setup() {
        sorter = new BubbleSort();
    }

    @Test
    public void testEmptyArray() {
        int[] array = {};
        int[] sortedArray = sorter.sortArray(array);
        Assert.assertEquals(0,sortedArray.length);
    }

    @After
    public void teardown() {

    }
}
