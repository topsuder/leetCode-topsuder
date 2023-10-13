package fun.suder.每日一题.leetcode2022_08_09;

import java.util.Arrays;

class Solution {
    private int indexFlag = 0;
    private boolean value = true;
    public int searchInsert(int[] nums, int target) {
        if (value){
            //如果为偶数

            indexFlag = nums.length/2;
            value=false;
        }

        int mid;
        if (nums.length%2==0) {
            mid = nums.length/2-1;
        }else {
            mid = nums.length/2;
        }
        if (mid == 0) {
            return indexFlag;
        }
        if (nums[mid]==target) {
            return mid;
        }else {
            if (nums[mid]>target) {
                indexFlag--;
                return searchInsert(Arrays.copyOfRange(nums, 0, mid), target);
            }else {
                indexFlag++;
                return searchInsert(Arrays.copyOfRange(nums, mid, nums.length), target);
            }
        }


    }

    public static void main(String[] args) {
        Solution myCalendar = new Solution();
        int[] nums = {1,3,5,6};
        System.out.println(myCalendar.searchInsert(nums, 5));
    }
}