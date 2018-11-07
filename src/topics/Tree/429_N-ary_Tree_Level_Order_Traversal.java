/*
Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example, given a 3-ary tree:

 



 

We should return its level order traversal:

[
     [1],
     [3,2,4],
     [5,6]
]

*/
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        if(root == null)
            return res;
        Queue<Node> q = new LinkedList<Node> ();
        
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> list = new ArrayList<> ();
            int count = q.size();
            for(int i = 0; i < count; i++){
                Node node = q.poll();
                list.add(node.val);
                for(Node k : node.children){
                    q.add(k);
                }
            }
            res.add(list);
        }
        return res;
    }
}