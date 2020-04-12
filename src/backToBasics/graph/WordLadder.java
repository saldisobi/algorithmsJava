package backToBasics.graph;

import java.util.*;

public class WordLadder {


    class LadderNode {
        String word;
        int level;

        LadderNode(String word, int level) {

            this.word = word;
            this.level = level;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int wordLength = beginWord.length();

        Map<String, List<String>> graph = new HashMap<>();

        Queue<LadderNode> wordLadder = new LinkedList();

        Map<String, Boolean> visited = new HashMap<>();

        visited.put(beginWord, true);


        wordList.forEach(word -> {
            for (int i = 0; i < wordLength; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, wordLength);
                List<String> allCombinationList = graph.getOrDefault(newWord, new ArrayList<>());
                allCombinationList.add(word);
                graph.put(newWord, allCombinationList);
            }
        });


        wordLadder.offer(new LadderNode(beginWord, 1));

        while (!wordLadder.isEmpty()) {
            LadderNode ladderNode = wordLadder.poll();
            String currentWord = ladderNode.word;
            for (int i = 0; i < wordLength; i++) {
                String newWord = currentWord.substring(0, i) + "*" + currentWord.substring(i + 1, wordLength);
                for (String word : graph.getOrDefault(newWord, new ArrayList<>())) {

                    if (word.equals(endWord)) {
                        int level = ladderNode.level;
                        level++;
                        return level;
                    }

                    if (!visited.containsKey(word)) {
                        visited.put(word, true);
                        int level = ladderNode.level;
                        wordLadder.add(new LadderNode(word, level + 1));
                    }
                }
            }
        }

        return 0;
    }


    public static void main(String args[]) {
        ArrayList<String> dictionary = new ArrayList<>();
        dictionary.add("hot");
        dictionary.add("dot");
        dictionary.add("dog");
        dictionary.add("lot");
        dictionary.add("log");
        dictionary.add("cog");
       System.out.println( new WordLadder().ladderLength("hit", "hot", dictionary));
    }
}
