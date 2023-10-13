package fun.suder.每日一题.leetcode2022_07_19;

import java.util.ArrayList;
import java.util.List;

/**
 * <span>Form File</span>
 * <p>Description</p>
 * <p>Copyright: Copyright (c) 2022 版权</p>
 * <p>Company:QQ 752340543</p>
 *
 * @author topsuder
 * @version v1.0.0
 * @DATE 2022/7/19-21:15
 * @Description
 * @see fun.suder.每日一题.leetcode2022_07_19 leetCode-topsuder
 */
public class MyCalendarTwo {
    private final List<int[]> list;
    private int sp;
    public MyCalendarTwo() {
        list=new ArrayList<>();
        sp=0;
    }

    public boolean book(int start, int end) {
        //添加到列表当中
        if (list!=null&&list.size()>0){
            for (int[] ints : list) {
                //判断交集
                //判断两个时间段是否有并集
                if (!(start>ints[1]||end<ints[0])){
                    if (sp<1){

                        sp++;
                        list.add(new int[]{start,end});
                        return true;
                    }else {
                        return false;
                    }
                }else {
                    list.add(new int[]{start,end});
                    return true;
                }
            }
        }
        list.add(new int[]{start,end});
        return true;
    }

    public static void main(String[] args) {

        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        System.out.println(myCalendarTwo.book(10,20));
        System.out.println(myCalendarTwo.book(50,60));
        System.out.println(myCalendarTwo.book(10,40));
        System.out.println(myCalendarTwo.book(5,15));
        System.out.println(myCalendarTwo.book(5,10));
        System.out.println(myCalendarTwo.book(25,55));

    }
}
