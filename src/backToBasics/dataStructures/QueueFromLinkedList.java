package backToBasics.dataStructures;

public class QueueFromLinkedList {

    Node head;

    Node tail;

    class Node {
        int data;
        Node previous;
        Node next;

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node prev) {
            this.data = data;
            this.previous = prev;
        }
    }


    void push(int data) {

        if (head == null) {
            Node node = new Node(data);
            head = node;
            tail = node;
        } else {
            Node node = new Node(data, head);
            head.next = node;
            head = node;
        }
    }

    int peek() {

        System.out.println(tail.data + "");
        return tail.data;
    }

    void pop() {
        tail = tail.next;
    }

    public static void main(String args[]) {
        QueueFromLinkedList stackFromLinkedList = new QueueFromLinkedList();
        stackFromLinkedList.push(1);
        stackFromLinkedList.push(12);
        stackFromLinkedList.push(31);
        stackFromLinkedList.push(12);
        stackFromLinkedList.push(13);

        stackFromLinkedList.peek();

        stackFromLinkedList.pop();

        stackFromLinkedList.peek();

        stackFromLinkedList.push(222);

        stackFromLinkedList.peek();

        stackFromLinkedList.pop();

        stackFromLinkedList.pop();

        stackFromLinkedList.peek();

        stackFromLinkedList.pop();

        stackFromLinkedList.peek();

        stackFromLinkedList.pop();

        stackFromLinkedList.peek();

        stackFromLinkedList.pop();

        stackFromLinkedList.peek();



    }
}
