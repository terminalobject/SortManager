package com.m3c.an.sorters;

import com.m3c.an.controller.ElementNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class BTree implements BinaryTree {

    private Node RootElement;

    public BTree(int rootValue){
        this.RootElement = new Node(rootValue);
    }

    BTree(int[] arrayOfValues) {
        this.RootElement = new Node(arrayOfValues[0]);
        for (int i = 1; i < arrayOfValues.length; i++) {
            this.addElement(arrayOfValues[i]);
        }
    }

    public Node getRoot() {
        return this.RootElement;
    }

    public int getRootElement() {
        return this.RootElement.getValue();
    }

    public int getNumberOfElements() {
        return getNumberOfElements(this.getRoot());
    }

    private int getNumberOfElements(Node node) {
        if (node == null) return 0;
        return 1 + getNumberOfElements(node.getLeft()) + getNumberOfElements(node.getRight());
    }

    public void addElement(int element) {
        Node current = getRoot();
        Node parent;
        while(true){
            parent = current;
            if(element < current.getValue()) {
                current = current.getLeft();
                if (current == null) {
                    parent.setLeft(new Node(element));
                    return;
                }
            }
            else
                {
                current = current.getRight();
                if(current==null){
                    parent.setRight(new Node(element));
                    return;
                }
            }
        }
    }

    public void addElements(int[] elements) {
        for (int element : elements) {
            this.addElement(element);
        }
    }

    public Node findElementNode(int value) {
        return findElementNode(this.getRoot(), value);
    }

    public Node findElementNode(Node node, int value) {
        Node result = null;
        if(node.getValue() == value)
            return node;
        else if (node.getValue() >= value)
            result = findElementNode(node.getLeft(), value);
        else if(node.getValue() <= value)
            result = findElementNode(node.getRight(), value);
        return result;
    }

    public boolean findElement(int value) {
        Node current = this.getRoot();
        while (current != null) {
            if (current.getValue() == value) {
                return true;
            }
            else if (current.getValue() > value) {
                current = current.getLeft();
            }
            else if (current.getValue() < value) {
                current = current.getRight();
            }
        }
        return false;
    }

    public int getLeftChild(int element) throws ElementNotFoundException {
        if (findElementNode(element).getLeft() != null)
             return findElementNode(element).getLeft().getValue();
        throw new ElementNotFoundException();
    }

    public int getRightChild(int element) throws ElementNotFoundException {
        if (findElementNode(element).getRight() != null)
            return findElementNode(element).getRight().getValue();
        throw new ElementNotFoundException();
    }

    public void delete(int value)
    {
        RootElement = deleteRec(RootElement, value);
    }

    private Node deleteRec(Node root, int value)
    {
        if (root == null)  return root;

        if (value < root.getValue())
            root.setLeft(deleteRec(root.getLeft(), value));
        else if (value > root.getValue())
            root.setRight(deleteRec(root.getRight(), value));
        else
        {
            if (root.getLeft() == null)
                return root.getRight();
            else if (root.getRight() == null)
                return root.getLeft();

            root.setValue(minValueNode(root.getRight()));

            root.setRight(deleteRec(root.getRight(), root.getValue()));
        }

        return root;
    }

    private int minValueNode(Node root)
    {
        int minimumValue = root.getValue();
        while (root.getLeft() != null)
        {
            minimumValue = root.getLeft().getValue();
            root = root.getLeft();
        }
        return minimumValue;
    }

    public List<Integer> getSortedTreeAsc() {
        return SortTreeAsc(this.getRoot(), new ArrayList<>());
    }

    private List<Integer> SortTreeAsc(Node node, List<Integer> result) {

        if (node.getLeft() != null) {
            SortTreeAsc(node.getLeft(), result);
        }

        result.add(node.getValue());

        if (node.getRight() != null) {
            SortTreeAsc(node.getRight(), result);
        }

        return result;
    }

    public int getMinimum() {
        Node node = getRoot();
        int candidate = node.getValue();
        while (node.getLeft() != null) {
            node = node.getLeft();
            candidate = node.getValue();
        }
        return candidate;
    }

    public int getMaximum() {
        Node node = getRoot();
        int candidate = node.getValue();
        while (node.getRight() != null) {
            node = node.getRight();
            candidate = node.getValue();
        }
        return candidate;
        }


    public List<Integer> getSortedTreeDesc() {
        return SortTreeDesc(this.getRoot(), new ArrayList<>());
    }

    private List<Integer> SortTreeDesc(Node node, List<Integer> result) {

        if (node.getRight() != null) {
            SortTreeDesc(node.getRight(), result);
        }

        result.add(node.getValue());

        if (node.getLeft() != null) {
            SortTreeDesc(node.getLeft(), result);
        }

        return result;
    }
}
