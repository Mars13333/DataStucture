package com.altman29.stacklib.solution_20;

import java.util.Stack;

/**
 * Created by Csy on 2018/11/21.
 * e-mial:chensiyuan@duozhuan.cn
 * Desc: LeetCode-20
 * 使用Java提供的Stack(其实和自定义的一致的)
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> mStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);//查看每次第i个字符
            if (c == '(' || c == '[' || c == '{') {//每次拿到左括号 就push到stack
                mStack.push(c);
            } else {//当前是右括号
                if (mStack.isEmpty()) {//为空 就是没有匹配
                    return false;
                }
                char topChar = mStack.pop();
                if (c == ')' && topChar != '(') {//如果当前c是右小括号，当时当前的topChar不是左侧的小括号就是匹配失败
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == '}' && topChar != '{') {
                    return false;
                }
            }
        }
        return mStack.isEmpty();//此时不为空 就是匹配了。
    }

    public static void main(String[] args) {
        String s = "(){}[](}]()[}";
        String s1 = "(){}[]";

        System.out.println(new Solution().isValid(s));
        System.out.println(new Solution().isValid(s1));

    }
}
