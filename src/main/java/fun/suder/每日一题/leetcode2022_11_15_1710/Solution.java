package fun.suder.每日一题.leetcode2022_11_15_1710;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int ans = 0;
        for (int[] ints : Arrays.stream(boxTypes).sorted(Comparator.comparing(data -> -data[1])).collect(Collectors.toList())) {
            if (truckSize==0){
                break;
            }

            if (truckSize>=ints[0]) {

                ans+=ints[0]*ints[1];
                truckSize-=ints[0];
            }else {
                ans+=truckSize*ints[1];
                truckSize=0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumUnits(new int[][]{{1,3},{2,2},{3,1}},4));
    }
}