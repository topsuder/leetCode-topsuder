package fun.suder.每日一题.leetcode2022_07_04;

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
 * @DATE 2022/7/4-22:04
 * @Description
 * @see fun.suder.每日一题.leetcode2022_07_04 leetCode-topsuder
 */
public class 最小绝对差 {

    public static void main(String[] args) {
        int[] nums = {3,1,24,6,7,78,};
        final List<List<Integer>> lists = minimumAbsDifference(nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        //记录当前最小绝对差
        Integer min = Integer.MAX_VALUE;

        List<List<Integer>> returnList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i==arr.length-1){
                break;
            }
            int thisI =  arr[i];
            int nextI = arr[i+1];
            List<Integer> thisList=  new ArrayList<>();
            thisList.add(thisI);
            thisList.add(nextI);

            if (min>nextI-thisI){
                returnList.clear();
                min = nextI-thisI;
                returnList.add(thisList);
            }else if (min==nextI-thisI){
                returnList.add(thisList);
            }
        }
        return returnList;
    }
}
