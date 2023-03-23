class Solution {
    double count;

    public void bfsChange(int[] coins, int amount, int i, int num_coins){
        if(i >= coins.length || amount - coins[i] < 0 || (double)num_coins > count){
            return;
        }
        
        int curr_amount = amount - coins[i];
        int curr_coins = num_coins + 1;

        if(curr_amount == 0 && curr_coins < count ){
            count = (double)curr_coins;
            return;
        }

        bfsChange(coins, curr_amount, i+1 , curr_coins);
        bfsChange(coins, amount, i+1, num_coins);
        bfsChange(coins, curr_amount, i, curr_coins);



    }

    public int coinChange(int[] coins, int amount) {
        count = Double.POSITIVE_INFINITY ;

        if(amount == 0){
            return 0;
        }

        bfsChange(coins, amount, 0, 0);

        if(count == Double.POSITIVE_INFINITY){
            return -1;
        }

        return (int)count;
    }
}