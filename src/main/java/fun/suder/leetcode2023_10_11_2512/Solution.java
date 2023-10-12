package fun.suder.leetcode2023_10_11_2512;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static void main(String[] args) {
        /**
         positive_feedback =
         ["xrezzxgdvg","bcgx","wcfzmfosr"]
         negative_feedback =
         ["qyouhus","ukou","eirhfbt","qciw","for"]
         report =
         ["bcgx bcgx eirhfbt kvcrym bcgx cxzs eirhfbt wcfzmfosr v qciw","bcgx xrezzxgdvg bcgx xrezzxgdvg wcfzmfosr chap qyouhus biyt wcfzmfosr qciw","xrezzxgdvg wcfzmfosr ukou qcr clnj xrezzxgdvg gvtkvb qciw hi wcfzmfosr","for for mnxpqrdth bcgx bcgx qciw wcfzmfosr lspvgjvk wcfzmfosr eirhfbt","loxyg bcgx jwdesdu xrezzxgdvg wcfzmfosr rrych qyouhus wcfzmfosr klcwo xrezzxgdvg","rvbd wcfzmfosr lj xrezzxgdvg xuwguhgyyy fuz eirhfbt ukou h bcgx","bcgx wpmxyvbhc for qciw wcfzmfosr wjdm qyouhus qciw for xrezzxgdvg","bcgx sj xrezzxgdvg yjoklk bcgx hpc xrezzxgdvg lqfrvk xrezzxgdvg wcfzmfosr","qc wcfzmfosr jkjpgjalc tm v wcfzmfosr orgsqjzwa wcfzmfosr hh bfnxcx"]
         student_id =
         [686276715,934288178,625397331,519945877,864052244,971253305,512505036,865635090,281613863]
         k =
         9
         */

        final Solution solution = new Solution();
        final List<Integer> integers = solution.topStudents(new String[]{"xrezzxgdvg", "bcgx", "wcfzmfosr"}
                , new String[]{"qyouhus", "ukou", "eirhfbt", "qciw", "for"}
                , new String[]{"bcgx bcgx eirhfbt kvcrym bcgx cxzs eirhfbt wcfzmfosr v qciw", "bcgx xrezzxgdvg bcgx xrezzxgdvg wcfzmfosr chap qyouhus biyt wcfzmfosr qciw", "xrezzxgdvg wcfzmfosr ukou qcr clnj xrezzxgdvg gvtkvb qciw hi wcfzmfosr", "for for mnxpqrdth bcgx bcgx qciw wcfzmfosr lspvgjvk wcfzmfosr eirhfbt", "loxyg bcgx jwdesdu xrezzxgdvg wcfzmfosr rrych qyouhus wcfzmfosr klcwo xrezzxgdvg", "rvbd wcfzmfosr lj xrezzxgdvg xuwguhgyyy fuz eirhfbt ukou h bcgx", "bcgx wpmxyvbhc for qciw wcfzmfosr wjdm qyouhus qciw for xrezzxgdvg", "bcgx sj xrezzxgdvg yjoklk bcgx hpc xrezzxgdvg lqfrvk xrezzxgdvg wcfzmfosr", "qc wcfzmfosr jkjpgjalc tm v wcfzmfosr orgsqjzwa wcfzmfosr hh bfnxcx"}
                , new int[]{686276715, 934288178, 625397331, 519945877, 864052244, 971253305, 512505036, 865635090, 281613863}, 9);
        System.out.println(integers);
    }

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {

        // desc

        Integer[][] student = new Integer[student_id.length][2];


        // 正确桶
        Set<String> positiveFeedbackSet = new HashSet<>(Arrays.asList(positive_feedback));
        // 错误桶
        Set<String> negativeFeedbackSet = new HashSet<>(Arrays.asList(negative_feedback));

        for (int i = 0; i < student_id.length; i++) {
            final String[] currentReports = report[i].split(" ");


            for (String currentReport : currentReports) {

                if (positiveFeedbackSet.contains(currentReport)) {
                    student[i][0] = student_id[i];
                    if (student[i][1] == null) {
                        student[i][1] = 3;
                    } else {
                        student[i][1] += 3;
                    }
                } else if (negativeFeedbackSet.contains(currentReport)) {
                    student[i][0] = student_id[i];
                    if (student[i][1] == null) {
                        student[i][1] = -1;
                    } else {
                        student[i][1]--;
                    }
                } else {
                    student[i][0] = student_id[i];
                    if (student[i][1] == null) {
                        student[i][1] = 0;
                    }
                }
            }

        }

        return Arrays.stream(student)
                .sorted(((o1, o2) -> {
                    if (Objects.equals(o1[1], o2[1])) {
                        return o1[0] - o2[0];
                    }
                    return o2[1] - o1[1];
                }))
                .limit(k).map(data -> data[0]).collect(Collectors.toList());
    }

}