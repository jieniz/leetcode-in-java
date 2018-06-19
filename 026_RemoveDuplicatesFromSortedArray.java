/**
 SOLUTION: two pointers
 NOTES:
 1. 双指针的放置不再是一前一后，而是全部从1开始，一个遍历数组，另一个仅在遇到非重复数组时改变当前数值并+1
 2. consider corner case: 0，1
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2) return nums.length;        
        int secondPointer = 1;
        for(int firstPointer = 1; firstPointer < nums.length; firstPointer++){
            if(nums[firstPointer] != nums[firstPointer - 1]) nums[secondPointer++] = nums[firstPointer];
        }
        return secondPointer;
    }
}
