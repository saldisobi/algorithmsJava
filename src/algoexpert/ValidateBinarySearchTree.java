package algoexpert;

import java.util.LinkedList;
import java.util.Queue;

public class ValidateBinarySearchTree {

    public boolean isValidBst(BinarySearchTree binarySearchTree) {

        Queue<BinarySearchTree.BinarySearchTreeNode> bstStack = new LinkedList<>();

        bstStack.add(binarySearchTree.rootNode);
        //looks very simple skipping it


        return true;
    }
}
