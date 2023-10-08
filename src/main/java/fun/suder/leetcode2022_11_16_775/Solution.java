package fun.suder.leetcode2022_11_16_775;

class Solution {
    public boolean isIdealPermutation(int[] nums) {
        //暴力
        //求全局倒置数量
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1 ; j<nums.length;j++){
                if (nums[i]>nums[j]){
                   b++;
                }
            }
            if (nums[i]>nums[i+1]) {
                a++;
            }
        }

        return a==b;
    }
    class Solutiontest {
        public boolean isIdealPermutation(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (Math.abs(nums[i] - i) > 1) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        new Solution().isIdealPermutation(new int[]{0,1,2,3});
    }
}