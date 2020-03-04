package linkedlist;


class Solution {



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        return toLinkedList(toNumber(l1) + toNumber(l2));
    }

    private int toNumber(ListNode l1) {
        int num = l1.val;
        int counter = 0;
        ListNode currentPointer = l1.next;
        while (currentPointer != null) {
            counter++;
            int powerMultiplier = (int) Math.pow(10, counter);
            num = num + powerMultiplier * currentPointer.val;
            currentPointer = currentPointer.next;
        }

        return num;
    }

    private ListNode toLinkedList(int num) {
        int length = Integer.toString(num).length();

        ListNode linkNode = null;

        ListNode currentNode = null;


        while(length>0){

            int rem = num%10;
            ListNode link = new ListNode(num%10);
            num = num /10;
            if(linkNode==null){
                linkNode = link;
                currentNode = link;

            }else{
                currentNode.next = link;
                currentNode  = link;
            }

            length --;
        }

        return  linkNode;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode l3 =    new  Solution().addTwoNumbers(l1,l2);

        System.out.println(l3.val);
        System.out.println(l3.next.val);
        System.out.println(l3.next.next.val);
    }
}