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
    	final int[] shift = new int[] {0, 1, 0, -1, 0};
    	if(grid == null || grid[0].length == 0)
    		return 0;
    	int count = 0;
    	List<int[]> building = new ArrayList<> ();
    	for(int i = 0; i < r; i++){
    		for(int j = 0; j < c; j++){
    			if(grid[i][j] == 0)
    				list.add(new int[] {i, j}); //the cordinate of building in the map.
    		}
    	}

    	for(int i = 0; i < r; i++){
    		for(int j = 0; j < c; j++){
    			if(grid[i][j] == 0){
    				Queue<int[]> q = new LinkedList<int []>();
    				q.add(new int[] {i, j});
    					while(!q.isEmpty()){
    						int qsize = q.size();
    						for(int k = 0; k < qsize; k++){
    							
    						}
    						if(list.isEmpty())
    							break;
    					}
    			}
    		}
    	}

    	// boolean visited[][] = new boolean visited[r][c];
    	// Queue<int[]> q = new LinkedList<int[]> ();

    }
}