package fun.suder.每日一题.leetcode2022_09_08;

import java.util.Arrays;

class Solution {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int kUp = k + 1;
        int numTemp = 1;
        //下标段[0, k]中，偶数下标填充[1,2,3..]
        for (int i = 0; i <= k; i += 2){
            ans[i] = numTemp++;
        }
        //下标段[0, k]中，奇数下标填充[k + 1, k, k - 1...]
        for (int i = 1; i <= k; i += 2){
            ans[i] = kUp--;
        }
        //下标段[k + 1, n - 1]都是顺序填充
        for (int i = k + 1; i < n; ++i) {
            ans[i] = i + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().constructArray(3, 2)));
    }
}