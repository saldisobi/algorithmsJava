package algoexpert;

/**
 * Delete done in a naive way to just understand functionality can be improved
 *
 * won't work to delete root as of now, need to add a small check
 */
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

    public boolean delete(int deleteTerm, BinarySearchTreeNode currentNode) {
        if (currentNode.leftNode != null && currentNode.leftNode.value == deleteTerm) {
            if (currentNode.leftNode.leftNode == null && currentNode.leftNode.rightNode == null) {
                //it is a leaf node that has to be deleted
                currentNode.leftNode = null;
                return true;
            } else if (currentNode.leftNode.leftNode == null && currentNode.leftNode.rightNode != null) {
                // only one right child can be connected directly to parent

                currentNode.leftNode = currentNode.leftNode.rightNode;
                return true;
            } else if (currentNode.leftNode.leftNode != null && currentNode.leftNode.rightNode == null) {
                // only one left child can be connected directly to parent
                currentNode.leftNode = currentNode.leftNode.leftNode;
                return true;
            } else {
                //we have full tree on the left
                BinarySearchTreeNode leftMostInRight = findLeftMostInRightSubTree(currentNode.rightNode);
                currentNode.rightNode.value = leftMostInRight.leftNode.value;
                leftMostInRight.leftNode = null;
                return true;
            }

        } else if (currentNode.rightNode != null && currentNode.rightNode.value == deleteTerm) {
            if (currentNode.rightNode.leftNode == null && currentNode.rightNode.rightNode == null) {
                //it is a leaf node that has to be deleted
                currentNode.rightNode = null;
                return true;
            } else if (currentNode.rightNode.leftNode == null && currentNode.rightNode.rightNode != null) {
                // only one right child can be connected directly to parent

                currentNode.rightNode = currentNode.rightNode.rightNode;
                return true;
            } else if (currentNode.rightNode.leftNode != null && currentNode.rightNode.rightNode == null) {
                // only one left child can be connected directly to parent
                currentNode.rightNode = currentNode.rightNode.leftNode;
                return true;
            } else {
                //we have full tree on right
                BinarySearchTreeNode leftMostInRight = findLeftMostInRightSubTree(currentNode.rightNode);
                currentNode.rightNode.value = leftMostInRight.leftNode.value;
                leftMostInRight.leftNode = null;
                return true;
            }
        } else {

            if (currentNode.value > deleteTerm) {
                currentNode = currentNode.rightNode;
            } else {
                currentNode = currentNode.leftNode;
            }

            return delete(deleteTerm, currentNode);
        }

    }

    private BinarySearchTreeNode findLeftMostInRightSubTree(BinarySearchTreeNode binarySearchTreeNode) {
        BinarySearchTreeNode bstNode = binarySearchTreeNode;
        while (bstNode.leftNode != null) {
            bstNode = bstNode.leftNode;
        }
        return bstNode;
    }


    public static void main(String args[]) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(8);
        bst.insert(12);
        bst.insert(32);
        bst.insert(3);
        bst.insert(2);

        bst.delete(8,bst.rootNode);

        BinarySearchTreeNode bstNode = bst.search(12);
    }

}
