package linkedlist;

public class MyLinkedList {

    Node currentNode;

    Node sentinal;


    class Node {

        int data;

        Node next;

        Node(int data) {

            this.data = data;
            this.next = null;

        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    void add(int data) {
        Node node = new Node(data);

        if (sentinal == null) {
            currentNode = node;
            sentinal = node;
        } else {
            currentNode.next = node;
            currentNode = node;
        }

    }


    void iterate() {
        System.out.println("\n \n ");
        Node localSentinal = sentinal;
        while (localSentinal != null) {
            System.out.println(localSentinal.data);
            localSentinal = localSentinal.next;
        }
    }

    void addBegin(int data) {
        Node node = new Node(data);
        if (sentinal == null) {
            sentinal = node;
        } else {
            Node tempSent = sentinal;
            sentinal = node;
            sentinal.next = tempSent;
        }
    }

    void insertAfter(int findData, int data) {

        Node node = new Node(data);

        Node localSentinal = new Node(sentinal.data, sentinal.next);


        if (localSentinal.data == findData) {

            System.out.println("local " + localSentinal.next.data);
            sentinal.next = node;
            System.out.println("after " + localSentinal.next.data);
            node.next = localSentinal.next;
        }

        while (localSentinal != null) {
            if (localSentinal.data == findData) {
                Node tempNode = new Node(localSentinal.data, localSentinal.next);
                node.next = tempNode.next;
                localSentinal.next = node;
                break;
            } else {
                localSentinal = localSentinal.next;
            }
        }
    }


    void findAndDelete(int data) {
        Node localSentinal = sentinal;

        if (localSentinal.data == data) {
            //found at first point only

            sentinal = localSentinal.next;
        }

        while (localSentinal != null) {
            if (localSentinal.next != null && localSentinal.next.data == data) {
                localSentinal.next = localSentinal.next.next;
                break;
            }
            localSentinal = localSentinal.next;
        }

    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);


        linkedList.iterate();

        linkedList.findAndDelete(30);

        linkedList.iterate();

        linkedList.findAndDelete(10);

        linkedList.iterate();

        linkedList.findAndDelete(40);

        linkedList.iterate();

        linkedList.addBegin(100);

        linkedList.addBegin(200);

        linkedList.iterate();

        linkedList.insertAfter(100, 23);
        linkedList.insertAfter(23, 233);

        linkedList.iterate();


    }
}
