package backToBasics;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyTree {

    Node rootNode;

    static class Node {
        int data;
        Node leftChild;
        Node rightChild;

        Node(int data) {
            this.data = data;
        }
    }


    public void inOrder(Node root) {

        if (root.leftChild != null)
            inOrder(root.leftChild);

        System.out.println(root.data);

        if (root.rightChild != null)
            inOrder(root.rightChild);

    }


    public void preOrder(Node root) {

        System.out.println(root.data);


        if (root.leftChild != null)
            preOrder(root.leftChild);


        if (root.rightChild != null)
            preOrder(root.rightChild);

    }


    public void postOrder(Node root) {


        if (root.leftChild != null)
            postOrder(root.leftChild);


        if (root.rightChild != null)
            postOrder(root.rightChild);

        System.out.println(root.data);

    }


    public void levelOrderIterative() {

        Queue<Node> myQueue = new LinkedList();


        myQueue.add(rootNode);
        myQueue.add(null);

        int nullCounter = 0;
        while (!myQueue.isEmpty()) {
            if (myQueue.peek() != null) {
                nullCounter = 0;
                Node node = myQueue.peek();
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


    public void preOrderIterative() {
        Stack<Node> myStack = new Stack<>();
        myStack.push(rootNode);

        while ((!myStack.isEmpty())) {
            Node node = myStack.pop();
            System.out.println(node.data);
            if (node.leftChild != null) {
                myStack.push(node.rightChild);
                myStack.push(node.leftChild);
            }
        }
    }

    public void inOrderIterative() {
        Stack<Node> myStack = new Stack<>();

        Node currentNode = rootNode;


        while (currentNode != null || (!myStack.isEmpty())) {


            while (currentNode != null) {

                myStack.push(currentNode);


                currentNode = currentNode.leftChild;

            }
            currentNode = myStack.pop();

            System.out.println(currentNode.data + "");

            currentNode = currentNode.rightChild;


        }

    }


    private void postOrderIterative() {


        Stack<Node> myStack = new Stack<>();

        Node currentNode = rootNode;

        while (currentNode != null || !myStack.isEmpty()) {
            while (currentNode != null) {
                currentNode = currentNode.leftChild;
            }
        }
    }


    public void practiceTwoInOrderIterative() {

        Stack<Node> myStack = new Stack<>();

        Node currentNode = rootNode;

        while (currentNode != null || !myStack.isEmpty()) {

            while (currentNode != null) {
                myStack.push(currentNode);
                currentNode = currentNode.leftChild;
            }

            Node node = myStack.pop();
            System.out.println(node.data);

            currentNode = node.rightChild;


        }

    }


    public void practiceTwoPreOrderIterative() {
        Stack<Node> myStack = new Stack<Node>();
        myStack.add(rootNode);

        while (!myStack.isEmpty()) {

            Node m = myStack.pop();
            System.out.println(m.data);
            if (m.leftChild != null) {
                myStack.add(m.rightChild);
                myStack.add(m.leftChild);
            }


        }
    }


    public void practiceTwoPostOrder() {
        Stack<Node> myStack = new Stack<>();
        Node currentNode = rootNode;
        Node currentVisitedNode = null;
        while (currentNode != null || !myStack.isEmpty()) {
            while (currentNode != null) {
                myStack.push(currentNode);
                currentNode = currentNode.leftChild;
            }


            Node peekNode = myStack.peek();

            if (peekNode.rightChild != null && peekNode.rightChild != currentVisitedNode) {

                currentNode = peekNode.rightChild;

            } else {
                System.out.println(peekNode.data);
                Node visit = myStack.pop();
                currentVisitedNode = visit;
            }
        }
    }


    public static void main(String args[]) {

        MyTree tree = new MyTree();

        tree.rootNode = new Node(1);
        tree.rootNode.leftChild = new Node(2);
        tree.rootNode.rightChild = new Node(3);
        tree.rootNode.leftChild.leftChild = new Node(4);
        tree.rootNode.leftChild.rightChild = new Node(5);

        tree.rootNode.rightChild.leftChild = new Node(6);

        tree.rootNode.rightChild.rightChild = new Node(7);


      /*  myTree.inOrder(myTree.rootNode);

        System.out.println();

        System.out.println();

        System.out.println();

        myTree.preOrder(myTree.rootNode);

        System.out.println();

        System.out.println();

        System.out.println();

        myTree.postOrder(myTree.rootNode);*/

        // myTree.levelOrderIterative();

        //tree.preOrder(tree.rootNode);
/*
        tree.inOrder(tree.rootNode);
        System.out.println("now Iterative");

        tree.inOrderIterative();*/

      /*  tree.preOrder(tree.rootNode);

        System.out.println("now Iterative");

        tree.preOrderIterative();*/

       /* tree.postOrder(tree.rootNode);

        System.out.println("now Iterative");

        tree.postOrderIterative();*/

        tree.postOrder(tree.rootNode);


        System.out.println("here begind new");
        tree.practiceTwoPostOrder();


    }


}



