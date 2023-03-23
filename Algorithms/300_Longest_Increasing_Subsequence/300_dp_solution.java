//Time complexity O(n^2)
//Space complexity O(n)

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int[] LIS = new int[nums.length];
        int max = 0;

        for(int i = nums.length -1; i >= 0 ; i--){
            int len = 1;
            
            for(int j = i + 1; j < LIS.length; j++){
                if(nums[j] > nums[i]){
                    len = Math.max(len, LIS[j] + 1) ;
                }
            }

            LIS[i] = len;

        }

        for(int i : LIS){
            if(i > max){
                max = i;
            }
        }
        return max;
    }
}