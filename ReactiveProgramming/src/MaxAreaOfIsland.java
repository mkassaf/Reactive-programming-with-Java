


public class MaxAreaOfIsland {


    private static final int[][] nei = {{1,0},{0,1},{-1,0},{0,-1}};

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int i=0; i < grid.length; i++){
            for (int j=0; j< grid[0].length; j++){
                if (grid[i][j] == 1){
                    int tmp = countSize(i,j, grid);
                    if (tmp > maxArea){
                        maxArea = tmp;
                    }
                    j++;
                }

            }
        }


        return maxArea;
    }

    private int countSize(int i, int j, int[][] grid) {
        grid[i][j] = 0;
        int count = 1;
        for (int[] point : nei){
            if (i+point[0] < 0 || i+point[0] >= grid.length
                    || j+point[1] < 0 || j+point[1] >= grid[0].length
                    || grid[i+point[0]][j+point[1]] == 0){
                continue;
            }
            count += countSize(i+point[0], j+point[1], grid);
        }

        return count;
    }

}
