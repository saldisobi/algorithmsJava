package algoexpert;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorTree {

    private MirrorTreeNode mRootNode;

    static class MirrorTreeNode {
        int value;
        MirrorTreeNode leftNode;
        MirrorTreeNode rightNode;

        public MirrorTreeNode(int i) {
            value = i;
        }
    }

    public void invertTree(MirrorTreeNode mRootNode) {
        Queue<MirrorTreeNode> queue = new LinkedList<>();

        queue.add(mRootNode);
        while (!queue.isEmpty()) {
            MirrorTreeNode mirrorTreeNode = queue.poll();

            MirrorTreeNode temp = mirrorTreeNode.leftNode;
            mirrorTreeNode.leftNode = mirrorTreeNode.rightNode;
            mirrorTreeNode.rightNode = temp;
            if (mirrorTreeNode.leftNode != null)
                queue.add(mirrorTreeNode.leftNode);
            if (mirrorTreeNode.rightNode != null)
                queue.add(mirrorTreeNode.rightNode);
        }


    }

    public static void main(String args[]) {
        MirrorTree mirrorTree = new MirrorTree();
        MirrorTreeNode node = new MirrorTreeNode(1);
        node.leftNode = new MirrorTreeNode(2);
        node.rightNode = new MirrorTreeNode(3);

        node.leftNode.leftNode = new MirrorTreeNode(4);
        node.leftNode.rightNode = new MirrorTreeNode(5);

        node.rightNode.leftNode = new MirrorTreeNode(6);
        node.rightNode.rightNode = new MirrorTreeNode(7);

        mirrorTree.mRootNode = node;
        mirrorTree.invertTree(node);
        System.out.println(mirrorTree.mRootNode.leftNode.value);
        System.out.println(mirrorTree.mRootNode.rightNode.value);
    }
}
