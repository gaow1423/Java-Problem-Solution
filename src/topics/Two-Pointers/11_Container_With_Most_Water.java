/*
   Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
 */
class Solution {
	public int maxArea(int[] height) {
		int L = height.length, lo = 0, hi = L -1;
		if(L<2) return 0;
		int max = 0;
		while(lo<hi){
			int loMax = height[lo], hiMax = height[hi];
			int candidate = (hi-lo) * (loMax<hiMax ? loMax : hiMax);
			max = candidate > max ? candidate : max;
			if(height[lo]<=height[hi])
				while(lo<L-1 && height[lo]<=loMax) ++lo; 
			else
				while(hi>0 && height[hi]<=hiMax) --hi;
		}
		return max;
	}
}
//Note: This problem is two pointers problem. One pointer begins at leftmost position, and another pointer begins at rightmost position. if low < high, then size = height(low)*(high - low). In this case, increase low will reduce the size. Instead, we should decrease high. The same method, when low > high, then increase low. Meanwhile, the maximum value should be tracked, and local high and local low should be also tracked.
