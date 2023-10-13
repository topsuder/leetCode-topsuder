package fun.suder.每日一题.leetcode2022_07_12;

/**
 * <span>Form File</span>
 * <p>Description</p>
 * <p>Copyright: Copyright (c) 2022 版权</p>
 * <p>Company:QQ 752340543</p>
 *
 * @author topsuder
 * @version v1.0.0
 * @DATE 2022/7/12-22:03
 * @Description
 * @see fun.suder.每日一题.leetcode2022_07_12 leetCode-topsuder
 */
public class 奇数值单元格的数目 {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] grid = new int[m][n];
        for (int[] index : indices) {
            final int index1 = index[0];
            final int index2 = index[1];
            for (int i = 0; i < grid.length; i++) {
                if (i==index1) {
                    for (int j = 0; j < grid[i].length; j++) {
                        grid[i][j]++;
                    }
                }
            }
            for (int[] ints : grid) {
                //获取到当前ints下标
                ints[index2]++;
            }
        }
        int count = 0;
        for (int[] ints : grid) {
            for (int anInt : ints) {
                //如果为奇数则+1
                if (anInt%2==1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        奇数值单元格的数目 myCalendar = new 奇数值单元格的数目();
        System.out.println(myCalendar.oddCells(2,3,new int[][]{{0,1},{1,1}}));
    }
}
