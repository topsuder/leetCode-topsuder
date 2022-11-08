package fun.suder.leetcode2022_09_21;

class Solution {
    public int kSimilarity(String s1, String s2) {
        final char[] s1Array = s1.toCharArray();
        final char[] s2Array = s2.toCharArray();
        int lIndex = 0;
        int jilu = 0;
        int rIndex = 0;
        for (int i = 0; i < s1Array.length; i++) {
            if (s1Array[i]==s2Array[i]) {
                continue;
            }else {
                if (jilu!=1){
                    jilu=1;
                    lIndex = i;
                }else {
                    rIndex = i;
                }
            }

        }
        return rIndex-lIndex;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kSimilarity("ab","ba"));


        //密码正则：密码长度不能少于8位，且必须为字符、数字和符号中的任意两种组合
//^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,15}$
        //不是上面这个
    }
}