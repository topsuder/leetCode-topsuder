package fun.suder.每日一题.leetcode2022_07_10;

/**
 * <span>Form File</span>
 * <p>Description</p>
 * <p>Copyright: Copyright (c) 2022 版权</p>
 * <p>Company:QQ 752340543</p>
 *
 * @author topsuder
 * @version v1.0.0
 * @DATE 2022/7/10-14:47
 * @Description
 * @see fun.suder.每日一题.leetcode2022_07_10 leetCode-topsuder
 */
public class 摘樱桃 {
    public int cherryPickup(int[][] grid) {
        //定义樱桃数量
        int cherry = 0;


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    cherry++;
                    grid[i][j]= 0;
                } else if (grid[i][j] == -1) {
                    break;
                }
            }
        }
        return cherry;
    }

    public static void main(String[] args) {
        //定义一个值为[[0, 1, -1],
        // [1, 0, -1],
        // [1, 1,  1]]的二维数组
        int[][] grid = {{0, -1, 1},
                {1, -1, 0},
                {1, 1,  1}};

        摘樱桃 myCalendar = new 摘樱桃();
        System.out.println(myCalendar.cherryPickup(grid));

    }
}
