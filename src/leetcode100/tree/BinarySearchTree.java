package leetcode100.tree;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {

    BstNode rootNode;

    class BstNode {
        int data;
        BstNode left;
        BstNode right;

        BstNode(int data) {
            this.data = data;
        }
    }


    public void insertBst(int data) {
        rootNode = insertBst(data, rootNode);
    }

    private BstNode insertBst(int data, BstNode insertingNode) {

        if (insertingNode == null) {
            return new BstNode(data);
        } else if (data < insertingNode.data) {
            insertingNode.left = insertBst(data, insertingNode.left);
        } else {
            insertingNode.right = insertBst(data, insertingNode.right);
        }

        return insertingNode;

    }

    public int inOrder(int counter) {
        int localCounter = 0;
        if (rootNode == null)
            throw new RuntimeException("root is Null");

        Stack<BstNode> tree = new Stack<>();


        BstNode current = rootNode;


        while (current != null || !tree.isEmpty()) {

            while (current != null) {
                tree.push(current);
                current = current.left;
            }

            BstNode node = tree.pop();

            System.out.println(node.data);

            localCounter++;

            if (localCounter == counter)

                return node.data;


            current = node.right;

        }

        return -1;
    }

    private int searchKthSmallest(int k) {

        return inOrder(k);

    }


    public int getInOrderSuccessor(int key) {

        Pair<BstNode, BstNode> bstNode = searchBst(key, rootNode, null);

        if (bstNode.getKey().right == null) {
            return bstNode.getValue().data;
        } else {
            return getSuccessor(bstNode.getValue().right);
        }


    }

    private int getSuccessor(BstNode value) {

        BstNode currentNode = value;


        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }


        return currentNode.data;


    }

    private Pair<BstNode, BstNode> searchBst(int data, BstNode currentNode, BstNode currentParent) {
//this doesn't take care of root-node case for brevity
        if (data < currentNode.data) {
            return searchBst(data, currentNode.left, currentNode);
        } else if (data > currentNode.data) {
            return searchBst(data, currentNode.right, currentNode);
        } else {
            return new Pair(currentNode, currentParent);
        }

    }


    public void BFS() {


        Queue<BstNode> myQueue = new LinkedList<>();

        myQueue.add(rootNode);
        myQueue.add(null);

        boolean wasLstNull = false;

        while (!myQueue.isEmpty()) {
            BstNode treeNode = myQueue.poll();

            if (treeNode == null) {
                if (wasLstNull)
                    return;
                wasLstNull = true;
                System.out.println();
                myQueue.add(null);
            } else {
                wasLstNull = false;
                System.out.print(treeNode.data);
                if (treeNode.left != null) {
                    myQueue.add(treeNode.left);
                    myQueue.add(treeNode.right);
                }
            }
        }
    }

    public void inOrder() {
        if (rootNode == null)
            throw new RuntimeException("root is Null");

        Stack<BstNode> tree = new Stack<>();


        BstNode current = rootNode;


        while (current != null || !tree.isEmpty()) {

            while (current != null) {
                tree.push(current);
                current = current.left;
            }

            BstNode node = tree.pop();

            System.out.println(node.data);

            current = node.right;

        }
    }

    public static void main(String args[]) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insertBst(10);

        bst.insertBst(5);

        bst.insertBst(15);

        bst.insertBst(4);

        bst.insertBst(6);

        //  bst.BFS();

        //  System.out.println("kth smallest = " + bst.searchKthSmallest(3));

        bst.inOrder();
        System.out.println("in order successor  = " + bst.getInOrderSuccessor(6));
    }
}
