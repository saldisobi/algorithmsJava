package google;


import java.util.PriorityQueue;

public class MergeKSortedLists {


    public static class MergeKSortedListsListNode  {
        int val;
        MergeKSortedListsListNode next;

        MergeKSortedListsListNode() {
        }

        MergeKSortedListsListNode(int val) {
            this.val = val;
        }

        MergeKSortedListsListNode(int val, MergeKSortedListsListNode next) {
            this.val = val;
            this.next = next;
        }

    }


    public MergeKSortedListsListNode mergeListNodes(MergeKSortedListsListNode[] listNodes) {

        PriorityQueue<Integer> minPriorityQueue = new PriorityQueue();

        MergeKSortedListsListNode mergeListNode = null;

        MergeKSortedListsListNode currentNode = null;

        for (int i = 0; i < listNodes.length; i++) {
            MergeKSortedListsListNode listNode = listNodes[i];
            while (listNode != null) {
                minPriorityQueue.add(listNode.val);
                listNode = listNode.next;
            }
        }

        mergeListNode = new MergeKSortedListsListNode(minPriorityQueue.remove());

        currentNode = mergeListNode;

        while (minPriorityQueue.size() > 0) {
            currentNode.next =new MergeKSortedListsListNode(minPriorityQueue.remove());
            currentNode = currentNode.next;
        }

        return mergeListNode;
    }

    public static void main(String args[]) {
        MergeKSortedListsListNode listNode = new MergeKSortedListsListNode(1);
        listNode.next = new MergeKSortedListsListNode(4);
        listNode.next.next = new MergeKSortedListsListNode(5);


        MergeKSortedListsListNode listNode1 = new MergeKSortedListsListNode(1);
        listNode1.next = new MergeKSortedListsListNode(3);
        listNode1.next.next = new MergeKSortedListsListNode(4);

        MergeKSortedListsListNode listNode2 = new MergeKSortedListsListNode(2);
        listNode2.next = new MergeKSortedListsListNode(6);


        new MergeKSortedLists().mergeListNodes(new MergeKSortedListsListNode[]{listNode, listNode1, listNode2});
    }

}
