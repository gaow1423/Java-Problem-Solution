/*
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.

*/

class Solution {
    public Boolean BFS(Map<Integer, ArrayList<Integer>> map, int src){
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        q.add(src);
        while(!q.isEmpty()){
            list.add(src);
            int num = q.poll();
            List<Integer> l = map.get(num);
            for(int i = 0; i < l.size(); i++){
                if(!list.contains(l.get(i)))
                    q.add(l.get(i));
                else
                    return false;
            }
        }
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<> ();
        for(int i = 0; i < prerequisites.length; i++){
            if(!map.containsKey(prerequisites[i][0])){
                map.put(prerequisites[i][0], new ArrayList<Integer>());
                map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }
            else{
                map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }
        }
        for(int j = 0; j < numCourses; j++){
            if(!BFS(map, j))
                return false;
        }
        return true;
    }
}