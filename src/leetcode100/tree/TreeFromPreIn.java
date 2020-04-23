package leetcode100.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeFromPreIn {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public TreeNode createTreeFromPreIn(int[] preOrder, int[] inorder, int beg, int end, int preOrderBeg) {

        if (beg > end||preOrderBeg>inorder.length-1) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preOrder[preOrderBeg]);

        int inOrderPosNew = getInOrderPos(preOrder[preOrderBeg], inorder, beg, end);

        preOrderBeg++;

        treeNode.left = createTreeFromPreIn(inorder, preOrder, beg, inOrderPosNew - 1, preOrderBeg);


        treeNode.right = createTreeFromPreIn(inorder, preOrder, inOrderPosNew + 1, end, preOrderBeg);

        return treeNode;
    }


    private int getInOrderPos(int preOrder, int[] inorder, int beg, int end) {
        for (int i = beg; i < end; i++) {

            if (inorder[i] == preOrder) {
                return i;
            }

        }

        return -1;
    }

    public void BFS(TreeNode rootNode) {


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

    public static void main(String[] args) {
        TreeFromPreIn treeFromPreIn =  new TreeFromPreIn();

        treeFromPreIn.BFS(treeFromPreIn.createTreeFromPreIn(new int[]{1, 2, 3, 4, 5}, new int[]{4, 2, 5, 1, 3}, 0, 4, 0));

    }
}
