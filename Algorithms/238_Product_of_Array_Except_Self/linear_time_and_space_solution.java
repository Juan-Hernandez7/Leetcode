class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        prefix[0] = nums[0];
        postfix[nums.length -1] = nums[nums.length -1];
        for(int i = 1; i < nums.length; i++){
            prefix[i] = nums[i] * prefix[i-1];
        }

        for(int i = nums.length - 2 ; i >= 0; i--){
            postfix[i] = nums[i] * postfix[i + 1];
        }

        for(int i = 0; i <nums.length; i++){
          int ans = 1;

          if(i > 0){
              ans *= prefix[i-1];
          }

          if(i < nums.length - 1){
              ans *= postfix[i+1];
          }

          nums[i] = ans;
        }

        return nums;

    }
}