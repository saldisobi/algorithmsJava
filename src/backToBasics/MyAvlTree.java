package backToBasics;

public class MyAvlTree {

    AvlNode rootNode;

    class AvlNode {
        AvlNode leftNode;
        AvlNode rightNode;
        AvlNode parent;
        int data;
        int height = 0;

        AvlNode(int data) {
            this.data = data;
        }
    }

    public void insert(int data) {
        AvlNode node = new AvlNode(data);
        insert(node);
    }

    public void insert(AvlNode node) {
        // first insert the node
        rootNode = insert(rootNode, node);

        getNewHeightForNode(rootNode);

        checkAndFixBalance(getBalancedFactor(rootNode), rootNode);


    }

    private void checkAndFixBalance(int balancedFactor, AvlNode root) {
        if (Math.abs(balancedFactor) < 2) {
            return;
        } else if (balancedFactor == -2) {
            //here right tree has more weight than left tree, now we check which among its subtree has more height
            if (root.rightNode.rightNode.height > root.rightNode.leftNode.height) {
                rotateLeft(root);
            } else {
                rotateLeft(root);
                rotateRight(root);
            }
        } else {
            // here left tree has more weight
            if (root.leftNode.leftNode.height > root.leftNode.rightNode.height) {
                rotateRight(root);
            } else {
                rotateRight(root);
                rotateLeft(root);
            }
        }
    }


    private void rotateRight(AvlNode root) {

        AvlNode newRoot = root.leftNode;

        AvlNode temp = newRoot.rightNode;

        newRoot.rightNode = root;

        root.leftNode = temp;

        rootNode = newRoot;
    }

    private void rotateLeft(AvlNode root) {

        AvlNode newNode = root.rightNode;

        AvlNode temp = newNode.leftNode;

        newNode.leftNode = root;

        root.rightNode = temp;

        rootNode = newNode;
    }

    private int getBalancedFactor(AvlNode node) {
        return (node.leftNode.height - node.rightNode.height);
    }

    private int getNewHeightForNode(AvlNode insertedNode) {
        return insertedNode.height = Math.max(insertedNode.leftNode.height, insertedNode.leftNode.height) + 1;
    }

    private AvlNode insert(AvlNode rootNode, AvlNode insertingNode) {
        if (rootNode == null)
            return insertingNode;

        if (insertingNode.data < rootNode.data) {
            rootNode.leftNode = insert(rootNode.leftNode, insertingNode);
        } else {
            rootNode.rightNode = insert(rootNode.rightNode, insertingNode);
        }

        return rootNode;
    }

}
