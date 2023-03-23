class Solution {
    public int getSum(int a, int b) {
        int carry = (a & b) << 1;
        int adder = a ^ b;
        
        while(carry != 0){
        a = adder;
        b = carry;

        carry = (a & b) << 1;
        adder = a ^ b;
        }

        return adder;
    }
}