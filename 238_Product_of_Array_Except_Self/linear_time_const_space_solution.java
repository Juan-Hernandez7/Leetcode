//Problem states output array is not considered in the space time complexity


class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] output = new int[nums.length];
        output[0] = 1;
        int post = 1;
        
        for(int i = 1; i < output.length; i++){
            output[i] = nums[i-1] * output[i-1];
        }


        for(int i = nums.length -1; i >= 0; i--){
            output[i] = post * output[i];
            post *= nums[i];
        }

        return output;

    }
}