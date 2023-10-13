package fun.suder.基础算法.二维数组;

/**
 * <pre>旋转矩阵</pre>
 *
 * <span>Form File</span>
 * <p>Description</p>
 * <p>Copyright: 北京数字医信科技责任有限公司 (c) 2023</p>
 * <p>Company:Wechat 15303997779</p>
 *
 * @author topsuder
 * @version v1.0.0
 * @DATE 2023/10/12-16:54
 * @Description
 * @see fun.suder.基础算法.二维数组 leetCode-topsuder
 */
public class DimensionArr_01 {

    public void rotate(int[][] matrix) {



        // 设想：
        // 旋转90度的方程是？
        // x= y
        // y = matrix.length - 1 - x

        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {

                    int temp = matrix[y][x];

                    int tempX = y;
                    int tempY = matrix.length - 1 - x;

                    matrix[y][x] = matrix[tempY][tempX];

                    matrix[tempY][tempX] = temp;
            }
        }
    }

}
