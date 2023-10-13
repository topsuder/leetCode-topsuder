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

        int n = matrix.length;
        int[][] matrix_new = new int[n][n];
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

}
