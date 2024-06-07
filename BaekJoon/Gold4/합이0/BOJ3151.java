package BaekJoon.Gold4.합이0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3151 {

    static int N;
    static int[] student;
    static long[] sum;
    static long result = 0;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        student = new int[N];
        for (int i = 0; i < N; i++) {
            student[i] = Integer.parseInt(st.nextToken());
        }
        sum = new long[40001];
        for (int i = 0; i < N; i++) {
            result += sum[20000 - student[i]];
            for (int j = 0; j < i; j++) {
                sum[20000 + student[i] + student[j]]++;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        BOJ3151.solution();
    }
}
