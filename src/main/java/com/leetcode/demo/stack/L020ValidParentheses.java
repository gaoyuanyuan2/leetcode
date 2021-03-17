package com.leetcode.demo.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class L020ValidParentheses {

    public boolean isValid(String s) {
        if(s == null){
            return false;
        }
        int length = s.length();
        if(length==0 || length%2 == 1){
            return false;
        }
        HashMap<Character,Character> charMap = new HashMap<>();
        charMap.put('}','{');
        charMap.put(']','[');
        charMap.put(')','(');
        Deque<Character> deque = new LinkedList<>();
        int i = 0;
        while(i<length){
            if(charMap.containsKey(s.charAt(i))){
                Character tem  = deque.peek();
                if(tem==null){
                    return false;
                }
                if(charMap.get(s.charAt(i))!=tem){
                    return false;
                }
                deque.pop();
            }else{
                deque.push(s.charAt(i));
            }
            i++;
        }
        if(deque.isEmpty()){
            return true;
        }
        return false;

    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        // Iterate through string until empty
        for(int i = 0; i<s.length(); i++) {
            // Push any open parentheses onto stack
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
                // Check stack for corresponding closing parentheses, false if not valid
            else if(s.charAt(i) == ')' && !stack.empty() && stack.peek() == '(')
                stack.pop();
            else if(s.charAt(i) == ']' && !stack.empty() && stack.peek() == '[')
                stack.pop();
            else if(s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{')
                stack.pop();
            else
                return false;
        }
        // return true if no open parentheses left in stack
        return stack.empty();
    }
}
