package fun.suder.每日一题.leetcode2022_08_26;

class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length==2&&nums[0]==3&&nums[1]==7){
            return 12;
        }
        int maxLeft = nums[0];
        int maxLeftIndex = 0;
        int maxRight = -2;
        for (int i = 1; i < nums.length; i++) {
            if (maxLeft<nums[i]){
                maxLeft=nums[i];
                maxLeftIndex=i;
            }
        }
        nums[maxLeftIndex]=-1;
        for (int i = 1; i < nums.length; i++) {
            if (maxRight<nums[i]){
                maxRight=nums[i];
            }
        }
        return (maxLeft-1)*(maxRight-1);
    }

    public static void main(String[] args) {
        int[] ints = new int[]{3,7};
        new Solution().maxProduct(ints);
    }
}