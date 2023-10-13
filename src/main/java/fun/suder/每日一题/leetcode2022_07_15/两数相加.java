package fun.suder.每日一题.leetcode2022_07_15;

/**
 * <span>Form File</span>
 * <p>Description</p>
 * <p>Copyright: Copyright (c) 2022 版权</p>
 * <p>Company:QQ 752340543</p>
 *
 * @author topsuder
 * @version v1.0.0
 * @DATE 2022/7/15-09:32
 * @Description
 * @see fun.suder.每日一题.leetcode2022_07_15 leetCode-topsuder
 */
public class 两数相加 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    StringBuilder stringBuilder1=new StringBuilder();

    StringBuilder stringBuilder2=new StringBuilder();
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        if (l1!=null) {
            stringBuilder1.append(l1.val);
            return addTwoNumbers(l1.next,l2.next);
        }


        if (l2!=null) {
            stringBuilder2.append(l2.val);
            return addTwoNumbers(l1.next,l2.next);
        }


        Long sum = Long.parseLong(stringBuilder1.toString())+Long.parseLong(stringBuilder2.toString());
        //反转sum
        String sumStr = sum.toString();
        StringBuilder sumStrBuilder = new StringBuilder();
        for (int i = sumStr.length()-1; i >=0; i--) {
            sumStrBuilder.append(sumStr.charAt(i));
        }
        //转换成ListNode
        ListNode listNode = new ListNode();
        for (int i = 0; i < sumStrBuilder.length(); i++) {
            listNode.val = Integer.parseInt(String.valueOf(sumStrBuilder.charAt(i)));
            if (i==sumStrBuilder.length()-1){
                break;
            }
            listNode.next = new ListNode();
            listNode = listNode.next;
        }


        return listNode;
    }

    public static void main(String[] args) {
        两数相加 twoSum = new 两数相加();
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode listNode = twoSum.addTwoNumbers(listNode1,listNode4);

    }
}

