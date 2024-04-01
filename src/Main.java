import Part1.Check.LinkedList;
import Part2.Tree;


public class Main {
    public static void main(String[] args) {
        Tree binaryTree = new Tree();
        binaryTree.insert(20);
        binaryTree.insert(30);
        binaryTree.insert(10);
        binaryTree.insert(6);
        binaryTree.insert(14);
        binaryTree.insert(24);
        binaryTree.insert(3);
        binaryTree.insert(8);
        binaryTree.insert(26);
        binaryTree.BreadthTransverse();
        var result = binaryTree.find(10);
        System.out.println(result);
    }
}

