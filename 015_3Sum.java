class Solution {
    public List<List<Integer>> threeSum(int[] nums) {        
        List<List<Integer>> list = new ArrayList<>();        
        Arrays.sort(nums);
        
        for(int front = 0; front < nums.length && nums[front] <= 0; front++){
            if(front > 0 && nums[front] == nums[front - 1]) continue;
            int middle = front + 1;
            int tail = nums.length - 1;
            
            while(middle < tail){
                if(nums[middle] + nums[tail] == - nums[front]){
                    list.add(Arrays.asList(nums[front], nums[middle], nums[tail]));
                    
                    int tempMiddle = nums[middle];
                    int tempTail = nums[tail];
                    while(middle < tail && nums[++middle] == tempMiddle);
                    while(middle < tail && nums[--tail] == tempTail);
                }else if(nums[middle] + nums[tail] > - nums[front]){
                    tail--;
                }else{
                    middle++;
                }
            }
        }
        return list;
    }
}
