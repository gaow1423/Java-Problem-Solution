/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
*/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int level = 0; 
        Queue<String> queue = new LinkedList<String> ();
        Set<String> visited = new HashSet<String> ();
        
        for(String s : wordList){
        	visited.add(s);
        }

        queue.add(beginWord);
        level++;
        queue.add(null);
        while(!queue.isEmpty()){
        	String qitem = queue.poll();
        	if(qitem != null){
        		if(quitem.equals(endWord))
        			return level;
        		visited.remove(qitem);
        		for(int i =0; i < qitem.length(); i++){
                    char[] cr = qitem.toCharArray();
                    for(char c = 'a' ; c <= 'z'; c++){
                        cr[i] = c;
                        
                        String str = new String(cr);
                                                                      
                        if(visited.contains(str)){    
                            queue.add(str);
                        }
                        
                    }
                }
        	} else{
                level++;
                if(!queue.isEmpty()) queue.add(null);
            }  
        }
        return 0;
    }
}