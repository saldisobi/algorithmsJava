package leetcode100.linkedlist;

public class EvenOddLinkedList {

    public static class EvenOddListNode {
        int val;
        EvenOddListNode next;

        EvenOddListNode(int x) {
            val = x;
        }


    }


    public EvenOddListNode getEvenOddGroup(EvenOddListNode input) {
        EvenOddListNode even = input.next;
        EvenOddListNode odd = input;
        EvenOddListNode evenHead = even;

        while (even!=null&&even.next!=null){
            odd.next = even.next;

            odd = odd.next;

            even.next = odd.next;

            even = even.next;
        }

        odd.next = evenHead;

        return input;
    }


    public static void main(String args[]) {
        EvenOddLinkedList.EvenOddListNode listNode = new EvenOddLinkedList.EvenOddListNode(1);
        listNode.next = new EvenOddLinkedList.EvenOddListNode(2);
        listNode.next.next = new EvenOddLinkedList.EvenOddListNode(3);
        listNode.next.next.next = new EvenOddLinkedList.EvenOddListNode(4);
        listNode.next.next.next.next = new EvenOddLinkedList.EvenOddListNode(5);
        new EvenOddLinkedList().getEvenOddGroup(listNode);
    }
}
