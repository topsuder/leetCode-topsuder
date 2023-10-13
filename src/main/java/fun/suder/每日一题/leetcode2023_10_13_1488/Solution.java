package fun.suder.每日一题.leetcode2023_10_13_1488;

import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {

        // 晴天
        TreeSet<Integer> sunnyDay = new TreeSet<>();

        // 雨天
        Map<Integer, Integer> rainyDay = new HashMap<>();


        int[] res = new int[rains.length];

        for (int i = 0; i < rains.length; i++) {
            if (rains[i] > 0) {
                if (rainyDay.containsKey(rains[i])) {

                    final Integer first = sunnyDay.ceiling(rainyDay.get(rains[i]));
                    if (first !=null && first > rainyDay.get(rains[i])) {
                        res[first] = rains[i];
                        rainyDay.put(rains[i], i);
                        sunnyDay.remove(first);
                    } else {
                        return new int[0];
                    }

                }

                res[i] = -1;
                rainyDay.put(rains[i], i);


            }
            if (rains[i] == 0) {
                sunnyDay.add(i);
            }




        }


        final Iterator<Integer> iterator = sunnyDay.iterator();
        while (iterator.hasNext()) {
            final Integer next = iterator.next();
            res[next] = 1;
        }

        return res;

    }

    public static void main(String[] args) {

        //[1,2,0,0,2,1]
        System.out.println(Arrays.toString(new Solution().avoidFlood(new int[]{1,0,2,3,0,1,2})));

    }

}