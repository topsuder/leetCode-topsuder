package fun.suder.leetcode2022_09_19;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> indexes = new HashMap<>();
        for (int num : nums) {
            if (indexes.containsKey(num)) {
                indexes.put(num, indexes.get(num)+1);
            }else {
                indexes.put(num,1);
            }
        }
        int[] ans=new int[nums.length];
        int i=0;
        final List<Map.Entry<Integer, Integer>> collect = indexes.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
        for (Map.Entry<Integer, Integer> integerIntegerEntry : collect) {
            for (Integer integer = 0; integer < integerIntegerEntry.getValue(); integer++) {
                ans[i]=integerIntegerEntry.getKey();
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().frequencySort(new int[]{1, 1, 2, 2, 2, 3})));

    }
}