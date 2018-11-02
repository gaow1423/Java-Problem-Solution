/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.

*/

class Solution {
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(helper(board, w, i, j, 0))
                    return true;
            }
        }
        return false;
    }
    public boolean helper(char[][] board, char[] w, int i, int j, int k){
        if(k == w.length){
            return true;
        }
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return false;
        if(board[i][j] != w[k])
            return false;
        
        board[i][j] ^= 256;
        boolean exist = helper(board, w, i+1, j, k+1) || helper(board, w, i-1, j, k+1) || helper(board, w, i, j+1, k+1) || helper(board, w, i, j-1, k+1);
        board[i][j] ^= 256;
        return exist;
    }
}