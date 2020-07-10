package algoexpert;

public class ClosestValueBinarySearchTree {

    ClosestValueBinarySearchTreeNode rootNode;

    static class ClosestValueBinarySearchTreeNode {
        int value;
        ClosestValueBinarySearchTreeNode leftChild;
        ClosestValueBinarySearchTreeNode rightChild;

        ClosestValueBinarySearchTreeNode(int data) {
            value = data;
        }
    }

    public int getClosestNode(int data) {
        int currentDifference = Integer.MAX_VALUE;
        ClosestValueBinarySearchTreeNode currentNode = rootNode;

        while (currentNode != null) {
            if (Math.abs(data - currentNode.value) < currentDifference) {
                currentDifference = Math.abs(data - currentNode.value);
                if (currentNode.leftChild != null && Math.abs(data - currentNode.leftChild.value) < currentDifference) {
                    currentNode = currentNode.leftChild;
                } else if (currentNode.rightChild != null && Math.abs(data - currentNode.rightChild.value) < currentDifference) {
                    currentNode = currentNode.rightChild;
                } else {

                    return currentNode.value;
                }
            }
        }

        return currentDifference;

    }

    public static void main(String args[]) {
        ClosestValueBinarySearchTree bst = new ClosestValueBinarySearchTree();

        ClosestValueBinarySearchTreeNode treeNode = new ClosestValueBinarySearchTreeNode(10);

        treeNode.leftChild = new ClosestValueBinarySearchTreeNode(5);
        treeNode.rightChild = new ClosestValueBinarySearchTreeNode(15);

        treeNode.leftChild.leftChild = new ClosestValueBinarySearchTreeNode(2);
        treeNode.leftChild.rightChild = new ClosestValueBinarySearchTreeNode(5);
        treeNode.rightChild.leftChild = new ClosestValueBinarySearchTreeNode(13);
        treeNode.rightChild.rightChild = new ClosestValueBinarySearchTreeNode(22);

        treeNode.leftChild.leftChild.leftChild = new ClosestValueBinarySearchTreeNode(1);
        treeNode.rightChild.leftChild.rightChild = new ClosestValueBinarySearchTreeNode(14);

        bst.rootNode = treeNode;

        System.out.println("closest integer to 15 is " + bst.getClosestNode(99));
    }
}

