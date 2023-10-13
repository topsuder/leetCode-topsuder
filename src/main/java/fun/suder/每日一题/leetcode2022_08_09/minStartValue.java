package fun.suder.每日一题.leetcode2022_08_09;

/**
 * <span>Form File</span>
 * <p>Description</p>
 * <p>Copyright: Copyright (c) 2022 版权</p>
 * <p>Company:QQ 752340543</p>
 *
 * @author topsuder
 * @version v1.0.0
 * @DATE 2022/8/8-16:30
 * @Description
 * @see fun.suder.每日一题.leetcode2022_08_08 leetCode-topsuder
 */
public class minStartValue {
    public static int minStartValues(int[] nums) {
        int sum = 0;
        int base = 0;
        for (int num : nums) {
            sum+=num;
            base=Math.min(base,sum);
        }
        return 1-base;


    }

    public static void main(String[] args) {
        int[] nums = {-5,-2,4,4,-2};
        System.out.println(minStartValues(nums));
    }
}
