public class 数组出现次数超过一半的数字FreqMoreThanHalfBoyerMooreMajorityVoteAlgorithm {
    /*
    * 有三种方法
    * 1.先排序，再扫一次，时间复杂度o(nlogn),空间复杂度o(n)->只记录当前元素和顺序即可
    * 2.用HashMap统计所有元素出现次数，时间复杂度o(n)，空间复杂度o(n)
    * 3.多数投票算法
    * 先扫一遍，找出可能的candidate
    * 再扫一遍，缺人candidate出现次数大于一半
    * bmmv算法优点：可以分布式进行
    * 原数组：[1,1,0,1,1,0,1,0,0]
    * 划分1：
    *[1,1,0,1,1] –> (candidate,count)=(1,3)
    *划分2：
    *[0,1,0,0] –> (candidate,count)=(0,2)
    *根据(1,3)和(0,2)可得，原数组的多数元素为1.
    * */

    public int bmmv(int[] nums){
        int candidate = nums[0];
        int count = 0;
        for(int x:nums){
            if (x==candidate){
                count++;
            }else
                count--;
            if (count==0){
                candidate = x;
                count=1;
            }
        }

        count=0;
        for (int x: nums){
            if (candidate==x){
                count++;
            }
        }
        return count>nums.length/2?candidate:-1;

    }

    public static void main(String[] args) {
        int[] n = new int[]{1,0,0,0,1,1,0,0,0,0,1,1,1,1,1,0,1,0,0};
        数组出现次数超过一半的数字FreqMoreThanHalfBoyerMooreMajorityVoteAlgorithm ins = new 数组出现次数超过一半的数字FreqMoreThanHalfBoyerMooreMajorityVoteAlgorithm();
        System.out.println(ins.bmmv(n));
    }
}
