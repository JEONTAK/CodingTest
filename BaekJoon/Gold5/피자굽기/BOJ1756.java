package BaekJoon.Gold5.피자굽기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1756 {

    static int D, N, curLoc;
    static int[] oven;
    static int dough;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        if (D < N) {
            System.out.println(0);
        }else{
            oven = new int[D + 1];
            oven[0] = Integer.MAX_VALUE;
            curLoc = D;
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= D; i++) {
                oven[i] = Integer.parseInt(st.nextToken());
                oven[i] = Math.min(oven[i - 1], oven[i]);
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                dough =  Integer.parseInt(st.nextToken());
                curLoc = compute(dough);
                if (curLoc < N - i) {
                    curLoc = 0;
                    break;
                }
            }
            System.out.println(curLoc);
        }
    }
    static int compute(int d){
        for (int i = curLoc; i >= 1; i--) {
            if (d <= oven[i]) {
                curLoc = i;
                oven[i] = 0;
                return curLoc;
            }
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BOJ1756.solution();
    }
}
