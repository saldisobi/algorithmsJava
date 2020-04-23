package leetcode100.linkedlist;

public class AAddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode addNumbers(ListNode listOne, ListNode listTwo) {

        ListNode currentOne = listOne;
        ListNode currentTwo = listTwo;
        ListNode resultNode = null;
        ListNode finalResultNode = null;

        int carry = 0;

        while (currentOne != null && currentTwo != null) {
            int num = currentOne.val + currentTwo.val + carry;

            if (num >= 10) {
                carry = num / 10;
                num = num % 10;
            }

            ListNode node = new ListNode(num);

            if (resultNode == null) {
                resultNode = node;
                finalResultNode = node;
            } else {
                resultNode.next = node;
            }


            currentOne = currentOne.next;
            currentTwo = currentTwo.next;
            resultNode = resultNode.next;


        }
        return finalResultNode;
    }

    private int listToInt(ListNode listOne) {
        ListNode next = listOne;
        int counter = 1;
        int number = 0;
        while (next != null) {
            number = number + (next.val * counter);
            next = next.next;
            counter = counter * 10;
        }

        return number;
    }

    public static void main(String args[]) {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);

        ListNode listNode1 = new ListNode(5);
        listNode1.next = new ListNode(6);
        listNode1.next.next = new ListNode(4);
        ListNode result = new AAddTwoNumbers().addNumbers(listNode, listNode1);

        while (result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
