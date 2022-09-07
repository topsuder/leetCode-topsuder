package fun.suder.leetcode2022_09_07;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution {
    public String reorderSpaces(String text) {
        String[] words =text.split(" ");
        int a = 0;
        List<String> strings = new ArrayList<>();

        for (String word : words) {
            if (!Objects.equals(word, "")) {
                strings.add(word);
            }
        }
        for (char c : text.toCharArray()) {
            if (c==' '){
                a++;
            }
        }
        if (a==0){
            return text;
        }
        if ((strings.size() - 1)==0) {
            String s = strings.get(0);
            for (int i = 0; i < a; i++) {

                s +=" ";
            }
            return s;
        }
        final int yu = a % (strings.size() - 1);
        int i = 0 ;
        if (yu==0) {
            i=a/(strings.size()-1);
        }else {
            i=(a-yu)/(strings.size()-1);
        }
        String str = "";
        for (int i1 = 0; i1 < strings.size(); i1++) {
            str+= strings.get(i1);
            if (i1!=strings.size()-1){
                for (int j = 0; j < i; j++) {
                    str+=" ";
                }
            }else {
                if (yu!=0){
                    for (int i2 = 0; i2 < yu; i2++) {
                        str+=" ";
                    }
                }
            }
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reorderSpaces(" a"));
    }

}