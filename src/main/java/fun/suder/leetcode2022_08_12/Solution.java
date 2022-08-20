package fun.suder.leetcode2022_08_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> list = map.getOrDefault(groupSizes[i], new ArrayList<>());
            list.add(i);
            map.put(groupSizes[i], list);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int k : map.keySet()) {
            List<Integer> list = map.get(k), cur = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                cur.add(list.get(i));
                if (cur.size() == k) {
                    ans.add(cur);
                    cur = new ArrayList<>();
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.groupThePeople(new int[]{3,3,3,3,3,1,3}));
    }
}