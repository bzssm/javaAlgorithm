import java.util.ArrayList;
import java.util.Collections;

public class 字符串的所有排列可能Permutation {
    /*
    * 字符串的排列，是通过交换第一个字符和之后的每个字符实现
    * 123->交换12->213
    * 123->交换13->321
    * ...
    *
    * */
    public ArrayList<String> res = new ArrayList<>();

    public ArrayList<String> permutation(String s, int begin){
        if (begin+1 == s.length()){
            if (!res.contains(s)) {
                res.add(s);
            }
        }

        else {
            for (int i = 0; i < s.length(); i++) {
                s = swap(s, i, begin);

                permutation(s, begin + 1);
                s = swap(s, i, begin);
            }
        }
        Collections.sort(res);
        return res;
    }

    public String swap(String s, int p1, int p2){
        char[] c = s.toCharArray();
        char temp = c[p1];
        c[p1] = c[p2];
        c[p2] = temp;
        return String.valueOf(c);

    }

    /*
    * 递归实现
    * */

    public ArrayList<String> permutation(String s){
        backtracking(s.toCharArray(), new boolean[s.length()], new StringBuilder());
        return res;
    }

    public void backtracking(char[] chars, boolean[] hasUsed, StringBuilder s){
        if(s.length() == chars.length){
            res.add(s.toString());
            return;
        }
        for(int i=0; i<chars.length; i++){
            if (hasUsed[i])
                continue;

            s.append(chars[i]);
            hasUsed[i] = true;
            //hasUsed[i] = false;
            //上面这句可以控制每个字符是不是可以使用多次
            backtracking(chars, hasUsed, s);
            s.deleteCharAt(s.length()-1);
            hasUsed[i]=false;
        }
    }

    public static void main(String[] args) {
        字符串的所有排列可能Permutation ins = new 字符串的所有排列可能Permutation();
        System.out.println(ins.permutation("abc"));
    }
}
