package backToBasics.dataStructures;

public class MyHashMap {

    MyLinkedList[] myLinkedListArray = new MyLinkedList[16];


    public void put(String key, int value) {

        int index = getIndexForKey(key);
        if (myLinkedListArray[index] == null) {
            MyLinkedList myLinkedList = new MyLinkedList();
            myLinkedList.add(key, value);
            myLinkedListArray[index] = myLinkedList;
        } else {
            myLinkedListArray[index].add(key, value);
        }

    }

    public int getvalueForKey(String key) {
        int index = getIndexForKey(key);

        MyLinkedList linkedList = myLinkedListArray[index];

        return linkedList.getByData(key);

    }

    private int getIndexForKey(String key) {
        return (key.hashCode() % 15);
    }

    public static void main(String args[]) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("saldi", 1);
        myHashMap.put("ruuch", 10);

        System.out.println(myHashMap.getvalueForKey("ruuch") + "");

    }

}
