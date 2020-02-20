package Advanced_03;

import java.util.Stack;
//单调栈
public class Code_02_GetCirclePair {
    public static class Pair {
        public int value;
        public int times;

        public Pair(int value) {
            this.value = value;
            this.times =  1;
        }
    }

    public static long getInternalSum(int n) {
        return n == 1L ? 0L : (long) n * (long) (n - 1) / 2L;
    }

    public static int communications(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int size = arr.length;
        int maxIndex = 0;
        for (int i = 0; i < size; i++) {
            maxIndex = arr[maxIndex] < arr[i] ? i : maxIndex;
        }
        int value = arr[maxIndex];
        int index = nextIndex(size, maxIndex);
        long res = 0L;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(value));
        while (index != maxIndex) {
            value = arr[index];
            while (!stack.isEmpty()&&stack.peek().value<value){
                int times=stack.pop().times;
                res+=getInternalSum(times)+2*times;
            }
            if (!stack.isEmpty()&&stack.peek().value==value){
                stack.peek().times++;
            }else {
                stack.push(new Pair(value));
            }
            index=nextIndex(size,index);
        }
        while (!stack.isEmpty()){
            int times=stack.pop().times;
            res+=getInternalSum(times);
            if (!stack.isEmpty()){
                res+=times;
                if (stack.size()>1){
                    res+=times;
                }else {
                    res+=stack.peek().times>1?times:0;
                }
            }
        }
        return (int) res;
    }

    public static int nextIndex(int size, int i) {
        return i < size - 1 ? (i + 1) : 0;
    }

    public static void main(String[] args) {
        int[] arr={3,4,6,2,5,3,4,5};
        System.out.println(communications(arr));
    }
}
