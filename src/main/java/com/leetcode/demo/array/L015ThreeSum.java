package com.leetcode.demo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L015ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && (nums[i] == nums[i - 1])) continue; // avoid duplicates
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while ((j < k) && (nums[j] == nums[j - 1]))
                        j++;// avoid duplicates
                    while ((j < k) && (nums[k] == nums[k + 1]))
                        k--;// avoid duplicates
                } else if (nums[i] + nums[j] + nums[k] > 0) k--;
                else j++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        new L015ThreeSum().myThreeSum(new int[]{-1,0,1,2,-1,-4});
    }
    public List<List<Integer>> myThreeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return resList;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int now = -nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (now == sum) {
                    resList.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[i] == nums[++l]) ;
                    while (l < r && nums[r] == nums[--r]) ;
                } else if (now > sum) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return resList;
    }
}