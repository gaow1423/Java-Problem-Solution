/*
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.

Example 1:

11000
11000
00011
00011
Given the above grid map, return 1.
Example 2:

11011
10000
00001
11011
Given the above grid map, return 3.

Notice that:
11
1
and
 1
11
are considered different island shapes, because we do not consider reflection / rotation.
Note: The length of each dimension in the given grid does not exceed 50.
*/
class Solution {
    String l;
    private int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numDistinctIslands(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        List<String> list = new ArrayList<> ();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    l = "";
                    dfs(grid, i, j, new int[]{0, 0});
                    // System.out.println(l);
                    if(!list.contains(l))
                        list.add(l);
                }
            }
        }
        return list.size();
    }
    public void dfs(int[][] grid, int i, int j, int[] dir){
        i += dir[0];
        j += dir[1];
        
        
        
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            l = l + "n";
            return;
        }
        
        grid[i][j] = 0;
        
        // System.out.println(dir[0]);
        // System.out.println(dir[1]);
        if(dir[0] == 0 && dir[1] == 0)
            l = l + "s";
        else if(dir[0] == 1 && dir[1] == 0)
            l = l + "r";
        else if(dir[0] == -1 && dir[1] == 0)
            l = l + "l";
        else if(dir[0] == 0 && dir[1] == 1)
            l = l + "u";
        else if(dir[0] == 0 && dir[1] == -1)
            l = l + "d";
        
        // System.out.println(l);
        
        
        
        for(int[] arr : dirs){
            dfs(grid, i, j, arr);
        }
        
    }
}