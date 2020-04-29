package google;

public class SortedArrayToBST {

    class BSTNode {
        int data;
        BSTNode leftChild;
        BSTNode rightChild;

        BSTNode(int data) {
            this.data = data;

        }
    }


    public BSTNode createBST(int[] inputArray) {
        int midPoint = inputArray.length / 2;
        BSTNode bstNode = new BSTNode(inputArray[midPoint]);
        bstNode.leftChild = createBST(inputArray, 0, midPoint - 1);
        bstNode.rightChild = createBST(inputArray, midPoint + 1, inputArray.length - 1);

        return bstNode;
    }

    private BSTNode createBST(int[] inputArray, int left, int right) {

        if (left > right) {
            return null;
        } else {
            int midPoint = left + (right - left) / 2;
            BSTNode bstNode = new BSTNode(inputArray[midPoint]);
            bstNode.leftChild = createBST(inputArray, left, midPoint - 1);
            bstNode.rightChild = createBST(inputArray, midPoint + 1, right);

            return bstNode;
        }


    }


    public static void main(String args[]) {
        new SortedArrayToBST().createBST(new int[]{0, 1, 2, 3, 4, 5, 6});
    }
}
