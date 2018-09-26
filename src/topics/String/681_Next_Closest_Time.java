/*
Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.

You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.

Example 1:

Input: "19:34"
Output: "19:39"
Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  It is not 19:33, because this occurs 23 hours and 59 minutes later.
Example 2:

Input: "23:59"
Output: "22:22"
Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.

*/

class Solution {
    public String nextClosestTime(String time) {
    	char[] str = new char[4];
    	str[0] = time.charAt(0);
    	str[1] = time.charAt(1);
    	str[2] = time.charAt(3);
    	str[3] = time.charAt(4);

    	if(minMinute(time.substring(3), str, 0) != null)
    		return time.substring(0, 3) + minMinute(time.substring(3), str, 0);
    	else{
    		if(minMinute(time.substring(0, 2), str, 1) != null && minMinute("00", str, 0) != null)
    			return minMinute(time.substring(0, 2), str, 1) + ":" + minMinute("00", str, 0);
    		else{
    			return minMinute("00", str, 1) + ":" + minMinute("00", str, 0);
    		}
    	}
        
    }
    public String minMinute(String minh, char[] str, int mode){
    	Arrays.sort(str);
    	int m = str.length;
    	int n = str.length;
    	for(int i = 0; i < str.length; i++){
    		if(str[i] >= minh.charAt(0) && m == str.length){
    			m = i;
    		}
    		else if(str[i] >= minh.charAt(1) && n == str.length){
    			n = i;
    		}
    	}
    	if(m == str.length || n == str.length){
    		return null;
    	}
    	else if(mode == 1 && (str[m] - '0') > 2 || ((str[m] - '0') == 2 && (str[n] - '0') > 3))
    		return null;
    	else
    		return str[m] == 0 ? ("0"+Integer.toString(str[n] - '0')) : Integer.toString((str[m] - '0')*10 + str[n] - '0');
    }
}

Concise method:

class Solution {
        public String nextClosestTime(String time) {
        int h = Integer.parseInt(time.substring(0, 2));
        int m = Integer.parseInt(time.substring(3));
        for (int t=60*h+m+1; ; t++) {
            String s = String.format("%02d:%02d", t / 60 % 24, t % 60);
            if (s.matches("[" + time + "]*"))
                return s;
        }
    }
}