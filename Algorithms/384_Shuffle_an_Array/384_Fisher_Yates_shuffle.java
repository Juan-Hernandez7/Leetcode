class Solution {
    private int[] nums;
    private Random rando;

    public Solution(int[] nums) {
        this.nums = nums;
        rando = new Random();
    }
    
    public int[] reset() {
        return nums;
    }
    
    public int[] shuffle() {

        int [] shuffled = nums.clone();

        for(int i = nums.length -1; i > 0; i--){

            int rand = rando.nextInt(i + 1);

            int temp = shuffled[i];
            shuffled[i] = shuffled[rand];
            shuffled[rand] = temp;


        }

        return shuffled;
    }
}
