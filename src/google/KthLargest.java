package google;


import java.util.PriorityQueue;

public class KthLargest {

    public int getKthLargest(int[] input, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        for (int i = 0; i < input.length; i++) {
            minHeap.add(input[i]);
            if (minHeap.size() > k)
                minHeap.remove();
        }


        return minHeap.remove();

    }

    public static void main(String args[]) {
        System.out.print(new KthLargest().getKthLargest(new int[]{1, 2, 3, 4, 5, 6, 8, -1, -5, 100}, 5));
    }
}
