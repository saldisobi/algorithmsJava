package backToBasics.dataStructures;

import java.util.*;

public class MyGraphListRepresentation {

    int totalNodes;

    ArrayList<MyLinkedList> graphAdjacencyListRepresentation = new ArrayList<>();

    ArrayList<LinkedList<Integer>> graphAdjacencyListRepresentationNative = new ArrayList<>();

    boolean[] visited;


    MyGraphListRepresentation(int nodeCount) {
        totalNodes = nodeCount;
        visited = new boolean[totalNodes];
        for (int i = 0; i < nodeCount; i++) {
            graphAdjacencyListRepresentation.add(new MyLinkedList());
            graphAdjacencyListRepresentationNative.add(new LinkedList<Integer>());
            visited[i] = false;
        }
    }

    public void insert(int startVertex, int endVertex) {
        graphAdjacencyListRepresentation.get(startVertex).add(endVertex);
        graphAdjacencyListRepresentationNative.get(startVertex).add(endVertex);
    }

    public boolean isConnected(int startEdge, int destEdge) {
        return graphAdjacencyListRepresentation.get(startEdge).getByData(destEdge) >= 0;
    }

    public void depthFirstSearch(int currentNode) {
        if (visited[currentNode])
            return;
        else {
            System.out.println(currentNode);
            visited[currentNode] = true;
            MyLinkedList linkedList = graphAdjacencyListRepresentation.get(currentNode);
            if (linkedList.head == null) {
                return;
            }

            MyLinkedList.Node current = linkedList.head;

            while (current != null) {
                depthFirstSearch(current.data);
                current = current.next;
            }
        }


    }

    public void depthFirstIterative(int currentNode) {
        Stack<Integer> myStack = new Stack<>();

        myStack.push(currentNode);

        while (!myStack.isEmpty()) {
            int currentVisiting = myStack.pop();
            System.out.println(currentVisiting);
            visited[currentVisiting] = true;
            LinkedList linkedList = graphAdjacencyListRepresentationNative.get(currentVisiting);

            Iterator a = linkedList.iterator();
            while (a.hasNext()) {
                Integer i = (Integer) a.next();
                if (!visited[i])
                    myStack.push(i);
            }
        }
    }

    public void breadthFirstIterative(int currentNode) {
        Queue<Integer> myQueue = new LinkedList<>();

        myQueue.add(currentNode);

        while (!myQueue.isEmpty()) {
            int currentVisiting = myQueue.poll();
            System.out.println(currentVisiting);
            visited[currentVisiting] = true;
            LinkedList linkedList = graphAdjacencyListRepresentationNative.get(currentVisiting);

            Iterator a = linkedList.iterator();
            while (a.hasNext()) {
                Integer i = (Integer) a.next();
                if (!visited[i])
                    myQueue.add(i);
            }
        }
    }



    public static void main(String args[]) {
        MyGraphListRepresentation myGraphListRepresentation = new MyGraphListRepresentation(10);
        myGraphListRepresentation.insert(0, 1);
        myGraphListRepresentation.insert(0, 2);
        myGraphListRepresentation.insert(0, 3);
        myGraphListRepresentation.insert(1, 4);
        myGraphListRepresentation.insert(1, 5);
        myGraphListRepresentation.insert(2, 6);
        myGraphListRepresentation.insert(2, 7);
        myGraphListRepresentation.insert(3, 8);
        myGraphListRepresentation.insert(3, 9);


        System.out.println(myGraphListRepresentation.isConnected(0, 1) + "");

        System.out.println(myGraphListRepresentation.isConnected(0, 4) + "");

        //   myGraphListRepresentation.depthFirstSearch(0);

        myGraphListRepresentation.breadthFirstIterative(0);


    }
}
