package backToBasics;

import java.util.HashMap;
import java.util.Map;

public class MyTrie {

    class TrieNode {
        Map<Character, TrieNode> characterMap = new HashMap<>();
        boolean endOfWord = false;
    }


    private TrieNode mRootTrieNode;

    MyTrie() {
        mRootTrieNode = new TrieNode();
    }

    public void insertWord(String word) {
        insertWord(0, word, mRootTrieNode);
    }

    private void insertWord(int i, String word, TrieNode currentNode) {
        if (i == word.length()) {
            currentNode.endOfWord = true;
            return;
        }

        if (currentNode.characterMap.containsKey(word.charAt(i))) {
            currentNode = currentNode.characterMap.get(word.charAt(i));
        } else {
            TrieNode node = new TrieNode();
            currentNode.characterMap.put(word.charAt(i), node);
            currentNode = node;
        }
        i++;
        insertWord(i, word, currentNode);
    }


    public boolean contains(String word) {

        return contains(0, mRootTrieNode, word);
    }

    private boolean contains(int i, TrieNode node, String word) {
        if (i == word.length()) {
            return node.endOfWord;
        }
        if (node.characterMap.containsKey(word.charAt(i))) {
            node = node.characterMap.get(word.charAt(i));
            i++;
            return contains(i, node, word);
        } else {
            return false;
        }

    }

    public static void main(String args[]) {
        MyTrie myTrie = new MyTrie();

        myTrie.insertWord("abc");
        myTrie.insertWord("abg");
        myTrie.insertWord("saldi");
        myTrie.insertWord("abgd");

        System.out.println(myTrie.contains("saldi"));

        System.out.println(myTrie.contains("ab"));
    }
}
