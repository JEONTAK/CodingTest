package BaekJoon.Gold5.하노이탑이동순서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11729 {


    static int N;
    static int K;
    static StringBuilder sb = new StringBuilder();
    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = (int) (Math.pow(2,N) - 1);
        sb.append(K).append("\n");

        hanoi(N, 1, 2, 3);

        System.out.println(sb);
    }

    static void hanoi(int N, int left, int mid, int right) {
        if (N == 1) {
            sb.append(left + " " + right + "\n");
            return;
        }

        hanoi(N - 1, left, right, mid);

        sb.append(left + " " + right + "\n");

        hanoi(N - 1 , mid, left, right);

    }

    public static void main(String[] args) throws IOException {
        BOJ11729.solution();
    }
}
