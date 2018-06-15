class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length < 4) return list;
        
        Arrays.sort(nums);
        if(nums[0] * 4 > target || nums[nums.length - 1] * 4 < target) return list;
        
        int front, midLeft, midRight, tail;  
        int max = nums[nums.length - 1];
        
        for(front = 0; front < nums.length - 3; front++){
            if(front > 0 && nums[front - 1] == nums[front]) continue;
            if(nums[front] + 3 * max < target) continue;
            if(nums[front] * 4 > target) break;
            if(nums[front] * 4 == target && front + 3 < nums.length && nums[front] == nums[front + 3]){
                list.add(Arrays.asList(nums[front], nums[front], nums[front], nums[front]));
                break;
            }
            
            if(3 * nums[front + 1] > target - nums[front] || 3 * max < target - nums[front]) break;
            for(midLeft = front + 1; midLeft < nums.length -2; midLeft++){
                if(midLeft > front + 1 && nums[midLeft - 1] == nums[midLeft]) continue;
                if(nums[midLeft] + 2 * max < target - nums[front]) continue;
                if(nums[midLeft] * 3 > target - nums[front]) break;
                if(nums[midLeft] * 3 == target - nums[front] && midLeft + 2 < nums.length && nums[midLeft] == nums[midLeft + 2]){
                    list.add(Arrays.asList(nums[front], nums[midLeft], nums[midLeft], nums[midLeft]));
                    break;
                }
                
                midRight = midLeft + 1;
                tail = nums.length - 1;
                
                int targetTemp = target - nums[front] - nums[midLeft];
                if(nums[midRight] * 2 > targetTemp || nums[tail] * 2 < targetTemp) break;
                
                while(midRight < tail){
                    if(nums[midRight] + nums[tail] > target - nums[front] - nums[midLeft]){
                        tail--;
                    }else if(nums[midRight] + nums[tail] < target - nums[front] - nums[midLeft]){
                        midRight++;
                    }else{
                        list.add(Arrays.asList(nums[front], nums[midLeft], nums[midRight], nums[tail]));
                        
                        int midRightTemp = nums[midRight];
                        int tailTemp = nums[tail];
                        while(midRight < tail && nums[++midRight] == midRightTemp);
                        while(midRight < tail && nums[--tail] == tailTemp);
                    }
                }
            }
        }
        return list;
    }
}
