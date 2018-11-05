/*
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:

Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.
*/

class Solution {
    public String reverseWords(String s) {
        char[] ca = s.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] != ' ') {   // when i is a non-space
                int j = i;
                while (j + 1 < ca.length && ca[j + 1] != ' ') { j++; } // move j to the end of the word
                reverse(ca, i, j);
                i = j;
            }
        }
        return new String(ca);
    }

    private void reverse(char[] ca, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = ca[i];
            ca[i] = ca[j];
            ca[j] = tmp;
        }
    }
}

class Solution {
    public String reverseWords(String s) {
        int start = 0;
        int end = s.length();
        
        char[] result = s.toCharArray();
        while (start < end) {
            int next = findNext(start, result);
            reverse(start, next, result);
            start = next + 2;
        }
        return String.valueOf(result);
    }
    
    private int findNext(int start, char[] arr) {
        for (int i = start; i < arr.length; i ++) {
            if (arr[i] == ' ') {
                return i - 1;
            } else if (i == arr.length - 1) {
                return i;
            }
        }
        return -1;
    }
    
    private void reverse(int start, int end, char[] arr) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            
            start ++;
            end --;
        }
    }
}