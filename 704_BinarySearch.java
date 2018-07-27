/**
思路：二分查找+判断
注意：判断是left<=right，确保可以走到nums[mid]==target更改逻辑值
*/

class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) return -1;
        int left = 0, right = nums.length - 1, mid = 0;
        boolean isExist = false;
        
        while(left <= right){
            mid = left + (right - left) / 2;
            if(nums[mid] == target){
                isExist = true;
                break;
            }else if(nums[mid] < target){
                left = ++mid;
            }else{
                right = --mid;
            }
        }
        
        if(!isExist) return -1;
        return mid;
    }
}
