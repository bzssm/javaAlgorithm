package DP;

public class 二维数组和最长的路径MaxSum {
    /*
    * 两种方法，深度优先dfs， 时间复杂度比较大
    * 动态规划求最大值*/
    public int maxSum(int[][] nums){
        int[][] dp = new int[nums.length+1][nums[0].length+1];
        for(int i=1; i<nums.length+1;i++){
            for(int j=1;j<nums[0].length+1;j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + nums[i-1][j-1];
            }
        }
        return dp[nums.length][nums[0].length];
    }

    public static void main(String[] args) {
        int[][] gift = new int[][]{
                {1,10,3,8},
                {12,2,9,6},
                {5,7,4,11},
                {3,7,16,5}
        };
        二维数组和最长的路径MaxSum ins = new 二维数组和最长的路径MaxSum();
        System.out.println(ins.maxSum(gift));
    }
}
