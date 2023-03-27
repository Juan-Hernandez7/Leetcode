// O(n^2) Time Complexity
// O(n^2) Space Complexity

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count =0;

        if(nums1 == null || nums1.length ==0){
            return 0;
        }

        HashMap<Integer, Integer> sums = new HashMap<Integer, Integer>();

        for(int i : nums1){
            for(int j : nums2){
                if(sums.containsKey(i+j)){
                    sums.put(i + j, sums.get(i + j) + 1);
                }
                else{
                    sums.put(i + j, 1);
                }
            }
        }

        for(int i : nums3){
            for(int j : nums4){
                if(sums.containsKey(-(i + j))){
                    count+= sums.get(-(i+j));
                }
            }

        }

        return count;
        
    }
}