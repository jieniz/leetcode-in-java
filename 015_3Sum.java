/**
双指针
数组排序，设置3个指针，固定其中1个，移动剩余2个（同2sum）
Notes：
1. 每个数组中可以有重复元素，但是返回的list中不能有重复数组，因此需要针对3个指针进行去重；
2. 找到正确的middle、tail后要实现Middle++和tail--，否则陷入无限循环（此处在去重中实现了指针的加减）
3. while语句中的三个if不能并列，要试用if, else if，else的方式，避免执行完一个还符合另一个条件
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {        
        List<List<Integer>> list = new ArrayList<>();        
        Arrays.sort(nums);
        
        for(int front = 0; front < nums.length && nums[front] <= 0; front++){//固定指针front
            if(front > 0 && nums[front] == nums[front - 1]) continue;//排除front重复
            int middle = front + 1;
            int tail = nums.length - 1;
            
            while(middle < tail){//同2sum
                if(nums[middle] + nums[tail] == - nums[front]){
                    list.add(Arrays.asList(nums[front], nums[middle], nums[tail]));//添加嵌套list
                    
                    int tempMiddle = nums[middle];
                    int tempTail = nums[tail];
                    while(middle < tail && nums[++middle] == tempMiddle);//排除middle重复
                    while(middle < tail && nums[--tail] == tempTail);//排除tail重复
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
