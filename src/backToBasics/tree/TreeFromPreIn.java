package backToBasics.tree;


import backToBasics.MyTree;

import java.util.LinkedList;
import java.util.Queue;

class TreeFromPreIn {

    private int index = 0;

    public TreeNode createTree(int inorder[], int preorder[]) {
        TreeNode result = createTree(inorder, preorder, 0, inorder.length - 1);
        index = 0;
        return result;
    }

    private TreeNode createTree(int inorder[], int preorder[], int start, int end) {
        if (start > end) {
            return null;
        }
        int i;
        for (i = start; i <= end; i++) {
            if (preorder[index] == inorder[i]) {
                break;
            }
        }
        TreeNode node = new TreeNode(preorder[index]);
        index++;
        node.left = createTree(inorder, preorder, start, i - 1);
        node.right = createTree(inorder, preorder, i + 1, end);
        return node;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void levelOrderIterative(TreeNode rootNode) {

        Queue<TreeNode> myQueue = new LinkedList();


        myQueue.add(rootNode);
        myQueue.add(null);

        int nullCounter = 0;
        while (!myQueue.isEmpty()) {
            if (myQueue.peek() != null) {
                nullCounter = 0;
                TreeNode node = myQueue.peek();
                myQueue.remove();
                System.out.print(node.val);

                if (node.left != null) {
                    myQueue.add(node.left);
                    myQueue.add(node.right);
                }
            } else {
                nullCounter++;
                if (nullCounter > 1)
                    return;
                myQueue.remove();
                myQueue.add(null);
                System.out.println();
            }
        }


    }


    public static void main(String args[]) {
        int[] preOrder = new int[]{3, 9, 20, 15, 7};

        int[] inOrder = new int[]{9, 3, 15, 20, 7};

        TreeFromPreIn treeFromPreIn = new TreeFromPreIn();
        TreeNode tn = treeFromPreIn.createTree(inOrder, preOrder);

        treeFromPreIn.levelOrderIterative(tn);

    }
}