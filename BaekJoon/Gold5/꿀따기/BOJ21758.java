package BaekJoon.Gold5.꿀따기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21758 {

    static int N;
    static int[] road;
    static long honeySum = 0;
    static long max = 0;
    static long[] left;
    static long[] right;


    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        road = new int[N];
        left = new long[N];
        right = new long[N];
        for (int i = 0; i < N; i++) {
            road[i] = Integer.parseInt(st.nextToken());
            honeySum += road[i];
            right[i] = honeySum;
        }

        honeySum = 0;
        for (int i = N - 1; i >= 0; i--) {
            honeySum += road[i];
            left[i] = honeySum;
        }

        long b1, b2;

        for (int i = 1; i <= N - 2; i++) {
            b1 = honeySum - road[0] - road[i];
            b2 = honeySum - right[i];
            max = Math.max(max, b1 + b2);
        }

        for (int i = N - 2; i >= 1; i--) {
            b1 = honeySum - road[N - 1] - road[i];
            b2 = honeySum - left[i];
            max = Math.max(max, b1 + b2);
        }

        for (int i = 1; i <= N - 2; i++) {
            b1 = right[i] - road[0];
            b2 = left[i] - road[N - 1];
            max = Math.max(max, b1 + b2);
        }

        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        BOJ21758.solution();
    }
}
