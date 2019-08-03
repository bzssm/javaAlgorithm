package DP;


public class 数字翻译成字符串NumberToString {
    /*
    * 给定一个数字，按照如下规则翻译成字符串：
    * 1 翻译成“a”，2 翻译成“b”... 26 翻译成“z”。
    * 一个数字有多种翻译可能，
    * 例如 12258 一共有 5 种，分别是 abbeh，lbeh，aveh，abyh，lyh。
    * 实现一个函数，用来计算一个数字有多少种不同的翻译方法。*/
    /*
    * dp解法*/
    public int numberToString(String s){
        int[] dp = new int[s.length()+1];
        // dp:前i个字符有多少种可能
        dp[0] = 1;
        // 如果0开头，那么前1个是没有可能的
        dp[1] = s.charAt(0)=='0'?0:1;
        for(int i=2;i<s.length()+1; i++){
            int one = Integer.valueOf(String.valueOf(s.charAt(i-1)));
            if(one!=0){
                dp[i] = dp[i-1];
            }
            if(s.charAt(i-2)=='0')
                continue;
            int two = Integer.valueOf(s.substring(i-2,i));
            if (two<=26)
                dp[i]+=dp[i-2];
        }
        return dp[s.length()];
    }
    /*递归解法,时间复杂度o(n^2)，空间复杂度o(n)
    * 以102213为例子
    * 有两种选择，取一个/两个
    * num("102213") = num("02213")->=0 +num("2213")
    * num("2213") = num("213")+num("13")
    * 注意取两个的时候判断是否小于26
    * */

    public int numberToStringRecursion(String s){
        if(s.charAt(0)=='0')
            return 0;
        if(s.length()==0 || s.length()==1)
            return 1;
        return numberToString(s.substring(1,s.length()))+(Integer.parseInt(s.substring(0,2))<=26?numberToString(s.substring(2,s.length())):0);
    }

    public static void main(String[] args) {
        数字翻译成字符串NumberToString ins = new 数字翻译成字符串NumberToString();
        System.out.println(ins.numberToString("989285698561298123597619751326989285698561298123597619751326"));
        System.out.println(ins.numberToStringRecursion("989285698561298123597619751326989285698561298123597619751326"));

    }
}
