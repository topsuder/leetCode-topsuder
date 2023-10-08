package fun.suder.leetcode2022_11_25;

class Solution {
    public int expressiveWords(String s, String[] words) {
        final char[] chars = s.toCharArray();
        for (String word : words) {
            final char[] chars1 = word.toCharArray();
            for (int i = 0,j=0; i < chars1.length;) {
                if (chars[j]==chars1[i]) {
                    i++;
                }else {
                    j++;
                    i++;
                }
            }
        }
        return 0;
    }
}