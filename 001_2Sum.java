/**
方法一：双指针
多用于有序数组，无序数组先排序
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] indexes = new int[2];
        if(nums == null || nums.length < 2) return indexes;
        
        int[] originNums = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            originNums[i] = nums[i];
        }//复制数组
            
        Arrays.sort(nums);//排序
        
        int front = 0;
        int tail = nums.length - 1;
        
        if(nums[front] * 2 > target || nums[tail] * 2 < target) return indexes;//排除过大或过小
        while (front < tail){//数组头尾各设置一个指针，根据比较结果移动指针
            if(nums[front] + nums[tail] > target) tail--;
            if(nums[front] + nums[tail] < target) front++;
            if(nums[front] + nums[tail] == target) break;
        }
        
        int number = 0;
        for(int i = 0; i < originNums.length; i++){//根据选出的数值找到它们在原始数组的index
            if(nums[front] == originNums[i] || nums[tail] == originNums[i]){
                indexes[number] = i;
                number++;
            }
        }  
        return indexes;
    }
}


/** 
方法二: HashMap
HashMap存储键值对，利用数据结构把数组的值作为key，把index作为value.
NOTES:
1. create HashMap: Map<Integer, Integer> mapName = new HashMap<>();
2. containsKey(K) returns true if K is one of the keys in HashMap;
3. add: map.put(key, value).
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map <Integer, Integer> map = new HashMap<> ();
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException ("no two sums");
    }
}
