package backToBasics.dataStructures;

public class StackFromLinkedList {

    Node top;

    class Node {
        int data;
        Node previous;

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node prev) {
            this.data = data;
            this.previous = prev;
        }
    }


    void push(int data) {

        if (top == null) {
            Node node = new Node(data);
            top = node;
        } else {
            Node node = new Node(data, top);
            top = node;
        }
    }

    int peek() {

        System.out.println(top.data + "");
        return top.data;
    }

    void pop() {
        top = top.previous;
    }

    public static void main(String args[]) {
        StackFromLinkedList stackFromLinkedList = new StackFromLinkedList();
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


    }
}
