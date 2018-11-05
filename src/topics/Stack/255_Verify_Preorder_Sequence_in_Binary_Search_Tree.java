/*
Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

You may assume each number in the sequence is unique.

Consider the following binary search tree: 

     5
    / \
   2   6
  / \
 1   3
Example 1:

Input: [5,2,6,1,3]
Output: false
Example 2:

Input: [5,2,1,3,6]
Output: true
Follow up:
Could you do it using only constant space complexity?
*/

class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int min = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack();
        for(int i : preorder){
            if(i < min)
                return false;
            while(!stack.isEmpty() && i > stack.peek())
                min = stack.pop();
            stack.push(i);
        }
        return true;
    }
}

