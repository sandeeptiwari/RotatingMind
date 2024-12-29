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


    /**
     * Find all string by given prefix
     * @param prefix
     *
     * Given a node, find how many nodes in its subtree have isString = true
     *
     * at any node counter will hold total number of string in that path
     *
     */
    public int find(String prefix, int pos, Node root) {

        if(root == null) return 0;

        if (pos == prefix.length()) {
            return root.getNumOfSubTree();
        }

        return find(prefix, pos + 1, root.getChildrens()[prefix.charAt(pos) - 'a'] );
    }

    public Node insert(String charAtNode, Node root) {


     return null;
    }
}
