package fun.suder.每日一题.leetcode2022_07_05;

/**
 * <span>Form File</span>
 * <p>Description</p>
 * <p>Copyright: Copyright (c) 2022 版权</p>
 * <p>Company:QQ 752340543</p>
 *
 * @author topsuder
 * @version v1.0.0
 * @DATE 2022/7/5-08:58
 * @Description
 * @see fun.suder.每日一题.leetcode2022_07_05 leetCode-topsuder
 */
public class MyCalendar {
    int[] list;
    public MyCalendar() {
        list = new int[]{};

    }

    public boolean book(int start, int end) {

        if (list.length==0){
            list = new int[]{start,end};
            return true;
        }
        if (list[0]<end && start<list[1]){
            return false;
        }
        if (start<list[0]){
            list[0] = start;
        }
        if (end>list[1]){
            list[1] = end;
        }
        return true;
    }
    public static void main(String[] args) {
        final MyCalendar myCalendar = new MyCalendar();
        myCalendar.book(10, 20);
        myCalendar.book(15, 25);
    }
}
