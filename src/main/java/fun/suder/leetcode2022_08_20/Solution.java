package fun.suder.leetcode2022_08_20;


import sun.security.util.ArrayUtil;

import javax.swing.tree.TreeNode;
import java.util.Arrays;
import java.util.OptionalInt;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode treeNode = new TreeNode();

        initTree(treeNode,nums);
        return treeNode;
    }

    private void initTree(TreeNode treeNode,int[] nums) {


        int max = nums[0];
        int maxIndex = 0;

        //从下标1开始遍历arry
        for(int i = 1; i < nums.length; i++) {

            //将当前元素与max作比较，如果大于max，则替换max的值
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }
        int[] left = new int[maxIndex];
        int[] right = new int[nums.length-maxIndex-1];

        for (int i = 0; i < nums.length-1; i++) {
            if (i<maxIndex){
                left[i]=nums[i];
            }else {
                right[i-maxIndex]=nums[i+1];
            }
        }

        treeNode.val=max;



        if (left.length>0){
            treeNode.left= new TreeNode(Arrays.stream(left).max().getAsInt());
            initTree(treeNode.left,left);
        }
        if (right.length>0){
            treeNode.right= new TreeNode(Arrays.stream(right).max().getAsInt());
            initTree(treeNode.right,right);
        }

    }

    public static void main(String[] args) {
        //定义一个超级大的要处理的nums数组
        int[] nums = new int[100000];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=i;
        }
        Solution solution = new Solution();
        TreeNode treeNode = solution.constructMaximumBinaryTree(nums);
        System.out.println(treeNode);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}