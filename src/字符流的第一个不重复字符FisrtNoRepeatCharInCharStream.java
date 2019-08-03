import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class 字符流的第一个不重复字符FisrtNoRepeatCharInCharStream {
    Queue<Character> queue = new LinkedList<>();
    HashMap<Character,Integer> count = new HashMap<>();
    public void insert(char ch){
        if(count.containsKey(ch)){
            count.put(ch, count.get(ch)+1);
        }else{
            count.put(ch, 1);
            queue.add(ch);
        }
    }

    public char getFirstNoRepeatChar(){
        while(!queue.isEmpty()){
            if (count.get(queue.peek())==1){
                return queue.poll();
            }
            else{
                queue.poll();
            }
        }
        return '#';
    }

    public static void main(String[] args) {
        字符流的第一个不重复字符FisrtNoRepeatCharInCharStream ins = new 字符流的第一个不重复字符FisrtNoRepeatCharInCharStream();
        char[] chs = {'g','o','o','g','l','e'};
        for(char c:chs)
            ins.insert(c);
        System.out.println(ins.getFirstNoRepeatChar());
    }
}
