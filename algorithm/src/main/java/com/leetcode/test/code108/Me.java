package com.leetcode.test.code108;

import com.leetcode.test.TreeNode;

public class Me {

    public TreeNode sortedArrayToBST(int[] nums) {
        //找到每个范围的中点值作为根
        int n = nums.length;
        return f(nums, 0, n - 1);
    }

    public TreeNode f(int[] nums, int left, int right){
        if(left > right){
            return null;
        }
        int mid = (left + right) / 2;
        return new TreeNode(nums[mid], f(nums, left, mid - 1), f(nums, mid + 1, right));
    }
}
