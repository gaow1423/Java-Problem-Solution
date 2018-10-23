/*
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5

*/
class Solution {
    public int calculate(String s) {
        // s.replaceAll(" ", "");
        int len = s.length();
        Stack<Integer> stack = new Stack<> ();
        char sign = '+';
        int num = 0;
        for(int i = 0; i < len; i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10 + s.charAt(i) - '0';
            }
            if(!Character.isDigit(s.charAt(i)) && s.charAt(i)!=' ' || i == len - 1)
            {
                if(sign == '+'){
                    stack.push(num);
                }
                if(sign == '-'){
                    stack.push(-num);
                }
                if(sign == '*'){
                    stack.push(stack.pop() * num);
                }
                if(sign == '/'){
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
        int res = 0;
        for(int i : stack){
            res += i;
        }
        return res;
    }
}