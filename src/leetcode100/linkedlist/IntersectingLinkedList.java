package leetcode100.linkedlist;

import java.util.Stack;

public class IntersectingLinkedList {

    public static class IntersectingNode {
        int val;
        IntersectingNode next;

        IntersectingNode(int x) {
            val = x;
        }
    }


    public IntersectingNode getIntersectingNode(IntersectingNode listOne, IntersectingNode listTwo) {
        IntersectingNode currentOne = listOne;

        IntersectingNode currentTwo = listTwo;

        Stack<IntersectingNode> s1 = new Stack<>();

        Stack<IntersectingNode> s2 = new Stack<>();


        while (currentOne != null && currentTwo != null) {
            if (currentOne != null) {
                s1.push(currentOne);
                currentOne = currentOne.next;
            }

            if (currentTwo != null) {
                s2.push(currentTwo);
                currentTwo = currentTwo.next;
            }

        }


        while ( !s1.isEmpty() || !s2.isEmpty()) {
            if (s1.peek().val == s2.peek().val) {
                System.out.println("s1 = "+s1.peek().val+" s2 = "+s2.peek().val);
                s1.pop();
                s2.pop();

            } else {
                System.out.println("hi s1 = "+s1.peek().val+" s2 = "+s2.peek().val);
                return s1.pop();
            }
        }
        return null;
    }

    public static void main(String args[]) {
        IntersectingLinkedList.IntersectingNode listNode = new IntersectingLinkedList.IntersectingNode(2);
        listNode.next = new IntersectingLinkedList.IntersectingNode(4);
        listNode.next.next = new IntersectingLinkedList.IntersectingNode(3);



        IntersectingLinkedList.IntersectingNode listNode1 = new IntersectingLinkedList.IntersectingNode(5);
        listNode1.next = new IntersectingLinkedList.IntersectingNode(6);
        listNode1.next.next = new IntersectingLinkedList.IntersectingNode(7);


        IntersectingLinkedList.IntersectingNode listNode2 = new IntersectingLinkedList.IntersectingNode(20);
        listNode2.next = new IntersectingLinkedList.IntersectingNode(40);
        listNode2.next.next = new IntersectingLinkedList.IntersectingNode(30);


        listNode.next.next.next =listNode1;
        listNode2.next.next.next =listNode1;





        IntersectingLinkedList.IntersectingNode result = new IntersectingLinkedList().getIntersectingNode(listNode, listNode2);

    }
}
