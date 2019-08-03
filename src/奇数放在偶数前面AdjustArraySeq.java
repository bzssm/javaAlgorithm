public class 奇数放在偶数前面AdjustArraySeq {
    public int[] reorderArray(int[] nums) {
        //数出来奇数个数
        int oddNum = 0;
        for (int x : nums) {
            if (x % 2 == 1) {
                oddNum++;
            }
        }
        int[] res = new int[nums.length];
        int i = 0, j = oddNum;
        for (int x : nums) {
            if (x % 2 == 1) {
                nums[i] = x;
                i++;
            } else {
                nums[j] = x;
                j++;
            }
        }
        return res;
    }
}
