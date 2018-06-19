/**
 SOLUTION: two pointers 双指针
 NOTES:
 1. for any i, the maximum area will be the farest j with height[j] > height[i];
 2. O(n)遍历：由于面积由较小的值决定，因此移动较大值对面积没有影响，仅移动较小值就可以实现遍历，避免双重遍历，复杂度为O(n).
 */

class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int temp, volumn, maxVolumn = 0;
        
        while(left < right){
            temp = height[left] > height[right] ? height[right] : height[left];
            volumn = temp * (right - left);
            if(volumn > maxVolumn) maxVolumn = volumn;
            
            if(height[left] <= height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxVolumn;
    }
}
