package fun.suder.leetcode2022_09_09;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minOperations(String[] logs) {
        int ans = 0;
        for (String log : logs) {
            if ("../".equals(log)&&ans>0) {
                ans--;
            } else if (!"./".equals(log)&&!"../".equals(log)) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(new String[]{"./","wz4/","../","mj2/","../","../","ik0/","il7/"}));
    }
}