package fun.suder.leetcode2023_09_11_630;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

class Solution {
    public int scheduleCourse(int[][] courses) {



        // 当前学习课程时长
        int currentDuration = 0;
        // 可以学习的课程数目
        int count = 0;

        // 要学的时间最小，并且结束时间最晚的课程要先学
        // 结束时间-课程时长排序
        final int[][] array = Arrays.stream(courses).sorted((o1, o2) -> {
            // 课程时长
            int duration1 = o1[0];
            // 结束时间
            int lastDay1 = o1[1];

            // 课程时长
            int duration2 = o2[0];
            // 结束时间
            int lastDay2 = o2[1];

            // 课程时长相同，结束时间晚的排在前面
            if (duration1==duration2) {
                return lastDay1-lastDay2;
            }
            // 课程时长短的排在前面
            return duration1-duration2;
        }).toArray(int[][]::new);


        for (int[] cours : array) {
            // 这是所有的课程

            // 课程时长
            int duration = cours[0];
            // 结束时间
            int lastDay = cours[1];

            currentDuration += duration;
            if (currentDuration<=lastDay) {
                count++;
                // 可以学习
            }else {
                currentDuration -= duration;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        final Solution solution = new Solution();
        //[[5,15],[3,19],[6,7],[2,10],[5,16],[8,14],[10,11],[2,19]]
        int[][] courses = {{5,15},{3,19},{6,7},{2,10},{5,16},{8,14},{10,11},{2,19}};
        final int i = solution.scheduleCourse(courses);
        System.out.println(i);
    }
}