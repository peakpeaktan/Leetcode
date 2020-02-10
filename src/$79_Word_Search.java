/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
The same letter cell may not be used more than once.

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

public class $79_Word_Search {

    public static boolean exist(char[][] board, String word) {

        if(board.length == 0 || board[0].length == 0 ){
            return false;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];

        char[] charArray = word.toCharArray();

        for (int i = 0; i < board.length ; i++) {

            for (int j = 0; j < board[0].length ; j++) {

                if(helper(board, visited, i, j, charArray,0)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean helper(char[][] board, boolean[][] visited , int i, int j, char[] charArray, int index) {

        if (index == charArray.length) return true;//already found all the letters

        if(i < 0 || i == board.length || j < 0 || j == board[0].length) return false;//out of bound check

        if(visited[i][j] == true) return false;//already visited

        if(board[i][j] != charArray[index]) return false;//if not equal

        visited[i][j] = true;//mark visited

        boolean exist = helper(board, visited, i+1, j, charArray,index+1) ||
                        helper(board, visited, i-1, j, charArray,index+1)||
                        helper(board, visited, i, j+1, charArray,index+1)||
                        helper(board, visited, i, j-1, charArray,index+1);

        visited[i][j] = false;//reset the mark

        return exist;

    }
}
