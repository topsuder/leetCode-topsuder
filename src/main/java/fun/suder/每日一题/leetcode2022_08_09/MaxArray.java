package fun.suder.每日一题.leetcode2022_08_09;/**
 * <span>Form File</span>
 * <p>Description</p>
 * <p>Copyright: Copyright (c) 2022 版权</p>
 * <p>Company:QQ 752340543</p>
 *
 * @author topsuder
 * @version v1.0.0
 * @DATE 2022/8/9-11:15
 * @Description
 * @see fun.suder.每日一题.leetcode2022_08_09 leetCode-topsuder
 */
public class MaxArray {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int ans = 0;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                ans=mid;
                right = mid;
            }
        }
        System.gc();
        return ans;
    }
}
