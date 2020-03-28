package backToBasics;

import linkedlist.MyDoublyLinkedList;

public class MyDoubleLinkedlist {

    Node head;
    Node current;

    class Node {
        int data;
        Node previous;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }


    public void add(int num) {
        Node node = new Node(num);
        if (head == null) {
            head = current = node;
            return;
        } else {
            node.previous = current;
            current.next = node;
            current = node;
        }
    }


    void printAllNodes() {
        if (head == null) {
            print("Empty List", true);
            return;
        }

        Node currentPointer = head;

        while (currentPointer != null) {
            System.out.println();
            if (currentPointer.previous != null)
                print("previous  = " + currentPointer.previous.data, true);
            print("data = " + currentPointer.data, false);
            if (currentPointer.next != null)
                print("next  = " + currentPointer.next.data, false);

            currentPointer = currentPointer.next;
        }
    }


    void print(String s, boolean isNextLine) {
        System.out.print(s);

    }

    public static void main(String args[]) {
        MyDoubleLinkedlist myDoubleLinkedlist = new MyDoubleLinkedlist();
        myDoubleLinkedlist.add(1);
        myDoubleLinkedlist.add(2);
        myDoubleLinkedlist.add(3);
        myDoubleLinkedlist.add(4);
        myDoubleLinkedlist.add(5);

        myDoubleLinkedlist.printAllNodes();

    }

}
