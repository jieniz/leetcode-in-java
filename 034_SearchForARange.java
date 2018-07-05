class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] indexes = new int[]{-1,-1};
        int left = 0, right = nums.length - 1, mid;
        if(nums.length == 0) return indexes;
        
        while(left < right){
            mid = (left + right) / 2;
            if(nums[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        
        if(nums[left] != target) return indexes;
        indexes[0] = left;
        
        right = nums.length - 1;
        while(left < right){
            mid = (left + right) / 2 + 1;
            if(nums[mid] <= target){
                left = mid;
            }else{
                right = mid - 1;
            }
        }
        indexes[1] = right;
        
        return indexes;
    }
}
