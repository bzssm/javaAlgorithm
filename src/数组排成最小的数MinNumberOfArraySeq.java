import java.util.Arrays;

public class 数组排成最小的数MinNumberOfArraySeq {
    public int minNumber(int[] nums){
        String[] numStr = new String[nums.length];
        for(int i=0;i<nums.length;i++)
            numStr[i] = String.valueOf(nums[i]);
        Arrays.sort(numStr, (s1,s2) -> (s1+s2).compareTo(s2+s1));
        String res = "";
        for(String s : numStr)
            res+=s;
        return Integer.parseInt(res);
    }

    public static void main(String[] args) {
        数组排成最小的数MinNumberOfArraySeq ins = new 数组排成最小的数MinNumberOfArraySeq();
        System.out.println(ins.minNumber(new int[]{3,32,321}));
    }
}
