package com.rottaingmind.ds.trie;

public class TrieNode {
    private final TrieNode[] childrens;
    private boolean isEndOfWord;


    public TrieNode() {
        this.childrens = new TrieNode[26];
        isEndOfWord= false;
    }

    public TrieNode[] getChildrens() {
        return childrens;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }
}
