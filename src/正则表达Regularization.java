public class 正则表达Regularization {
    /*
     * 表示数值
     * true
     *"+100"
     *"5e2"
     *"-123"
     *"3.1416"
     *"-1E-16"
     *
     * false
     *"12e"
     *"1a3.14"
     *"1.2.3"
     *"+-5"
     *"12e+4.3"
     * */
    /*
    []  ： 字符集合
    ()  ： 分组
    ?   ： 重复 0 ~ 1 次
    +   ： 重复 1 ~ n 次
    *   ： 重复 0 ~ n 次
    .   ： 任意字符
    \\. ： 转义后的 .
    \\d ： 数字
    * */

    public boolean isNumber(String s) {
        return s.matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }


}
