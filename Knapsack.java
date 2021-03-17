class Knapsack {
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        Integer[][] memo = new Integer[weights.length][capacity + 1];
        return helper(profits, weights, capacity, 0, memo);
    }

    public int helper(int[] profits, int[] weights, int capacity, int index, Integer[][] memo) {
        if (index >= weights.length || capacity <= 0) {
            return 0;
        }

        if (memo[index][capacity] != null) {
            return memo[index][capacity];
        }
        int profitWithCurrentItem = 0;
        if (weights[index] <= capacity) {
            profitWithCurrentItem = profits[index]
                    + helper(profits, weights, capacity - weights[index], index + 1, memo);
        }
        int profitWithoutCurrentItem = helper(profits, weights, capacity, index + 1, memo);
        int profit = Math.max(profitWithCurrentItem, profitWithoutCurrentItem);

        memo[index][capacity] = profit;
        return profit;
    }

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        int[][] dp = new int[profits.length + 1][capacity + 1];
        for(int i = 1; i < dp.length; ++i){
        for(int j = 1; j <= capacity; ++j){
            if(weights[i - 1] <= j){
            dp[i][j] = Math.max(profits[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
            }else{
            dp[i][j] = dp[i - 1][j];
            }
        }
        }
        return dp[dp.length - 1][capacity];
    }
  }