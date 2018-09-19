/*
Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list. Your method will be called repeatedly many times with different parameters. 

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1
*/

class WordDistance {
Map<String, List<Integer>> map = new HashMap<String, List<Integer>> ();
    public WordDistance(String[] words) {
        for(int i = 0; i < words.length; i++){
        	if(!map.containsKey(words[i])){
        		map.put(words[i], new ArrayList<Integer>());
        		map.get(words[i]).add(i);
        	}
        	else{
        		map.get(words[i]).add(i);
        	}
        }
    }
    
    public int shortest(String word1, String word2) {
    	List<Integer> l_1 = map.get(word1);
    	List<Integer> l_2 = map.get(word2);
    	int res = Integer.MAX_VALUE;
    	int i = 0;
    	int j = 0;
    	while(i < l_1.size() && j < l_2.size()){
    		res = Math.min(res, Math.abs(l_1.get(i) - l_2.get(j)));
    		if(l_1.get(i) < l_2.get(j))
    			i++;
    		else
    			j++;
    	}
    	return res;
    }
}

