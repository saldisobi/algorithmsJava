package google;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeRightView {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void printBinaryTreeRightView(TreeNode treeNode) {
        if (treeNode == null) {
            System.out.print("null node");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        queue.add(null);

        while (!queue.isEmpty()) {
            TreeNode treeNode1 = queue.remove();
            if(treeNode1==null)
                return;

            if (treeNode1.left != null)
                queue.add(treeNode1.left);
            if (treeNode1.right != null)
                queue.add(treeNode1.right);
            if (queue.peek() == null) {



                System.out.println(treeNode1.val);
                queue.add(null);
                queue.remove();
            }
        }

    }


    public static void main(String args[]) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.right = new TreeNode(4);

        new BinaryTreeRightView().printBinaryTreeRightView(treeNode);
    }

}
