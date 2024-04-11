package BaekJoon.Gold5.하노이탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ1914 {

    static int N;
    static BigInteger K;
    static StringBuilder sb = new StringBuilder();
    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = new BigInteger("2");
        sb.append(K.pow(N).subtract(new BigInteger("1"))).append("\n");
        if (N <= 20) {
            hanoi(N,1,2,3);
        }
        System.out.print(sb);
    }

    static void hanoi(int N, int left, int mid, int right){
        if (N == 1) {
            sb.append(left + " " + right + "\n");
            return;
        }
        hanoi(N - 1, left, right, mid);

        sb.append(left + " " + right + "\n");

        hanoi(N - 1, mid, left, right);
    }

    public static void main(String[] args) throws IOException {
        BOJ1914.solution();
    }
}
