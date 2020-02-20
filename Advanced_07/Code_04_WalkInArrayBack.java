package Advanced_07;

public class Code_04_WalkInArrayBack {
    //total position 1~n
    //curPosition:current position
    //restStep:steps you you can move
    //K:aim position
    public static int ways(int N, int curPosition, int restStep, int K) {
        if (curPosition > N || restStep < 0 || K > N || curPosition < 1 || N < 2) {
            return 0;
        }
        if (restStep == 0) {
            return curPosition == K ? 1 : 0;
        }
        int res = 0;
        if (curPosition == 1) {
            res += ways(N, curPosition + 1, restStep - 1, K);
        } else if (curPosition == N) {
            res += ways(N, curPosition - 1, restStep - 1, K);
        } else {
            res += ways(N, curPosition + 1, restStep - 1, K) + ways(N, curPosition - 1, restStep - 1, K);
        }
        return res;
    }
}
