/*
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: 2, [[1,0]] 
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
             course 0. So the correct course order is [0,1] .
Example 2:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
*/

class Solution {
    public static int color;
    public static boolean isFinish = true;
    private static Queue<Integer> q = new LinkedList<>();
    public static void dfs(LinkedList[] G, int v, int[] marked){
        marked[v] = color;
        for(int i = 0; i < G[v].size(); i++){
            if(marked[(int) G[v].get(i)] == color){
                isFinish = false;
                return;
            }
            if(marked[(int) G[v].get(i)] != -1){
                dfs(G, (int) G[v].get(i), marked);
            }
        }
        q.offer(v);
    }
	public static void topological_sort(LinkedList<Integer> G){
			int[] marked = new int[G.length];
			for(int i = 0; i < G.length; i++){
				marked[i] = -1;
			}

			for(int v = 0; v < G.length; v++){
                color = v;
                if(marked != -1)
                    dfs(G, v, marked);
            }
	}

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        LinkedList<Integer> G[] = new LinkedList[numCourses];
        for(int i = 0; i <numCourses; i++){
        	G[i] = new LinkedList();
        }
        for(int j = 0; j < prerequisites.length; j++){
        	G[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        topological_sort(G);
        if(!isFinish)
            return new int[0];
        int[] res = new int[q.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = q.poll();
        }
        return res;
    }
}