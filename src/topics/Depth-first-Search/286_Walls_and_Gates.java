/*
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

Example: 

Given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
*/

class Solution {
    private static int[] d = {0, 1, 0, -1, 0};
    
    public void dfs(int[][] rooms, int i, int j){
        for(int k = 0; k < 4; k++){
            int p = i + d[k];
            int q = j + d[k+1];
            if(p >= 0 && p < rooms.length && q >= 0 && q < rooms[0].length && rooms[p][q] > rooms[i][j] + 1){
                rooms[p][q] = rooms[i][j] + 1;
                dfs(rooms, p, q);
            }
        }
    }
    
    public void bfs(int[][] rooms, int i, int j){
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<> ();
        queue.add(new int[] {i, j});
        while(!queue.isEmpty()){
            int[] x = queue.poll();
            for(int k = 0; k < 4; k++){
                int p = x[0] + d[k];
                int q = x[1] + d[k+1];
                if(p >= 0 && p < rooms.length && q >= 0 && q < rooms[0].length && rooms[p][q] > rooms[x[0]][x[1]] + 1){
                    rooms[p][q] = rooms[x[0]][x[1]] + 1;
                    queue.add(new int[] {p, q});
                }
            }
        }
    }
    
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++){
            for (int j = 0; j < rooms[0].length; j++){
                if (rooms[i][j] == 0) 
                    bfs(rooms, i, j);
            }
        }
    }
}