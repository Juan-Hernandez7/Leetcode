// Solution runs in O(n) Time Complexity
// Space Complexity is O(1)


class Solution {

    public int findDuplicate(int[] nums) {

        if(nums == null || nums.length ==0){
            return -1;
        }
        
        int len = nums.length;
        int dup = -1;

        for(int i=0; i < len; i++){
            nums[(nums[i] % len) -1] += len;
        }

        for(int i=0; i < len; i++){
            if(nums[i] / len > 1){
                dup = i+1;
            }

            nums[i] = nums[i] % len;
        }

        return dup;

    }
}