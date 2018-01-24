/*
 SOLUTION: math
 NOTES:
 define array: int[] name = new int[size]
 */

class Solution {
    public int[] plusOne(int[] digits) {
        int sum = 0;
        int carry = 1;
        for(int i = digits.length -1; i >= 0 ; i--){
            if(digits[i] != 9 || (digits[i] == 9 && carry == 0)){
                digits[i] += carry;
                carry = 0;
            }else{
                digits[i] = 0;
                carry = 1;
            }
        }
        if(carry == 1){
            int[] newDigits = new int[digits.length+1];
            newDigits[0] = 1;
            for(int i = 1; i < newDigits.length; i++){
                newDigits[i] = digits[i-1];
            }
            return newDigits;
        }
        return digits;
    }
}
