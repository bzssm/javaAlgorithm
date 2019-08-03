public class 数组重复数字RepeatNumberInArray {
    public static void main(String[] agrs) {
        数组重复数字RepeatNumberInArray ins = new 数组重复数字RepeatNumberInArray();
        System.out.println(ins.findRepeatNumberInArray(new int[]{2, 3, 1, 0, 2, 5}));
    }

    /*
     *在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
     * 请找出数组中任意一个重复的数字。
     *
     *Input:
     *{2, 3, 1, 0, 2, 5}
     *Output: 2
     *
     * */
    /*
     *把值为i的元素放到i位置
     */
    public int findRepeatNumberInArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
