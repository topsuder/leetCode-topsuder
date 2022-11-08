package fun.suder.leetcode2022_09_14;

import java.util.Arrays;

class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length, tot = 0;
        for (int i = n / 20; i < n - n / 20; i++) tot += arr[i];
        return tot * 1.0 / (n * 0.9);
    }
}