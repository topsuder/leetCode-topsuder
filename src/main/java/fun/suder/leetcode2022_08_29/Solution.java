package fun.suder.leetcode2022_08_29;

import java.util.Arrays;

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];


        for (int i = 0, j = 0; i < n; i++) {
            ans[j] = nums[i];
            ans[j+1] = nums[i+n];
            j+=2;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));
    }
}