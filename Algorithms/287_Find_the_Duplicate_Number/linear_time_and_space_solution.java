// Solution runs in O(n) Time Complexity
// Space Complexity is O(n)

class Solution {
    public int findDuplicate(int[] nums) {

        if(nums == null || nums.length ==0){
            return -1;
        }
        
        HashSet<Integer> set = new HashSet<>();

        for(int i: nums){
            if(set.contains(i)){
                return i;
            }
            set.add(i);
        } 


        return 0;
    }
}