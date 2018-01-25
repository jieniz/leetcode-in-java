/**
 SOLUTION: arraylist, math
 NOTES:
 1. to use only O(k) extra space, we need start from the end, add 1 at the tail and reset the value;
 2. ArrayList vs LinkedList:
 ArrayList: get and set
 LinkedList: add and remove
 */

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++){
            row.add(1);
            for(int j = i-1; j > 0; j--){
                row.set(j, row.get(j)+row.get(j-1));
            }
        }
        return row;
    }
}
