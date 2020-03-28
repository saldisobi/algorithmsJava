package backToBasics;

public class MyLinkedList {

    Node head;
    Node current;

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private void add(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            current = node;
        } else {
            current.next = node;
            current = current.next;
        }
    }


    private void deleteByData(int searchTerm) {

        if (head.data == searchTerm) {
            head = head.next;
            return;
        }

        Node current = head;


        while (current.next != null) {
            if (current.next.data == searchTerm) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }

    }


    public void printAllNodes() {
        if (head == null) {
            System.out.print("Empty List");
            return;
        }

        Node current = head;

        while (current != null) {
            System.out.print(current.data);
            current = current.next;
        }
    }


    public static void main(String args[]) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        myLinkedList.deleteByData(4);
        myLinkedList.deleteByData(1);

        myLinkedList.printAllNodes();

    }
}
