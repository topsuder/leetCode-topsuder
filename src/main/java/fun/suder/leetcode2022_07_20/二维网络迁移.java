package fun.suder.leetcode2022_07_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <span>Form File</span>
 * <p>Description</p>
 * <p>Copyright: Copyright (c) 2022 版权</p>
 * <p>Company:QQ 752340543</p>
 *
 * @author topsuder
 * @version v1.0.0
 * @DATE 2022/7/20-09:04
 * @Description
 * @see fun.suder.leetcode2022_07_20 leetCode-topsuder
 */
public class 二维网络迁移 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n =grid[0].length;
        List<Integer> arrayList = new ArrayList<>();
        for (int[] ints : grid) {
            for (int anInt : ints) {
                arrayList.add(anInt);
            }
        }



        for (int i = 0; i < k; i++) {
            int last = arrayList.get(arrayList.size()-1);
            arrayList.remove(arrayList.size()-1);
            arrayList.add(0,last);
        }


        List<List<Integer>> returnList = new ArrayList<>();
        int forSize = arrayList.size() / n;
        while (forSize>0){
            List<Integer> thisList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                thisList.add(arrayList.get(i));
            }
            returnList.add(thisList);
            forSize--;
        }
        for (int i = 0; i < m; i++) {
            List<Integer> thisList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                thisList.add(arrayList.get(i*n+j));
            }
            returnList.add(thisList);
        }

        return returnList;
    }

    public static void main(String[] args) {
        二维网络迁移 myCalendar = new 二维网络迁移();
        System.out.println(myCalendar.shiftGrid(new int[][]{{1,2,3},{4,5,6},{7,8,9}},1));
    }
}
