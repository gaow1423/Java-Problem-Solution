/*
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:
[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
Example 2:
[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
*/

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
        return 0;    
    }
    int m = grid.length, n = grid[0].length;
    int max = 0;
    int[] count = new int[1];
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(grid[i][j] == 1){
                count[0] = 0;
                dfs(grid, i, j, m, n, count);       
                max = Math.max(count[0], max);
            }
        }
    }
    return max;
}

private void dfs(int[][] grid, int i, int j, int m, int n, int[] count){
    if(i < 0 || j < 0 || i>= m || j >= n || grid[i][j] != 1){
        return;    
    }
    //marked visited;
    grid[i][j] = -1;
    count[0]++;
    dfs(grid, i + 1, j, m, n, count);
    dfs(grid, i - 1, j, m, n, count);
    dfs(grid, i, j + 1, m, n, count);
    dfs(grid, i, j - 1, m, n, count);

    }
}