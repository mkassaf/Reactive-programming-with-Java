import java.util.*;

public class NumberOfIslands {

    public static void main(String[] args) {
        NumberOfIslands o = new NumberOfIslands();

        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(o.numIslands(grid));
    }
    private static final int[][] nei = {{1,0},{0,1},{-1,0},{0,-1}};
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i=0; i< grid.length; i++){
            for (int j=0; j< grid[i].length; j++){
                if (grid[i][j] == '1'){
                    count ++;
                    markNeigAsVisited(i, j, grid);

                }
            }
        }

        return count;
    }

    private void markNeigAsVisited(int i, int j, char[][] grid) {
        grid[i][j] = '0';

        for (int[] n : nei){
            int ii = i +  n[0];
            int jj = j +  n[1];
            if( ii >= 0 && ii < grid.length && jj >=0 && jj < grid[0].length){
                if (grid[ii][jj] == '1'){
                    markNeigAsVisited(ii, jj, grid);
                }
            }
        }
    }

}
