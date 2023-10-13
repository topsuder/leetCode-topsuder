package fun.suder.每日一题.leetcode2022_11_23_1742;

import java.util.Arrays;

class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int[] ans = new int[lowLimit+highLimit];
        int n = highLimit - lowLimit + 1;
        for (int i = 0; i < n; i++) {
            int index=  0;
            final char[] chars = String.valueOf(i + lowLimit).toCharArray();
            for (int j = 0; j < chars.length; j++) {
                index+= chars[j] - '0';
            }
            ans[--index]++;
        }
        return Arrays.stream(ans).max().getAsInt();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        final int i = solution.countBalls(4, 7);
        System.out.println(i);
    }
}