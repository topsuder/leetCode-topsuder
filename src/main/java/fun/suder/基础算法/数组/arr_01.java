package fun.suder.基础算法.数组;

import java.util.Arrays;

/**
 * <pre>寻找数组的中心索引</pre>
 *
 * <span>Form File</span>
 * <p>Description</p>
 * <p>Copyright: 北京数字医信科技责任有限公司 (c) 2023</p>
 * <p>Company:Wechat 15303997779</p>
 *
 * @author topsuder
 * @version v1.0.0
 * @DATE 2023/10/12-14:59
 * @Description
 * @see fun.suder.基础算法.数组 leetCode-topsuder
 */
public class arr_01 {

    public int pivotIndex(int[] nums) {

        final int allSum = Arrays.stream(nums).sum();

        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {

            int rightSum = allSum - leftSum - nums[i];

            if (leftSum==rightSum) {
                return i;
            }

            leftSum+= nums[i];
        }

        return -1;
    }


    public static void main(String[] args) {
        final arr_01 arr_01 = new arr_01();
        final int i = arr_01.pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
        System.out.println(i);
    }

}
