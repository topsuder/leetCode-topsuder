package fun.suder.leetcode2022_08_19;

class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        final int length = startTime.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (queryTime>startTime[i]&&queryTime<endTime[i]){
                count++;
            }
        }
        return count;
    }
}