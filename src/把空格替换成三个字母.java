public class 把空格替换成三个字母 {
    public static void main(String[] args) {
        把空格替换成三个字母 ins = new 把空格替换成三个字母();
        System.out.println(ins.replaceSpace("A B"));
    }

    /*
     *Input:
     *"A B"
     *
     *Output:
     *"A%20B"
     *
     *
     *
     *
     */
    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }
}
