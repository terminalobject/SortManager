package com.m3c.an;

import com.m3c.an.sorters.Node;
import org.junit.Assert;
import org.junit.Test;

public class NodeTest {

    @Test
    public void testNodeInstance()
    {
        Node node = new Node(3);// Can create a node
        Assert.assertTrue(node instanceof Node);
    }
    @Test
    public void testNodeValue()
    {
        Node node = new Node(1);
        Assert.assertEquals(1,node.getValue());
    }
}