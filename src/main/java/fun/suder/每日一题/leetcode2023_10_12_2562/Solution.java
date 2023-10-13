package fun.suder.每日一题.leetcode2023_10_12_2562;

class Solution {
    public long findTheArrayConcVal(int[] nums) {

        long sum = 0;

        for (int i = 0, j = nums.length - 1; i <= j; i++, j--) {
            if (i == j) {
                sum += nums[i];
                break;
            }
            sum += Long.parseLong(nums[i] + String.valueOf(nums[j]));
        }

        return sum;


    }

}