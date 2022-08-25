package fun.suder.leetcode2022_08_25;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> integers = new ArrayList<>(k);

        int mod = 0;
        List<Integer> ax = new ArrayList<>(arr.length);

        for (int j : arr) {
            if (j > x) {
                mod = j - x;
            } else {
                mod = x - j;
            }
        }


        for (int i = 0; i < k; i++) {
            final Integer rm = ax.stream().min(Comparator.comparing(Integer::intValue)).get();
            integers.add(arr[ax.indexOf(rm)]);
            //构建一个新的数组删除arr数组中ax.indexOf(rm)的元素
            int[] newArr = new int[arr.length - 1];
            int index = 0;
            for (int j = 0; j < arr.length; j++) {
                if (j != ax.indexOf(rm)) {
                    newArr[index++] = arr[j];
                }
            }

            arr = newArr;

            ax.remove(rm);
        }
        integers.sort(Comparator.comparing(Integer::intValue));
        return integers;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));

    }
    //最优解
//    public List<Integer> findClosestElements(int[] arr, int k, int x) {
//        List<Integer> list = new ArrayList<>();
//        int n = arr.length - k;
//        int i = 0;
//        for (; i < n; i++) {
//            if(arr[i] >= x)break;//最小的数大于x
//            if(arr[i + k] < x) continue;//最的大数小于x
//            if(Math.abs(arr[i] - x) <= Math.abs(arr[i + k] - x)) break;
//        }
//        for (int j = 0; j < k ; j++) {
//            list.add(arr[j + i]);
//        }
//        return list;
//    }//滑动窗口，大小固定为连续的k
}