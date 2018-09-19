/*
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “makes”, word2 = “coding”
Output: 1
Input: word1 = "makes", word2 = "makes"
Output: 3
Note:
You may assume word1 and word2 are both in the list.
*/

class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
    	int minDist = Integer.MAX_VALUE;
    	int i = 0, j = 0;
    	while(i < words.length && j < words.length){
    		if(!word1.equals(words[i])){
    			i++;
    			continue;
    		}
    		if(!word2.equals(words[j])){
    			j++;
    			continue;
    		}
    		if (i == j) i++;
    		else{
    			minDist = Math.min(minDist, Math.abs(i - j));
    			if(i < j) i++;
    			else j++;
    		}
    	}
    	return minDist;
    }
}