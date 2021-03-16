package com.leetcode.demo.array;

public class L066PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            // 小于9直接加1,返回
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // 进位后赋值为0
            digits[i] = 0;
        }
        // 每位都进位,长度加1,首位赋值为1
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }
}
