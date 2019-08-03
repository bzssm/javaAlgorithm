import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 数组中最大的K个数TopKInArray {
    /*
    * 1.用小顶堆找最大数，如果下一个元素比小顶堆最小值大，就放进来*/

    public ArrayList<Integer> topKByMinHeap(int[] nums,int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            minHeap.add(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            if (nums[i]>minHeap.peek()){
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return new ArrayList<>(minHeap);
    }

    //2.快速排序法
    public ArrayList<Integer> topKByQuickSort(int[] nums, int k){
        int pivot = nums[0];
        ArrayList<Integer> prefix = new ArrayList<>();
        ArrayList<Integer> postfix = new ArrayList<>();
        for (int i=1;i<nums.length;i++){
            if (nums[i]<=pivot)
                prefix.add(nums[i]);
            else
                postfix.add(nums[i]);
        }
        if (prefix.size() == k)
            return prefix;
        if (prefix.size()>k)
            return topKByQuickSort(prefix.stream().mapToInt(Integer::valueOf).toArray(), k);
        else{
            postfix.add(pivot);
            prefix.addAll(topKByQuickSort(postfix.stream().mapToInt(Integer::valueOf).toArray(), k-prefix.size()));
            return prefix;
        }
    }

    public static void main(String[] args) {
        数组中最大的K个数TopKInArray ins = new 数组中最大的K个数TopKInArray();
        System.out.println(ins.topKByMinHeap(new int[]{1,5,2,5,6,2,3,6,1,2,3,67,8,43,8}, 4));
        int[] s = new int[]{1,5,2,5,6,2,3,6,1,2,3,67,8,43,8};
        s = new int[]{9,3,2,7,8,4,1,6};
        ins.topKByQuickSort(s, 4);


    }
}
