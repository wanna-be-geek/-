package Advanced_02;

import java.util.LinkedList;

public class Code_02_SlidingWindowGetMax {
    public static int[] getMaxWindow(int[] arr,int w){
        if (arr==null||w<1||arr.length<w){
            return null;
        }
        LinkedList<Integer> qmax=new LinkedList<>();
        int[] res=new int[arr.length-w+1];
        int index=0;
        for (int i=0;i<arr.length;i++){
            while (!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst()==i-w){
                qmax.pollFirst();
            }
            if (i>w-1){
                res[index++]=arr[qmax.peekFirst()];
            }
        }
        return res;
    }
    public static void printArray(int[] arr){
        for (int i=0;i!=arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr={2,2,9,5,4,6,7,3};
        printArray(getMaxWindow(arr,3));
    }
}
