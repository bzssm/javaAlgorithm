package DP;

public class 连续子数组最大和GreatestSumOfSubArray {
    public int greatestSumOfSubArray(int[] nums){
        int greatestSum = Integer.MIN_VALUE;
        int sum=0;
        for(int val:nums){
            // 如果sum已经小于0，那就直接前面都不要，否则全都要
            //然后比较当前sum和最大sum，取较大值
            sum = sum<=0?val:sum+val;
            greatestSum = Math.max(sum, greatestSum);
        }
        return greatestSum;
    }
}
