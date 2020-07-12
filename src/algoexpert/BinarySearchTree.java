package algoexpert;

public class BinarySearchTree {

    BinarySearchTreeNode rootNode;

    class BinarySearchTreeNode {
        int value;
        BinarySearchTreeNode leftNode;
        BinarySearchTreeNode rightNode;

        BinarySearchTreeNode(int data) {
            value = data;
        }
    }

    public void insert(int data) {
        BinarySearchTreeNode binarySearchTreeNode = new BinarySearchTreeNode(data);

        if (rootNode == null)
            rootNode = binarySearchTreeNode;
        else {
            BinarySearchTreeNode currentNode = rootNode;
            while (currentNode != null) {
                if (currentNode.value == data) {
                    if (currentNode.leftNode != null) {
                        currentNode = currentNode.leftNode;
                    } else {
                        currentNode.leftNode = binarySearchTreeNode;
                        return;
                    }
                } else if (currentNode.value > data) {
                    if (currentNode.leftNode != null) {
                        currentNode = currentNode.leftNode;
                    } else {
                        currentNode.leftNode = binarySearchTreeNode;
                        return;
                    }
                } else {
                    if (currentNode.rightNode != null) {
                        currentNode = currentNode.rightNode;
                    } else {
                        currentNode.rightNode = binarySearchTreeNode;
                        return;
                    }
                }
            }
        }

    }

    public BinarySearchTreeNode search(int data) {
        if (rootNode.value == data) {
            return rootNode;
        } else {
            BinarySearchTreeNode currentNode = rootNode;
            while (currentNode != null) {
                if (currentNode.value == data) {
                    return currentNode;
                } else {
                    if (data >= currentNode.value) {
                        currentNode = currentNode.rightNode;
                    } else {
                        currentNode = currentNode.leftNode;
                    }
                }
            }
        }
        return null;
    }


    public static void main(String args[]) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(8);
        bst.insert(12);
        bst.insert(32);
        bst.insert(3);
        bst.insert(2);

        BinarySearchTreeNode bstNode = bst.search(12);
    }

}
