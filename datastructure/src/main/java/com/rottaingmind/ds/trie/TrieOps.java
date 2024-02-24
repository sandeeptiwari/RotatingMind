package com.rottaingmind.ds.trie;

public class TrieOps {

    public void insert(TrieNode root, String key) {
        TrieNode currNode = root;
        int n = key.length();

        for (int i = 0; i < n; i++) {
            char ch = key.charAt(i);
            if (currNode.getChildrens()[ch - 'a'] == null) {
                TrieNode newNode = new TrieNode();
                currNode.getChildrens()[ch-'a'] = newNode;
            }
            currNode = currNode.getChildrens()[ch - 'a'];
        }
        currNode.setEndOfWord(true);
    }

    public boolean search(TrieNode root, String key) {
        TrieNode currNode = root;
        int n = key.length();

        for (int i = 0; i < n; i++) {
            char ch = key.charAt(i);
            if (currNode.getChildrens()[ch - 'a'] == null) {
                return false;
            }
            currNode = currNode.getChildrens()[ch - 'a'];
        }
        return currNode.isEndOfWord();
    }
}
