package leetcode100.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversals {
    TreeNode rootNode;

    TreeTraversals(TreeNode rootNode) {
        this.rootNode = rootNode;
    }

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }


    public void preOrderIterative() {
        if (rootNode == null)
            throw new RuntimeException("root is Null");

        Stack<TreeNode> tree = new Stack<>();

        tree.push(rootNode);

        TreeNode current = rootNode;

        while (current != null || !tree.isEmpty()) {
            current = tree.pop();
            if (current != null) {
                System.out.println(current.data);
                tree.push(current.right);
                tree.push(current.left);
            }
        }
    }


    public void inOrder() {
        if (rootNode == null)
            throw new RuntimeException("root is Null");

        Stack<TreeNode> tree = new Stack<>();


        TreeNode current = rootNode;


        while (current != null || !tree.isEmpty()) {

            while (current != null) {
                tree.push(current);
                current = current.left;
            }

            TreeNode node = tree.pop();

            System.out.println(node.data);

            current = node.right;

        }
    }


    public void postOrder() {
        if (rootNode == null)
            throw new RuntimeException("root is Null");

        Stack<TreeNode> tree = new Stack<>();


        TreeNode current = rootNode;

        TreeNode lastVisited = null;
        while (current != null || !tree.isEmpty()) {

            if (current != null) {
                tree.push(current);
                current = current.left;
            } else {
                TreeNode peekNode = tree.peek();

                // if right child exists and traversing node
                // from left child, then move right

                if (peekNode.right != null && lastVisited != peekNode.right) {
                    current = peekNode.right;
                } else {
                    System.out.println(peekNode.data);
                    lastVisited = tree.pop();

                    current = null;
                }
            }

        }
    }


    public void BFS() {


        Queue<TreeNode> myQueue = new LinkedList<>();

        myQueue.add(rootNode);
        myQueue.add(null);

        boolean wasLstNull = false;

        while (!myQueue.isEmpty()) {
            TreeNode treeNode = myQueue.poll();

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


    public void zigZagTraversal() {

        Stack<TreeNode> leftToRightStack = new Stack<>();

        Stack<TreeNode> rightToLeftStack = new Stack<>();

        leftToRightStack.push(rootNode);

        Stack<TreeNode> currentStack = leftToRightStack;

        boolean isLeftToRight = true;

        while (!currentStack.isEmpty()) {
            TreeNode treeNode = currentStack.pop();

            System.out.print(treeNode.data);

            if (isLeftToRight) {
                if (treeNode.left != null) {
                    rightToLeftStack.push(treeNode.left);
                    rightToLeftStack.push(treeNode.right);

                }
            } else {
                if (treeNode.left != null) {
                    leftToRightStack.push(treeNode.right);
                    leftToRightStack.push(treeNode.left);
                }
            }

            if (currentStack.isEmpty()) {
                System.out.println();
                if (isLeftToRight) {

                    currentStack = rightToLeftStack;
                } else {
                    currentStack = leftToRightStack;
                }

                isLeftToRight = !isLeftToRight;

            }

        }

    }

    public static void main(String args[]) {

        TreeNode rootNode = new TreeNode(0);

        rootNode.left = new TreeNode(1);

        rootNode.right = new TreeNode(2);

        rootNode.left.left = new TreeNode(3);

        rootNode.left.right = new TreeNode(4);


        TreeTraversals treeTraversals = new TreeTraversals(rootNode);

        treeTraversals.zigZagTraversal();

    }
}
