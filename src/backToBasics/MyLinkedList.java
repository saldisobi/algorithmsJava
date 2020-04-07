package backToBasics;

public class MyLinkedList {

    Node head;
    Node current;

    private class Node {
        int data;
        String key; //using this for hashmap implementation in original not needed
        Node next;

        Node(int data) {
            this.data = data;
        }

        Node(String key, int data) {
            this.data = data;
            this.key = key;
        }
    }

    public void add(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            current = node;
        } else {
            current.next = node;
            current = current.next;
        }
    }

    public void add(String key, int data) {
        Node node = new Node(key, data);
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

    public int getByData(String searchTerm) {

        if (head.key == searchTerm) {

            return head.data;
        }

        Node current = head;


        while (current.next != null) {
            if (current.next.key == searchTerm) {
                return current.next.data;
            }
            current = current.next;
        }

        return -1;
    }


    public int getByData(int searchTerm) {

        if (head.data == searchTerm) {

            return head.data;
        }

        Node current = head;


        while (current.next != null) {
            if (current.next.data == searchTerm) {
                return current.next.data;
            }
            current = current.next;
        }

        return -1;
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


    public int kToLast(int k) {

        int counter = 0;
        Node current = head;
        Node kthFromLast = head;

        while (current != null) {
            if (counter >= k) {
                kthFromLast = kthFromLast.next;
            }
            counter++;
            current = current.next;
        }

        return kthFromLast.data;

    }

    public void deleteNth(int n) {

        int counter = 0;
        Node current = head;

        while (current != null) {

            if (counter == n - 1) {
                current.next = current.next.next;
                return;
            }

            counter++;
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
        myLinkedList.add(6);
        myLinkedList.add(7);
        myLinkedList.add(8);
        myLinkedList.add(9);
        myLinkedList.add(10);
        // myLinkedList.deleteByData(1);

        myLinkedList.deleteNth(4);
        myLinkedList.printAllNodes();
        System.out.println();
        //  System.out.println(myLinkedList.kToLast(3));


    }
}
