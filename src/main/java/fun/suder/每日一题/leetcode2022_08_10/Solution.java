package fun.suder.每日一题.leetcode2022_08_10;

class Solution {
    static final String INF_SOL = "Infinite solutions";
    static final String NO_SOL = "No solution";
    public String solveEquation(String equation) {
        final char[] chars = equation.toCharArray();
        char[] leftString = new char[equation.length()];
        char[] rightString= new char[equation.length()];
        int eqIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='=') {
                eqIndex=i;
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (i<eqIndex){
                leftString[i]=chars[i];
            }
            if (i>eqIndex){
                rightString[i-eqIndex]=chars[i];
            }
        }
        for (char c : leftString) {
            switch (c){
                case 'x':


            }
        }
        System.out.println(leftString);
        System.out.println(rightString);
        return "";
    }

    public static void main(String[] args) {
        final String s = new Solution().solveEquation("x+5-3+x=6+x-2");
    }
}
