package fun.suder.leetcode2022_07_07;

import java.util.ArrayList;
import java.util.List;

/**
 * <span>Form File</span>
 * <p>Description</p>
 * <p>Copyright: Copyright (c) 2022 版权</p>
 * <p>Company:QQ 752340543</p>
 *
 * @author topsuder
 * @version v1.0.0
 * @DATE 2022/7/7-09:02
 * @Description
 * @see fun.suder.leetcode2022_07_07 leetCode-topsuder
 */
public class replaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        final String[] strings = sentence.split(" ");

        StringBuffer returnString = new StringBuffer();

        for (String string : strings) {
            for (String d : dictionary) {
                if (string.startsWith(d)) {
                    string =  d;
                }
            }
            returnString.append(" ");
            returnString.append(string);
        }
        return returnString.toString().substring(1);
    }

    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        String sentence = "the cattle was rattled by the battery";
        final replaceWords replaceWords = new replaceWords();
        System.out.println(replaceWords.replaceWords(dictionary,sentence));
    }
}
