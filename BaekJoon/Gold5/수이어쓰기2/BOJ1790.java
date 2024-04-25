package BaekJoon.Gold5.수이어쓰기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1790 {

    static long N, K;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        K = Long.parseLong(st.nextToken());
        long digit = 1;
        long numSet = 9;
        while (K > digit * numSet) {
            K -= (digit * numSet);
            digit++;
            numSet *= 10;
        }
        K -= 1;
        long find = (long) Math.pow(10, (digit - 1)) + (K / digit);

        if (find > N) {
            System.out.println(-1);
        }else{
            System.out.println(String.valueOf(find).charAt((int) (K % digit)));
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ1790.solution();
    }
}
