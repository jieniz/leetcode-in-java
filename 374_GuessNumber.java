/**
题目：给定上限n，根据guess方法返回值猜数字
方法：二分查找 --> 1到n自带排序
*/

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1, high = n, mid = 1;
        while(low < high){
            mid = low + (high - low) / 2;//若n的数值很大，low+high可能导致溢出，所以采取这种写法！
           
            if(guess(mid) == 0){
                break;
            }else if(guess(mid) == -1){
                high = --mid;
            }else if(guess(mid) == 1){
                low = ++mid;    
            }
        }
        return mid;
    }
}
