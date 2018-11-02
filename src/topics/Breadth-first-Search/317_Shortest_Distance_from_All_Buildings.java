/*
You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.
Example:

Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]

1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0

Output: 7 

Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
             the point (1,2) is an ideal empty land to build a house, as the total 
             travel distance of 3+3+1=7 is minimal. So return 7.
Note:
There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
*/
class Solution {
    public int shortestDistance(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int dis[][] = new int[r][c];
        int reach[][] = new int[r][c];
        int building = 0;
        final int[] shift = new int[] {0, 1, 0, -1, 0};
        if(grid == null || grid[0].length == 0)
            return 0;
        List<int[]> list = new ArrayList<> ();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == 1){
                    list.add(new int[] {i, j});
                    building++;
                }
                
            }
        }
        for(int i = 0; i < list.size(); i++){
            int k[][] = new int[r][c];
            boolean visited[][] = new boolean[r][c];
            Queue<int[]> q = new LinkedList<> ();
            q.add(new int[] {list.get(i)[0], list.get(i)[1]});
            
            while(!q.isEmpty()){
                int[] cor = q.poll();
                int nextr;
                int nextc;
                for(int j = 0; j < 4; j++){
                    nextr = shift[j];
                    nextc = shift[j+1];
                    if(cor[0] + nextr >= 0 && cor[0] + nextr <= r-1 && cor[1] + nextc >= 0 && cor[1] + nextc <= c-1 && grid[cor[0] + nextr][cor[1] + nextc] == 0 && !visited[cor[0] + nextr][cor[1] + nextc]){
                        q.add(new int[] {cor[0] + nextr, cor[1] + nextc});
                        visited[cor[0] + nextr][cor[1] + nextc] = true;
                        k[cor[0] + nextr][cor[1] + nextc] = k[cor[0]][cor[1]] + 1;
                        reach[cor[0] + nextr][cor[1] + nextc]++;
                        dis[cor[0] + nextr][cor[1] + nextc] += k[cor[0] + nextr][cor[1] + nextc];
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(reach[i][j] == building && dis[i][j] <= min){
                    
                        min = dis[i][j];
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}