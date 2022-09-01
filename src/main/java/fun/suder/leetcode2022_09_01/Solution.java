package fun.suder.leetcode2022_09_01;

import com.sun.org.apache.xpath.internal.operations.And;

import java.util.Arrays;

class Solution {
    public int[] finalPrices(int[] prices) {
        final int pricesLength = prices.length;
        int[] ans = new int[pricesLength];
        for (int i = 0; i < pricesLength; i++) {
            int discount = 0;
            for (int j = i+1; j < pricesLength; j++) {
                if (prices[i]>=prices[j]){
                    discount = prices[j];
                    break;
                }
            }

            ans[i]=prices[i]-discount;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{10,1,1,6};
        System.out.println(Arrays.toString(new Solution().finalPrices(ints)));
    }
}