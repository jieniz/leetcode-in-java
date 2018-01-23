/** 
SOLUTION: HashMap 
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
