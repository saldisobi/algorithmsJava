package algoexpert;

import java.util.Stack;

public class DepthFirstSearch {

    TraversalTreeNode rootNode;

    static class TraversalTreeNode {
        int value;
        TraversalTreeNode leftChild;
        TraversalTreeNode rightChild;

        TraversalTreeNode(int data) {
            value = data;
        }
    }

    private void traverseDepthFirst(boolean isRecursive) {
        if (isRecursive)
            traverseDepthFirst(rootNode);
        else
            traverseDepthFirstIterative(rootNode);
    }

    private void traverseDepthFirstIterative(TraversalTreeNode rootNode) {
        Stack<TraversalTreeNode> traversalStack = new Stack<>();
        TraversalTreeNode currentNode = rootNode;
        traversalStack.push(currentNode);
        while (currentNode != null || !traversalStack.empty()) {
            if (currentNode == null) {
                TraversalTreeNode node = traversalStack.pop();
                System.out.println(node.value);
                if (node.rightChild != null) {
                    currentNode = node.rightChild;
                }

            } else {
                traversalStack.push(currentNode);
                currentNode = currentNode.leftChild;
            }
        }
    }

    private void traverseDepthFirst(TraversalTreeNode current) {
        if (current == null) {
            return;
        }
        System.out.println(current.value);
        traverseDepthFirst(current.leftChild);
        traverseDepthFirst(current.rightChild);
    }

    public static void main(String args[]) {
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        TraversalTreeNode node = new TraversalTreeNode(1);
        node.leftChild = new TraversalTreeNode(2);
        node.leftChild.leftChild = new TraversalTreeNode(4);
        node.leftChild.leftChild.leftChild = new TraversalTreeNode(5);
        node.rightChild = new TraversalTreeNode(3);
        depthFirstSearch.rootNode = node;
        depthFirstSearch.traverseDepthFirst(true);

        System.out.println();

        depthFirstSearch.traverseDepthFirst(false);

    }

}
