package backToBasics;

import java.util.LinkedList;
import java.util.Queue;

public class MyAvlTree {

    private AvlNode mRootNode;

    private class AvlNode {
        AvlNode leftNode;
        AvlNode rightNode;
        int data;
        int height = 1;

        AvlNode(int data) {
            this.data = data;
        }
    }


    public int getHeight(AvlNode node) {
        if (node == null)
            return 0;
        else
            return node.height;

    }

    private AvlNode checkAndFixBalance(int balancedFactor, AvlNode root, int data) {

        if (balancedFactor == 2 && data < root.leftNode.data)
            return rotateRight(root);

        if (balancedFactor == -2 && data > root.rightNode.data)
            return rotateLeft(root);

        if (balancedFactor == 2 && data > root.leftNode.data) {
            root.leftNode = rotateLeft(root.leftNode);
            return rotateRight(root);
        }

        if (balancedFactor == -2 && data < root.rightNode.data) {
            root.rightNode = rotateRight(root.rightNode);
            return rotateLeft(root);

        }

        return root;
    }


    private AvlNode rotateRight(AvlNode root) {

        AvlNode newRoot = root.leftNode;

        AvlNode temp = newRoot.rightNode;

        newRoot.rightNode = root;

        root.leftNode = temp;

        newRoot.height = getNewHeightForNode(newRoot);

        return newRoot;
    }

    private AvlNode rotateLeft(AvlNode root) {

        AvlNode newNode = root.rightNode;

        AvlNode temp = newNode.leftNode;

        newNode.leftNode = root;

        root.rightNode = temp;

        newNode.height = getNewHeightForNode(newNode);

        return newNode;
    }

    private int getBalancedFactor(AvlNode node) {

        int leftHeight = (node.leftNode == null) ? 0 : node.leftNode.height;

        int rightHeight = (node.rightNode == null) ? 0 : node.rightNode.height;


        return (leftHeight - rightHeight);
    }

    private int getNewHeightForNode(AvlNode node) {
        int leftHeight = (node.leftNode == null) ? 0 : node.leftNode.height;

        int rightHeight = (node.rightNode == null) ? 0 : node.rightNode.height;

        return node.height = Math.max(leftHeight, rightHeight) + 1;
    }

    private AvlNode insert(AvlNode node, AvlNode insertingNode) {
        if (node == null) {
            if (mRootNode == null) {
                mRootNode = insertingNode;
            }

            return insertingNode;

        }

        if (insertingNode.data < node.data) {
            node.leftNode = insert(node.leftNode, insertingNode);
        } else {
            node.rightNode = insert(node.rightNode, insertingNode);
        }

        node.height = Math.max(getHeight(node.leftNode), getHeight(node.rightNode)) + 1;

        node = checkAndFixBalance(getBalancedFactor(node), node, insertingNode.data);

        mRootNode = node;
        return node;
    }

    public void levelOrderIterative() {
        Queue<AvlNode> myQueue = new LinkedList();
        myQueue.add(mRootNode);
        myQueue.add(null);

        int nullCounter = 0;
        while (!myQueue.isEmpty()) {
            if (myQueue.peek() != null) {
                nullCounter = 0;
                AvlNode node = myQueue.peek();
                myQueue.remove();
                System.out.print(node.data);

                if (node.leftNode != null) {
                    myQueue.add(node.leftNode);
                    myQueue.add(node.rightNode);
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

        MyAvlTree myAvlTree = new MyAvlTree();

        myAvlTree.insert(1);
        myAvlTree.insert(2);
        myAvlTree.insert(3);
        myAvlTree.insert(4);
        myAvlTree.insert(5);
        myAvlTree.insert(6);
        myAvlTree.insert(7);

        myAvlTree.levelOrderIterative();

    }

    private void insert(int i) {
        AvlNode node = new AvlNode(i);
        insert(mRootNode, node);
    }

}
