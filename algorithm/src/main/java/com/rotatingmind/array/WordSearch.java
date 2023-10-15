package com.rotatingmind.array;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class WordSearch {

    class Seen {
        private int iPos;
        private int jPos;

        public Seen(int iPos, int jPos) {
            this.iPos = iPos;
            this.jPos = jPos;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Seen)) return false;
            Seen seen = (Seen) o;
            return iPos == seen.iPos && jPos == seen.jPos;
        }

        @Override
        public int hashCode() {
            return Objects.hash(iPos, jPos);
        }
    }


    public boolean exist(char[][] board, String word) {
        int position = 0;
        int len = board.length;
        Set<Seen> seen = new HashSet<>();
        return dfs(seen, board, word, 0, 0, 0);
    }

    private boolean dfs(Set<Seen> seen, char[][] board, String word, int i, int j, int pos) {

        if ((i < 0 || j < 0 ) ||
                seen.contains(new Seen(i, j)) ||
                pos >= word.length() ||
                (i >= board.length || j >= board[i].length )) return false;

        if (board[i][j] == word.charAt(pos)) {
            pos++;
            dfs(seen, board, word, i, j + 1, pos);
            dfs(seen, board, word, i + 1, j, pos);
            dfs(seen, board, word, i - 1, j, pos);
            dfs(seen, board, word, i, j - 1, pos);
            seen.add(new Seen(i, j));
            return true;
         } else {
            dfs(seen, board, word, i, j + 1, pos);
            dfs(seen, board, word, i + 1, j, pos);
            dfs(seen, board, word, i - 1, j, pos);
            dfs(seen, board, word, i, j - 1, pos);
            seen.add(new Seen(i, j));
            return false;
        }
    }


    /*
       3 X 4 matrix
     */
    public static void main(String[] args) {
        char boards[][] = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "ABCCED";
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(boards, word));
    }

}
