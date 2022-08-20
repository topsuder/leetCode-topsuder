package fun.suder.leetcode2022_07_22;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <span>Form File</span>
 * <p>Description</p>
 * <p>Copyright: Copyright (c) 2022 版权</p>
 * <p>Company:QQ 752340543</p>
 *
 * @author topsuder
 * @version v1.0.0
 * @DATE 2022/7/22-11:40
 * @Description
 * @see fun.suder.leetcode2022_07_22 leetCode-topsuder
 */
public class Solution {

    private ReentrantLock reentrantLock;

    public int intersectionSizeTwo(int[][] intervals) {
//定义有交集的数的数组
        Set num = new HashSet();
        for (int i = 0; i < intervals.length-1; i++) {
            //记录左节点
            final int lefti = intervals[i][0];
            //记录右节点
            final int righti = intervals[i][1];
            for (int j = i+1; j < intervals.length-1; j++) {
                //记录左节点
                final int leftj = intervals[j][0];
                //记录右节点
                final int rightj = intervals[j][1];
                //获取lefti和righti区间间内所有整数组成的数组
                int[] numi = getArray(lefti, righti);
                //获取leftj和rightj区间间内所有整数组成的数组
                int[] numsj = getArray(leftj, rightj);


                //判断两个数组是否有交集
                isIntersect(num,numi, numsj);
            }
        }

        return num.size();
    }

    private Set isIntersect(Set num,int[] numi, int[] numsj) {
        for (int j : numi) {
            for (int k : numsj) {
                if (j == k) {
                    num.add(j);
                }
            }
        }
        return num;
    }

    private int[] getArray(int lefti, int righti) {
        int[] numi = new int[righti-lefti+1];
        for (int i = lefti; i <= righti; i++) {
            numi[i-lefti] = i;
        }
        return numi;
    }

    public static void main(String[] args) {
        final Solution solution = new Solution();
        int[][] intervals = {{1, 3}, {1, 4}, {2, 5}, {3, 5}};
        System.out.println(solution.intersectionSizeTwo(intervals));
    }
}
