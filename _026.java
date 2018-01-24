/**
 SOLUTION: array, two pointers
 NOTES:
 1. two pointers in the same array, one is the original, another is the index;
 2. consider corner case: 0.
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            if(nums[i] != nums[index]){
               nums[++index] = nums[i];
            }
        }
        return index+1;
    }
}
