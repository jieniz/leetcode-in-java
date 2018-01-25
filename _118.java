/**
 SOLUTION: math
 */

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            List<Integer> row = new ArrayList<>();
            for(int index = 0; index <= i; index++){
                if(index == 0 || index == i){
                    row.add(1);
                }else{
                    row.add(pascal.get(i-1).get(index-1)+pascal.get(i-1).get(index));
                }
            }
            pascal.add(row);
        }
        return pascal;
    }
}
