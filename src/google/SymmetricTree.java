package google;

public class SymmetricTree {

    public class SymmetricTreeNode {

        int val;

        SymmetricTreeNode left;

        SymmetricTreeNode right;


        SymmetricTreeNode() {
        }


        SymmetricTreeNode(int val) {
            this.val = val;
        }


        SymmetricTreeNode(int val, SymmetricTreeNode left, SymmetricTreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public boolean isSymmetric(SymmetricTreeNode node) {

        if (node == null)
            return true;

        return isSymmetric(node.left, node.right);
    }

    private boolean isSymmetric(SymmetricTreeNode left, SymmetricTreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }

        if(left.val == right.val){
            return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
        }

        return false;
    }
}
