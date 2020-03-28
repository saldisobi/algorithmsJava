package backToBasics;

public class MyTree {

    Node rootNode;

    static class Node {
        int data;
        Node leftChild;
        Node rightChild;

        Node(int data) {
            this.data = data;
        }
    }


    public void inOrder(Node root) {

        if (root.leftChild != null)
            inOrder(root.leftChild);

        System.out.println(root.data);

        if (root.rightChild != null)
            inOrder(root.rightChild);

    }


    public void preOrder(Node root) {

        System.out.println(root.data);


        if (root.leftChild != null)
            inOrder(root.leftChild);


        if (root.rightChild != null)
            inOrder(root.rightChild);

    }


    public void postOrder(Node root) {


        if (root.leftChild != null)
            inOrder(root.leftChild);


        if (root.rightChild != null)
            inOrder(root.rightChild);

        System.out.println(root.data);

    }

    public static void main(String args[]) {

        MyTree myTree = new MyTree();

        Node node = new Node(1);

        Node node1 = new Node(2);

        Node node2 = new Node(3);


        myTree.rootNode = node;

        myTree.rootNode.leftChild = node1;

        myTree.rootNode.rightChild = node2;

      /*  myTree.rootNode.leftChild.leftChild = new Node(4);

        myTree.rootNode.leftChild.rightChild = new Node(5);

        myTree.rootNode.rightChild.leftChild = new Node(6);

        myTree.rootNode.rightChild.rightChild = new Node(7);*/


        myTree.inOrder(myTree.rootNode);

        System.out.println();

        System.out.println();

        System.out.println();

        myTree.preOrder(myTree.rootNode);

        System.out.println();

        System.out.println();

        System.out.println();

        myTree.postOrder(myTree.rootNode);


    }
}



