package Advanced_02;

import java.util.LinkedList;

//O(N   )
public class Code_03_ALLLessNUmSubArray {
    public static int getNum(int[] arr,int num){
        if (arr==null||arr.length==0){
            return 0;
        }
        LinkedList<Integer> qmin=new LinkedList<>();
        LinkedList<Integer> qmax=new LinkedList<>();
        int L=0;
        int R=0;
        int res=0;
        while (L<arr.length){
            while (R<arr.length){
                while (!qmin.isEmpty()&&arr[qmin.peekLast()]>=arr[R]){
                    qmin.pollLast();
                }
                qmin.addLast(R);
                while (!qmax.isEmpty()&&arr[qmax.peekLast()]<arr[R]){
                    qmax.pollLast();
                }
                qmax.addLast(R);
                if (arr[qmax.getFirst()]-arr[qmin.getFirst()]>num){
                    break;
                }
            }
            if (qmin.peekFirst()==L){
                qmin.pollFirst();
            }
            if (qmax.peekFirst()==L){
                qmax.pollFirst();
            }
            res=R-L;
            L++;
        }
        return res;
    }
}
