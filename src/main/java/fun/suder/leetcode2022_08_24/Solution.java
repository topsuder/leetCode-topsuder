package fun.suder.leetcode2022_08_24;

import java.util.Arrays;

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        return Arrays.equals(Arrays.stream(target).sorted().toArray(), Arrays.stream(arr).sorted().toArray());
    }
}