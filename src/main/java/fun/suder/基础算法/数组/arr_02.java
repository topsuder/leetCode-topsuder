package fun.suder.基础算法.数组;

/**
 * <pre>搜索插入位置</pre>
 *
 * <span>Form File</span>
 * <p>Description</p>
 * <p>Copyright: 北京数字医信科技责任有限公司 (c) 2023</p>
 * <p>Company:Wechat 15303997779</p>
 *
 * @author topsuder
 * @version v1.0.0
 * @DATE 2023/10/12-15:07
 * @Description
 * @see fun.suder.基础算法.数组 leetCode-topsuder
 */
public class arr_02 {


    /**
     * 方法注释: <br>
     * 〈暴力〉
     *
     * @return int
     * @param    nums
     * @param    target
     * @author topsuder 🪖🇨🇳
     * @date 2023/10/12 15:15
     */
    public int searchInsertbl(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }

        return nums.length;

    }

    /**
     * 方法注释: <br>
     * 〈二分〉
     *
     * @return int
     * @param    nums
     * @param    target
     * @author topsuder 🪖🇨🇳
     * @date 2023/10/12 15:24
     */
    public int searchInsert(int[] nums, int target) {

        int left = 0;

        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }

        }

        return left;

    }


}
