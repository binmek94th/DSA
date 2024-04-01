package Part2;

import Part1.ArrayQueue;
import Part1.QueueStack;

import java.util.*;

public class Tree {
    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;

        Node(int value){
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }
    private Node root;

    public void insert(int value) {
        Node entry = new Node(value);
        if (root == null){
            root = entry;
            return;
        }
        Node current = root;

        while(true) {
            if (current.value > value) {
                if (current.leftChild == null) {
                    current.leftChild = entry;
                    return;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = entry;
                    return;
                }
                current = current.rightChild;
            }
        }
    }
    public boolean find(int value){
        Node current = root;
        while (current != null){
            if (current.value == value)
                return true;
            else if (current.value > value)
                current = current.leftChild;
            else 
                current = current.rightChild;
        }
        return false;
    }

    public void BreadthTransverse() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.value + ", ");

            if (node.leftChild != null)
                queue.add(node.leftChild);
            if (node.rightChild != null)
                queue.add(node.rightChild);
        }
    }

    public void preOrder() {

    }

    public void inOrder() {

    }
    public void postOrder() {

    }
}
