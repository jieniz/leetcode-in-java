/**
 SOLUTION: two pointers;
 NOTES: too slow (12.9%)
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                return i;
            }else if(nums[i] < target){
                nums[index++] = nums[i];
            }else{
                break;
            }
        }
        return index;
    }
}

/**
 SOLUTION: binary search
 NOTES:
 1. faster: 53.86%
 2. right <= left is the condition; otherwise, cannot get correct answer if target is 0;
 3. mid >> 1 equals to mid/2; mid << 1 equals to mid*2;
 4. combining left < and = right is fine.
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length-1, mid = (left+right) >> 1;
        while(left <= right){
            if(target <= nums[mid]) right = mid-1;
            else left = mid + 1;
            mid = (left+right) >> 1;
        }
        return left;
    }
}
