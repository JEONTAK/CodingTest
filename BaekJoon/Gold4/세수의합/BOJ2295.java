package BaekJoon.Gold4.세수의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class BOJ2295 {

    static int N;
    static int[] num;
    static HashSet<Integer> numbers = new HashSet<>();
    static int max = 0;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                numbers.add(num[i] + num[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int t = num[i] - num[j];
                if (numbers.contains(t)) {
                    max = Math.max(max, num[i]);
                }
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        BOJ2295.solution();
    }
}
