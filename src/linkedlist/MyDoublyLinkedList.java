package linkedlist;

public class MyDoublyLinkedList<T> {

    Node headNode;
    Node currentNode;



    class Node<T> {
        T data;
        Node next;
        Node previous;

        Node(T data) {
            this.data = data;
        }

        Node(T data, Node next, Node previous) {
            this.data = data;
        }

    }


    void insert(T data) {
        Node node = new Node<T>(data);


        if (headNode == null) {
            headNode = node;
            currentNode = node;
            return;
        } else {
            node.previous = currentNode;
            currentNode.next = node;
            currentNode = node;
        }
    }

    void delete() {

    }

    void printLList() {
        if (headNode == null) {
            print("Empty List");
        } else {
            Node pointerNode = headNode;
            while (pointerNode != null) {
                print(pointerNode.data.toString());
                pointerNode = pointerNode.next;
            }
        }
    }

    void print(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {

        MyDoublyLinkedList myDoublyLinkedList = new MyDoublyLinkedList<Integer>();
        myDoublyLinkedList.insert(10);
        myDoublyLinkedList.insert(20);
        myDoublyLinkedList.insert(30);
        myDoublyLinkedList.insert(40);

        myDoublyLinkedList.printLList();
    }
}
