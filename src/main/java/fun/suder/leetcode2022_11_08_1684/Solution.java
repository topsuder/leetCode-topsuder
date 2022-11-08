package fun.suder.leetcode2022_11_08_1684;

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] flags = new boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                if (!allowed.contains(String.valueOf(c))){
                    flags[i] = true;
                    break;
                }
            }
        }
        int count = 0;
        for (boolean flag : flags) {
            if (!flag){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"}));
    }
}