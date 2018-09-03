/*
Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

Example 1:

Input: "UD"
Output: true
 

Example 2:

Input: "LL"
Output: false
 
*/
class Solution {
    public boolean judgeCircle(String moves) {
	int [] cur = new int[] {0, 0};
	if(moves == "") return true; 
	for(char c : moves.toCharArray()){
		if(c == 'R')
			cur[0]++;
		else if(c == 'L')
			cur[0]--;
		else if(c == 'U')
			cur[1]++;
		else if(c == 'D')
			cur[1]--;
		else
			return false;
	}
	return cur[0] == 0 && cur[1] == 0;
    }
}
