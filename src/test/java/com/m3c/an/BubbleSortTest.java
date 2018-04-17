package com.m3c.an;

import com.m3c.an.sorters.BubbleSort;
import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTest {

    @Test
    public void TestBubbleSort() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = {8, 4, 6, 2};
        Assert.assertArrayEquals(new int[] {2, 4, 6, 8}, bubbleSort.sortArray(array));
    }

}
