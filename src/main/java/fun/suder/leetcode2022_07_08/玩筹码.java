package fun.suder.leetcode2022_07_08;

/**
 * <span>Form File</span>
 * <p>Description</p>
 * <p>Copyright: Copyright (c) 2022 版权</p>
 * <p>Company:QQ 752340543</p>
 *
 * @author topsuder
 * @version v1.0.0
 * @DATE 2022/7/8-09:07
 * @Description
 * @see fun.suder.leetcode2022_07_08 leetCode-topsuder
 */
public class 玩筹码 {
    public int minCostToMoveChips(int[] position) {
        int[] cnt = new int[2];
        for (int pos : position) {
            if (pos % 2 == 0) {
                cnt[0]++;
            } else {
                cnt[1]++;
            }
        }
        return Math.min(cnt[0], cnt[1]);

    }
}
