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
                }
                
                if(nums[middle] + nums[tail] < target - nums[front]){
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
