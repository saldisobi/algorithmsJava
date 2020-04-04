package backToBasics;

import java.util.LinkedList;
import java.util.Queue;

public class MyBinarySearchTree {

    Node rootNode;

    class Node {
        int data;
        Node leftChild;
        Node rightChild;

        Node(int data) {
            this.data = data;
        }
    }

    public Node insertRecursive(Node root, int data) {
        Node node = new Node(data);
        if (root == null) {
            if (rootNode == null)
                rootNode = node;
            return node;
        }

        if (data < root.data) {
            root.leftChild = insertRecursive(root.leftChild, data);

        } else if (data > root.data) {
            root.rightChild = insertRecursive(root.rightChild, data);

        } else {
            throw new RuntimeException("Duplicates not allowed");
        }

        return root;
    }

    public void insert(int data) {
        System.out.println("command to print " + data);
        Node node = new Node(data);
        Node current = rootNode;
        if (rootNode == null) {
            System.out.println("root node ws null now root ode has data = " + data);
            rootNode = node;
            return;
        }
        while (current != null) {
            if (data < current.data) {
                System.out.println("data " + data + " < " + current.data);
                if (current.leftChild == null) {
                    System.out.println("left child was null insertion done");
                    current.leftChild = node;
                    return;
                } else {
                    System.out.println("left child was not null current is now " + current.leftChild.data);
                    current = current.leftChild;
                }
            } else if (data > current.data) {
                System.out.println("data " + data + " > " + current.data);
                if (current.rightChild == null) {
                    System.out.println("right child was null insertion done");

                    current.rightChild = node;
                    return;
                } else {
                    //    System.out.println("right child was not null current is now "+current.leftChild.data);
                    current = current.rightChild;
                }
            } else {
                throw new RuntimeException("diuplicated not allowed");
            }
        }
    }

    public void levelOrderIterative() {

        Queue<MyBinarySearchTree.Node> myQueue = new LinkedList();


        myQueue.add(rootNode);
        myQueue.add(null);

        int nullCounter = 0;
        while (!myQueue.isEmpty()) {
            if (myQueue.peek() != null) {
                nullCounter = 0;
                MyBinarySearchTree.Node node = myQueue.peek();
                myQueue.remove();
                System.out.print(node.data);

                if (node.leftChild != null) {
                    myQueue.add(node.leftChild);
                    myQueue.add(node.rightChild);
                }
            } else {
                nullCounter++;
                if (nullCounter > 1)
                    return;
                myQueue.remove();
                myQueue.add(null);
                System.out.println();
            }
        }


    }

    public static void main(String args[]) {
        MyBinarySearchTree tree = new MyBinarySearchTree();
    tree.insert(8);

        tree.insert(3);

        tree.insert(10);


        tree.insert(1);

        tree.insert(6);

        tree.insert(14);

        tree.insert(4);

        tree.insert(7);

        tree.insert(13);

        tree.levelOrderIterative();

         tree = new MyBinarySearchTree();
         
        tree.insertRecursive(tree.rootNode, 8);

        tree.insertRecursive(tree.rootNode, 3);

        tree.insertRecursive(tree.rootNode, 10);


        tree.insertRecursive(tree.rootNode, 1);

        tree.insertRecursive(tree.rootNode, 6);

        tree.insertRecursive(tree.rootNode, 14);

        tree.insertRecursive(tree.rootNode, 4);

        tree.insertRecursive(tree.rootNode, 7);

        tree.insertRecursive(tree.rootNode, 13);

        tree.levelOrderIterative();
    }
}
