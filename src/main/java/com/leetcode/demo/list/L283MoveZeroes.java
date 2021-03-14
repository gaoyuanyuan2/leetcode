package com.leetcode.demo.list;

import java.util.Arrays;

public class L283MoveZeroes {
    public static void main(String[] args) {
        L283MoveZeroes l283MoveZeroes = new L283MoveZeroes();
        int[] array = {0, 1, 0, 3, 12};
        l283MoveZeroes.moveZeroes2(array);
        System.out.println(Arrays.toString(array));
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int insertPos = 0;
        // 不等于0，就覆盖前面只
        for (int num : nums) {
            if (num != 0) nums[insertPos++] = num;
        }
        // 后面之设置为0
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {
        if (nums == null) {
            return;
        }
        int j = 0;
        int tem = 0;
        for (int i = 0; i < nums.length; i++) {
            // 不等于交换位置
            if (nums[i] != 0) {
                tem = nums[i];
                nums[i] = nums[j];
                nums[j] = tem;
                j++;
            }
        }
    }
}
