//Time Complexity is O(n)
//Space Complexity O(1)

class Solution {
    public boolean increasingTriplet(int[] nums) {
            if(nums == null || nums.length < 3){
                return false;
            }
            
            double small = Double.POSITIVE_INFINITY;
            double big =   Double.POSITIVE_INFINITY;

            for(int i = 0; i < nums.length; i++){
                if(nums[i] <= small){
                    small = nums[i];
                }
                else if(nums[i] <= big){
                    big = nums[i];
                }
                else{
                    return true;
                }
            }


                return false;

    }
}