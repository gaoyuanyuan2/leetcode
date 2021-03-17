package com.leetcode.demo.stack;

import java.util.Stack;

public class L084LargestRectangleInHistogram {

    public int largestRectangleArea(int[] h) {
        int n = h.length, i = 0, max = 0;

        Stack<Integer> s = new Stack<>();

        while (i < n) {
            // as long as the current bar is shorter than the last one in the
            //stack
            // we keep popping out the stack and calculate the area based on
            // the popped bar
            while (!s.isEmpty() && h[i] < h[s.peek()]) {
                // tricky part is how to handle the index of the left bound
                max = Math.max(max, h[s.pop()] * (i - (s.isEmpty() ? 0 :
                        s.peek() + 1)));
            }
            // put current bar's index to the stack
            s.push(i++);
        }

        // finally pop out any bar left in the stack and calculate the area
        //based on it
        while (!s.isEmpty()) {
            max = Math.max(max, h[s.pop()] * (n - (s.isEmpty() ? 0 :
                    s.peek() + 1)));
        }

        return max;
    }

    public static int largestRectangleArea2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] lessFromLeft = new int[height.length]; // idx of the first bar
        // the left that is lower than current
        int[] lessFromRight = new int[height.length]; // idx of the first bar
        // the right that is lower than current
        lessFromRight[height.length - 1] = height.length;
        lessFromLeft[0] = -1;

        for (int i = 1; i < height.length; i++) {
            int p = i - 1;

            while (p >= 0 && height[p] >= height[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }

        for (int i = height.length - 2; i >= 0; i--) {
            int p = i + 1;

            while (p < height.length && height[p] >= height[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            maxArea = Math.max(maxArea,
                    height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }

        return maxArea;
    }
}
