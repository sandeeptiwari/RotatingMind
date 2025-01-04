package com.rottaingmind.ds.graph;

import java.util.*;

/**
 * The Word Ladder problem is a classic graph problem. It involves finding the shortest transformation sequence from a
 * start word to an end word, changing only one letter at a time,
 * and ensuring that all intermediate words are valid dictionary words.
 */
public class WordLadder {

    /**
     * Problem Statement
     * Given:
     * <p>
     * A startWord (e.g., "hit").
     * An endWord (e.g., "cog").
     * A wordList containing valid intermediate words (e.g., ["hot", "dot", "dog", "lot", "log", "cog"]).
     * Find the shortest transformation sequence length such that:
     * <p>
     * Only one letter can change at a time.
     * Each transformed word must exist in the wordList.
     * The transformation must end at endWord.
     * <p>
     * Input:
     * startWord = "hit"
     * endWord = "cog"
     * wordList = ["hot", "dot", "dog", "lot", "log", "cog"]
     * Output:
     * The shortest transformation length is 5.
     * Explanation: hit → hot → dot → dog → cog.
     * <p>
     * Step-by-Step Explanation
     * The solution involves treating the words as nodes in a graph and using Breadth-First Search (BFS) to find the shortest path.
     * <p>
     * Steps
     * Represent the Graph:
     * <p>
     * Each word is a node.
     * There is an edge between two nodes if they differ by exactly one letter.
     * Perform BFS:
     * <p>
     * Start from the startWord.
     * Explore all valid transformations (i.e., neighbors in the graph).
     * Keep track of visited words to avoid cycles.
     * End Condition:
     * <p>
     * Stop the BFS when the endWord is found.
     * Return the length of the path.
     * <p>
     * Time Complexity Analysis
     * 1. Word Transformations:
     * For each word, we attempt to change each character (word.length() times) and try all possible replacements (26 lowercase letters).
     * Hence, transforming a word takes
     * 𝑂(26 x word.length())=𝑂(𝐿)
     * O(26×word.length())=O(L), where 𝐿=26 × word.length()
     * L=26×word.length().
     * 2. Breadth-First Search (BFS):
     * Each word in the wordList can be added to the queue once.
     * For
     * 𝑁
     * N words in the wordList:
     * BFS processes all possible transformations, which requires
     * 𝑂(𝑁 ×𝐿)
     * O(N×L).
     * Overall Time Complexity:𝑂(𝑁×)
     * O(N×L)
     * Where:
     * <p>
     * 𝑁
     * N is the size of the wordList.
     * 𝐿
     * L is the length of the words.
     * Space Complexity Analysis
     * 1. Queue:
     * In the worst case, all words could be in the queue simultaneously, requiring
     * 𝑂(N)
     * O(N) space.
     * 2. Visited Set:
     * Stores all visited words, requiring
     * 𝑂(𝑁)
     * O(N) space.
     * 3. WordSet:
     * The Set of all words in the wordList, requiring
     * 𝑂 (N)
     * O(N) space.
     * Overall Space Complexity:
     * 𝑂(𝑁+𝑁)=𝑂(N)
     * O(N+N)=O(N)
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Convert the wordList into a set for O(1) lookup
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0; // If endWord is not in the wordList, transformation is impossible
        }

        // Initialize BFS queue
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        // Keep track of visited words
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1; // Start at level 1 (initial word)

        while (!queue.isEmpty()) {
            int size = queue.size(); // Number of words in the current level

            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                // Try transforming currentWord one letter at a time
                for (int j = 0; j < word.length(); j++) {
                    char[] wordChars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordChars[j] = c; // Replace one character
                        String transformedWord = new String(wordChars);

                        // If we reach the endWord, return the level
                        if (transformedWord.equals(endWord)) {
                            return level + 1;
                        }

                        // Add the transformed word to the queue if it's valid
                        if (wordSet.contains(transformedWord) && !visited.contains(transformedWord)) {
                            queue.add(transformedWord);
                            visited.add(transformedWord);
                        }
                    }
                }
            }
            level++; // Increment the level after processing the current layer
        }
        return 0;// If BFS completes without finding endWord, return 0
    }


    /**
     * Optimizations
     * <p>
     * 1. Bi-Directional BFS
     * Instead of searching from the startWord to endWord, we can simultaneously search from both ends (forward and backward). This reduces the search space because the two fronts meet in the middle.
     * <p>
     * Algorithm:
     * Start BFS from both startWord and endWord.
     * At each step, expand the smaller front (fewer nodes to process).
     * If the two fronts meet, the shortest path is found.
     * Benefits:
     * Reduces the depth of the BFS from N to 𝑁/2, effectively halving the number of iterations.
     * Complexity with Bi-Directional BFS:
     * Time Complexity:𝑂((𝑁/2)×𝐿)=𝑂(𝑁×𝐿/2)
     * O((N/2)×L)=O(N×L/2)
     * Space Complexity:
     * O(N)
     * Implementation of Bi-Directional BFS:
     */

    public static int ladderLengthV1(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        int level = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // Always expand the smaller set
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextLevel = new HashSet<>();
            for (String word : beginSet) {
                char[] wordChars = word.toCharArray();
                for (int i = 0; i < wordChars.length; i++) {
                    char originalChar = wordChars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordChars[i] = c;
                        String transformedWord = new String(wordChars);

                        if (endSet.contains(transformedWord)) {
                            return level + 1; // Found the connection
                        }

                        if (wordSet.contains(transformedWord)) {
                            nextLevel.add(transformedWord);
                            wordSet.remove(transformedWord); // Mark as visited
                        }
                    }
                    wordChars[i] = originalChar; // Restore original character
                }
            }
            beginSet = nextLevel;
            level++;
        }
        return 0; // No path found
    }


    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        int result = ladderLength(beginWord, endWord, wordList);
        System.out.println("Shortest transformation length: " + result);
    }

}
