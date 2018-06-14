/**
双指针
排序数组，固定指针front，移动middle和tail找到最接近的和（每次移动前先判断是否更新sum的值）
*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int middle, tail, temp, sum = nums[0] + nums[1] + nums[2];
        
        for(int front = 0; front < nums.length -2; front++){
            middle = front + 1;
            tail = nums.length - 1;
            
            while(middle < tail){
                if(Math.abs(target - sum) > Math.abs(target - nums[front] - nums[middle] - nums[tail])){
                    sum = nums[front] + nums[middle] + nums[tail];
                }//判断是否需要更新sum的值
                
                if(nums[middle] + nums[tail] < target - nums[front]){//同2Sum
                    middle++;  
                }else if(nums[middle] + nums[tail] > target - nums[front]){
                    tail--;
                }else{
                    return target;
                }
            }
        }
        return sum;
    }
}
