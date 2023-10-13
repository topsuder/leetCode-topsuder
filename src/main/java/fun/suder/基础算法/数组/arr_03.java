package fun.suder.基础算法.数组;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <pre>合并区间</pre>
 *
 * <span>Form File</span>
 * <p>Description</p>
 * <p>Copyright: 北京数字医信科技责任有限公司 (c) 2023</p>
 * <p>Company:Wechat 15303997779</p>
 *
 * @author topsuder
 * @version v1.0.0
 * @DATE 2023/10/12-15:24
 * @Description
 * @see fun.suder.基础算法.数组 leetCode-topsuder
 */
public class arr_03 {

    public static void main(String[] args) {
        //[[1,4],[0,1]]
        final arr_03 arr_03 = new arr_03();
        final int[][] merge = arr_03.merge(new int[][]{{1, 4}, {0, 0}});
        System.out.println(Arrays.deepToString(merge));
    }

    public int[][] merge(int[][] intervals) {

        int[][] tempRes = new int[intervals.length][2];


        // 按照区间起始位置排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int mergeIndex = 0;
        tempRes[mergeIndex] = intervals[0];
        for (int[] interval : intervals) {
            if (interval[0] <= tempRes[mergeIndex][1]) {
                if (interval[1] <= tempRes[mergeIndex][1]) {
                    continue;
                }
                tempRes[mergeIndex][1] = interval[1];

                if (tempRes[mergeIndex][0] > interval[0]) {
                    tempRes[mergeIndex][0] = interval[0];
                }


            } else {
                mergeIndex++;
                tempRes[mergeIndex] = interval;
            }
        }

        int emptySize = 0;

        for (int i = tempRes.length - 1; i >= 0; i--) {
            if (Arrays.equals(tempRes[i], new int[2])) {
                emptySize++;
            } else {
                break;
            }
        }

        final int[][] res = new int[intervals.length - emptySize][2];

        if (intervals.length - emptySize >= 0) System.arraycopy(tempRes, 0, res, 0, intervals.length - emptySize);

        return res;

    }


}
