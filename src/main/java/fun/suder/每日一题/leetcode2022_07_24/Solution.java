package fun.suder.每日一题.leetcode2022_07_24;

/**
 * <span>Form File</span>
 * <p>Description</p>
 * <p>Copyright: Copyright (c) 2022 版权</p>
 * <p>Company:QQ 752340543</p>
 *
 * @author topsuder
 * @version v1.0.0
 * @DATE 2022/7/24-12:30
 * @Description
 * @see fun.suder.每日一题.leetcode2022_07_24 leetCode-topsuder
 */
public class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {

        if (start>destination){
            int temp  = start;
            start=destination;
            destination=temp;
        }

        int flag = 0;
        int a =0 ;
        int b =0 ;

        for (int i = 0; i < distance.length; i++) {
            if (i>=start&&i<destination){
                b+=distance[i];
            }else {
                flag=1;
                a+=distance[i];
            }
        }

        return flag==1?Math.min(a, b):b;
    }

    public static void main(String[] args) {
        Solution myCalendar = new Solution();
        int[] distance = {1,2,3,4};
        int start = 0;
        int destination = 1;
        System.out.println(myCalendar.distanceBetweenBusStops(distance, start, destination));
    }
}
