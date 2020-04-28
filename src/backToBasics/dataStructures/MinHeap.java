package backToBasics.dataStructures;


public class MinHeap {
    private int capacity = 10;
    private int size = 0;


    int[] internalArray = new int[capacity];


    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;

    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;

    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;

    }


    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) < size;
    }


    private int getLeftChild(int index) {
        return internalArray[getLeftChildIndex(index)];
    }

    private int getRightChild(int index) {
        return internalArray[getRightChildIndex(index)];
    }

    private int getParent(int index) {
        return internalArray[getParentIndex(index)];
    }


    private void swap(int indexOne, int indexTwo) {
        int temp = internalArray[indexOne];
        internalArray[indexOne] = internalArray[indexTwo];
        internalArray[indexTwo] = temp;
    }

    public void insert(int data) {

        internalArray[size] = data;
        size++;
        heapifyUp(size - 1);
    }


    public int peek() {
        if (size == 0)
            throw new IllegalStateException();

        int item = internalArray[0];

        internalArray[0] = internalArray[size - 1];
        size--;
        heapifyDown(0);
        return item;
    }

    private void heapifyDown(int index) {
        if (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && getRightChild(index) < getLeftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (internalArray[index] > internalArray[smallerChildIndex]) {
                swap(index, smallerChildIndex);
                heapifyDown(smallerChildIndex);
            }
        }

    }

    private void heapifyUp(int affectedIndex) {
        if (getParent(affectedIndex) > internalArray[affectedIndex]) {
            swap(getParentIndex(affectedIndex), affectedIndex);
            affectedIndex = getParentIndex(affectedIndex);
            heapifyUp(affectedIndex);
        }
    }

    class MyHeapNode{
        int data;
        int priority;
    }

    public static void main(String args[]) {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(1);
        minHeap.insert(6);
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(8);
        minHeap.insert(9);


        //   minHeap.print();

        System.out.print(minHeap.peek());
        System.out.print(minHeap.peek());
        System.out.print(minHeap.peek());
        System.out.print(minHeap.peek());
        System.out.print(minHeap.peek());
        System.out.print(minHeap.peek());


    }


}
