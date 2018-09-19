/*
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        int len = intervals.size();
        int[] begin = new int[len];
        int[] end = new int[len];
        for(int i = 0; i < len; i++){
            begin[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(begin);
        Arrays.sort(end);
        List<Interval> res = new ArrayList<> ();
        for(int i = 0, j = 0; i < len; i++){//i is the start point, j is the end point.
            if(begin[i+1] > end[i] || i == len - 1){
                res.add(new Interval(begin[j], end[i]));
                j = i + 1;
            }
        }
        return res;
    }
}