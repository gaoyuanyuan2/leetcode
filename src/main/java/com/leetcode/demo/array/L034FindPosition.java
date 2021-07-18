package com.leetcode.demo.array;

public class L034FindPosition {
    public static void main(String[] args) {
        new L034FindPosition().searchRange(new int[]{1, 4}, 4);
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int length = nums.length, l = 0, r = length - 1;
        int m = 0;
        while (l <= r && target != nums[m]) {
            m = (r + l) >> 1;
            if (target < nums[m]) {
                r = m - 1;
            } else if (target > nums[m]) {
                l = m + 1;
            }
        }
        if (target == nums[m]) {
            r = m;
            l = m;
            while (l - 1 > 0 && nums[m] == nums[l - 1]) {
                l--;
            }
            while (r + 1 < length && nums[m] == nums[r + 1]) {
                r++;
            }
            return new int[]{l, r};
        }
        return new int[]{-1, -1};
    }
}
