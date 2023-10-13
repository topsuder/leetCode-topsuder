package fun.suder.每日一题.leetcode2022_07_05;

import java.util.Arrays;

/**
 * <span>Form File</span>
 * <p>Description</p>
 * <p>Copyright: Copyright (c) 2022 版权</p>
 * <p>Company:QQ 752340543</p>
 *
 * @author topsuder
 * @version v1.0.0
 * @DATE 2022/7/5-20:38
 * @Description
 * @see fun.suder.每日一题.leetcode2022_07_05 leetCode-topsuder
 */
public class Solution {
    public int nextGreaterElement(int n) {
        String str = String.valueOf(n);
        char[] chars = str.toCharArray();
        //排序
        for (int i = chars.length-1 ; i >=0 ; i--){
            for (int j = chars.length-1;j>i;j--){
                if (chars[i]>chars[j]){
                    char temp = chars[j];
                    chars[j] = chars[i];
                    chars[i] = temp;
                    Arrays.sort(chars,i+1,chars.length);
                }
            }
        }
        StringBuilder newStr = new StringBuilder();
        for (char aChar : chars) {
            newStr.append(aChar);
        }
        final int s = Integer.parseInt(String.valueOf(newStr));
        if (s>n){
            return s;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nextGreaterElement(1234));
    }
}
