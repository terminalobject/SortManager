package com.m3c.an;

import com.m3c.an.controller.ElementNotFoundException;
import com.m3c.an.sorters.BTree;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTest {

    @Test
    public void testRoot() {
        BTree bTree = new BTree(2);
        Assert.assertEquals(bTree.getRootElement(), 2);
    }
    
    @Test
    public void testAddElement() {
        BTree bTree = new BTree(5);
        bTree.addElement(7);
        Assert.assertEquals(7, bTree.getRoot().getRight().getValue());
    }

    @Test
    public void testAddElements() {
        BTree bTree = new BTree(5);
        int[] array = {7,4};
        bTree.addElements(array);
        Assert.assertEquals(7, bTree.getRoot().getRight().getValue());
        Assert.assertEquals(4, bTree.getRoot().getLeft().getValue());
    }

    @Test
    public void testGetNumberOfElements() {
        BTree bTree = new BTree(7);
        int[] array = {1, 3, 4, 8, 10, 11};
        bTree.addElements(array);
        Assert.assertEquals(7,bTree.getNumberOfElements());
    }

    @Test
    public void testFindElement() {
        BTree bTree = new BTree(5);
        int[] array = {1, 3, 4, 8, 10, 11};
        bTree.addElements(array);
        Assert.assertTrue(bTree.findElement(3));
    }

    @Test
    public void testGetRightChild() throws ElementNotFoundException {
        BTree bTree = new BTree(5);
        int[] array = {1, 3, 4, 8, 10, 11};
        bTree.addElements(array);
        Assert.assertEquals(8, bTree.getRightChild(5));
    }
    @Test
    public void testGetLeftChild() throws ElementNotFoundException {
        BTree bTree = new BTree(5);
        int[] array = {1, 3, 4, 8, 10, 11};
        bTree.addElements(array);
        Assert.assertEquals(1, bTree.getLeftChild(5));
    }
    @Test
    public void testGetMinimum() {
        BTree bTree = new BTree(5);
        int[] array = {1, 3, 4, 8, 10, 11};
        bTree.addElements(array);
        Assert.assertEquals(1, bTree.getMinimum());
    }
    @Test
    public void testGetMaximum() {
        BTree bTree = new BTree(5);
        int[] array = {1, 3, 4, 8, 10, 11};
        bTree.addElements(array);
        Assert.assertEquals(11, bTree.getMaximum());
    }
    @Test
    public void TestGetSortedTreeAsc() {
        BTree bTree = new BTree(5);
        int[] array = {11, 3, 8, 4, 10, 7, 15};
        List<Integer> arraySorted = new ArrayList<>();
        arraySorted.add(3);
        arraySorted.add(4);
        arraySorted.add(5);
        arraySorted.add(7);
        arraySorted.add(8);
        arraySorted.add(10);
        arraySorted.add(11);
        arraySorted.add(15);
        bTree.addElements(array);
        Assert.assertEquals(arraySorted, bTree.getSortedTreeAsc());
    }

    @Test
    public void TestGetSortedTreeDesc() {
        BTree bTree = new BTree(5);
        int[] array = {11, 3, 8, 4, 10, 7, 15};
        List<Integer> arraySorted = new ArrayList<>();
        arraySorted.add(15);
        arraySorted.add(11);
        arraySorted.add(10);
        arraySorted.add(8);
        arraySorted.add(7);
        arraySorted.add(5);
        arraySorted.add(4);
        arraySorted.add(3);
        bTree.addElements(array);
        Assert.assertEquals(arraySorted, bTree.getSortedTreeDesc());
    }

    @Test
    public void TestDelete() {
        BTree bTree = new BTree(5);
        int[] array = {11, 3, 8, 4, 10, 7, 15};
        bTree.addElements(array);
        bTree.delete(3);
        List<Integer> expectedArray = new ArrayList<>();
        expectedArray.add(4);
        expectedArray.add(5);
        expectedArray.add(7);
        expectedArray.add(8);
        expectedArray.add(10);
        expectedArray.add(11);
        expectedArray.add(15);
        Assert.assertEquals(expectedArray, bTree.getSortedTreeAsc());
    }
}