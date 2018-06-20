/**
双指针
思路完全同026
*/

class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) return 0;
        int secondPointer = 0;
        for(int firstPointer = 0; firstPointer < nums.length; firstPointer++){
            if(nums[firstPointer] != val) nums[secondPointer++] = nums[firstPointer]; 
        }
        return secondPointer;
    }
}
