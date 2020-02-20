package Advanced_01;

public class Code_01_KMP {
    public static int getIndexOf(String s,String m){
        if (s==null||m==null||m.length()<1||s.length()<m.length()){
            return -1;
        }
        char[] str1=s.toCharArray();
        char[] str2=m.toCharArray();
        int si=0;
        int mi=0;
        int[] next=getNextArray(str2);
        while (si<str1.length&&mi<str2.length){
            if(str1[si]==str2[mi]){
                si++;
                mi++;
            }else if (next[mi]==-1){
                si++;
            }else {
                mi=next[mi];
            }
        }
        return  mi==str2.length?si-mi:-1;
    }


    public static int[] getNextArray(char[] ms){
        if (ms.length==1){
            return new int[]{-1};
        }
        int[] next=new int[ms.length];
        next[0]=-1;
        next[1]=0;
        int pos=2;
        int cn=0;
        while (pos<next.length){
            if (ms[pos-1]==ms[cn]){
                next[pos++]=++cn;
            }else if (cn>0){
                cn=next[cn];
            }else {
                next[pos++]=0;
            }
        }
        return next;
    }
    public static void main(String[] args) {
        String str = "abcabcababaccc";
        String match = "ababa";
        System.out.println(getIndexOf(str, match));

    }

}
