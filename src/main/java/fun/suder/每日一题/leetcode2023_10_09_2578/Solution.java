package fun.suder.每日一题.leetcode2023_10_09_2578;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int splitNum(int num) {
        final String numStr = String.valueOf(num);

        List<Integer> charList = new ArrayList<>(numStr.length());
        for (char c : numStr.toCharArray()) {
            charList.add(c - '0');
        }

        charList.sort(Comparator.comparingInt(o -> o));


        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder ();

        for (int i = 0; i < charList.size(); i++) {
            if (i % 2 == 0) {
                num2.append(charList.get(i));
            }else {
                num1.append(charList.get(i));
            }
        }

        return Integer.parseInt(num1.toString()) + Integer.parseInt(num2.toString());



    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.splitNum(4325));
    }
}