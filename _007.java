/** 
Solution One: arraylist --> array --> sum
Notes:
1. in case of the overflow of sum: use long. if overflow, return 0;
2. if x < 0, x = -x, return -positiveReverse(x);
3. convert arraylist to array: Integer[] array = list.toArray(new Integer[list.size()]);
4. range of 32-bit int: [-2147483648, 2147483647].
*/
class Solution {
    public int reverse(int x) {
        if(x >= 0){
            return positiveReverse(x);
        }else{
            x = -x;
            return -positiveReverse(x);
        }
    }
    public static int positiveReverse(int x){
        List<Integer> list = new ArrayList<>();
        while (x != 0){
            list.add(x % 10);
            x = x / 10;
        }
        Integer[] array = list.toArray(new Integer[list.size()]);
        long sum = 0;
        for(int i = 0; i < array.length; i++){
            sum += array[i] * Math.pow(10, array.length-1-i);
        }
        if(sum > 2147483647 || sum < -2147483648){
            return 0;
        }else{
            return (int)sum;
        }
    }
}

/**
 Solution Two: Math
 Notes:
 1. algorithm: res = res * 10 + x / 10;
 2. overflow: Integer.MIN_VALUE, Integer.MAX_VALUE;
 3. type casting: (int)res.
 */
class Solution {
    public int reverse(int x) {
        long res = 0;
        for( ; x != 0; x /= 10){
            res = res * 10 + x % 10;
        }
        return res < Integer.MIN_VALUE || res > Integer.MAX_VALUE ? 0 : (int)res ;
    }
}
