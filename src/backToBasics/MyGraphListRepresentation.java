package backToBasics;

import java.util.ArrayList;

public class MyGraphListRepresentation {


    ArrayList<MyLinkedList> graphAdjacencyListRepresentation = new ArrayList<>();


    MyGraphListRepresentation(int nodeCount) {
        for (int i = 0; i < nodeCount; i++) {
            graphAdjacencyListRepresentation.add(new MyLinkedList());
        }
    }

    public void insert(int startVertex, int endVertex) {
        graphAdjacencyListRepresentation.get(startVertex).add(endVertex);
    }

    public boolean isConnected(int startEdge, int destEdge) {
        return graphAdjacencyListRepresentation.get(startEdge).getByData(destEdge) >= 0;
    }

    public static void main(String args[]) {
        MyGraphListRepresentation myGraphListRepresentation = new MyGraphListRepresentation(3);
        myGraphListRepresentation.insert(0, 1);
        myGraphListRepresentation.insert(0, 2);
        myGraphListRepresentation.insert(0, 3);
        myGraphListRepresentation.insert(1, 3);

        System.out.println(myGraphListRepresentation.isConnected(0, 1) + "");

        System.out.println(myGraphListRepresentation.isConnected(0, 4) + "");
    }
}
