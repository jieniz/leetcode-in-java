/**
题目：给定数组和目标数值，找到数组中目标数值的左边界和右边界（范围）
方法：二分查找 --> 题目要求复杂度为O(lgn)
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] indexes = new int[]{-1,-1};//设定默认值
        int left = 0, right = nums.length - 1, mid;
        if(nums.length == 0) return indexes;//若数组为空，则返回默认值
        
        while(left < right){
            mid = (left + right) / 2;
            if(nums[mid] >= target){//保证left是目标数值的最左边
                right = mid;
            }else{
                left = mid + 1;
            }
        }//left和right相等时结束循环
        
        if(nums[left] != target) return indexes;//若找到的左边界和target不等，说明数组中不存在target，返回默认值
        indexes[0] = left;
        
        right = nums.length - 1;//左边界保持不变，右边界移到数组最右端
        while(left < right){
            mid = (left + right) / 2 + 1;//中间值靠近右边界
            if(nums[mid] <= target){//保证right是目标数值的最右边
                left = mid;
            }else{
                right = mid - 1;
            }
        }
        indexes[1] = right;
        
        return indexes;
    }
}
