package BaekJoon.Gold4.가장긴바이토닉부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11054 {

    static int N;
    static int[] seq;
    static int[] left, right, result;


    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        seq = new int[N];
        left = new int[N];
        right = new int[N];
        result = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            right[i] = 1;
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i] && right[i] < right[j] + 1) {
                    right[i] = right[j] + 1;
                }
            }
        }
        for (int i = N - 1; i >= 0; i--) {
            left[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (seq[j] < seq[i] && left[i] < left[j] + 1) {
                    left[i] = left[j] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, (left[i] + right[i]));
        }
        System.out.println(max - 1);
    }

    public static void main(String[] args) throws IOException {
        BOJ11054.solution();
    }
}
