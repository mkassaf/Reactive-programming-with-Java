public class SurroundedRegions {

    /*
Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.



Example 1:


Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Notice that an 'O' should not be flipped if:
- It is on the border, or
- It is adjacent to an 'O' that should not be flipped.
The bottom 'O' is on the border, so it is not flipped.
The other three 'O' form a surrounded region, so they are flipped.
Example 2:

Input: board = [["X"]]
Output: [["X"]]


Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.

 */


    private static final int[][] nei = {{1,0},{0,1},{-1,0},{0,-1}};


    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;


        for(int i=1; i< row -1;i++){
            if(board[i][0] == 'O'){
                checkCell(i, 1, board);
            }
            if(board[i][col-1] == 'O'){
                checkCell(i, col-2, board);
            }
        }
        for(int i=1; i< col-1 ;i++){
            if(board[0][i] == 'O'){
                checkCell(1, i, board);
            }
            if(board[row-1][i] == 'O'){
                checkCell(row-2, i, board);
            }
        }
        for(int i=1; i< row -1;i++){
            for(int j=1; j< col-1 ;j++){
                if(board[i][j] == '?'){
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }


    }

    public void checkCell(int i, int j, char[][] board) {
        int row = board.length;
        int col = board[0].length;
        if(i < 1 || i >= row-1 || j < 1 || j >= col-1 || board[i][j] == 'X' || board[i][j] == '?'){
            return;
        }
        board[i][j] = '?';
        for (int[] number : nei){
            checkCell(i + number[0], j + number[1], board);
        }
    }


}
