/**
 SOlUTION: reverse, two pointers
 NOTES:
 1. index starts from the end to avoid change initialized elements in nums1;
 2. if m >= 0 and n >= 0, nums1[index] = max of nums1[m] and nums2[n];
 3. if m < 0 but n >= 0, put all elements in nums2 into nums1;
 4. if m >= 0 but n < 0, done;
 5. if m < 0 and n < 0, done.
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m-- + n-- - 1;
        while(m >= 0 && n >= 0) nums1[index--] = nums1[m] >= nums2[n] ? nums1[m--] : nums2[n--];
        while(n >= 0) nums1[index--] = nums2[n--];
    }
}
    
