package fun.suder.leetcode2022_11_17_792;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.Collections.binarySearch;

class Solution {
    //暴力
    public int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
        for (String word : words) {
            int i = 0;
            int j = 0;
            while (i<s.length() &&j<word.length()){
                if (s.toCharArray()[i]==word.toCharArray()[j]){
                    i++;
                    j++;
                }else {
                    i++;
                }
            }
            if (j==word.length()){
                ans++;
            }


        }
        return ans;
    }

    //二分查找+分桶
    public int numMatchingSubSeq2(String s,String [] words){
        int count = 0;
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; i++) {
            pos[i]= new ArrayList<>();
        }
        char[] charArray = s.toCharArray();
        for (int i = 0, charArrayLength = charArray.length; i < charArrayLength; i++) {
            char c = charArray[i];
            final int i1 = c - 'a';
            pos[i1].add(i);
        }


        for (String word : words) {

            int ans = 0;
            if (word.length()>s.length()){
                continue;
            }
            if (check(word,pos)){
                count++;
            }
        }
        return count;
    }

    private boolean check(String word, List<Integer>[] pos) {
        Integer i = 0;
        for (char c : word.toCharArray()) {

            //lower_bound
            int low = 0, high = pos[c - 'a'].size();
            while (low < high) {
                int mid = (low + high) / 2;
                if (pos[c - 'a'].get(mid) < i) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            if (low == pos[c - 'a'].size()) {
                return false;
            }
            i = pos[c - 'a'].get(low) + 1;
        }
        return true;
    }

    private int lowerIndex(List<Integer> po, Integer i,int j) {
        j+=1;
        int left = 0, right = po.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (po.get(mid) > i) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return po.get(left) > i || j==1 ? po.get(left) : -1;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().numMatchingSubSeq2("abcde",new String[]{"a","bb","acd","ace"}));
    }
}