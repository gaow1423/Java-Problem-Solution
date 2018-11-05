/*
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null)
            return null;
        Map<Integer, Integer> map = new HashMap<> ();
        List<Integer> list = new ArrayList<> ();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i], 1);
            else{
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<> (map.size(), new Comparator<Map.Entry<Integer, Integer>>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b){
                return b.getValue() - a.getValue();
            }
        });
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            pq.add(e);
        }
        while(k > 0){
            Map.Entry<Integer,Integer> w = pq.poll();
            list.add(w.getKey());
            k--;
        }
        return list;
    }
}