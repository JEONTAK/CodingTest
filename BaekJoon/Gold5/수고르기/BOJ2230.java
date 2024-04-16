package BaekJoon.Gold5.수고르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2230 {

    static int N;
    static long M;
    static long[] sequence;
    static long min = Long.MAX_VALUE;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        sequence = new long[N];
        for (int i = 0; i < N; i++) {
            sequence[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(sequence);
        compute();
        System.out.println(min);
    }

    static void compute(){
        int left = 0;
        int right = 0;
        while (left < N) {
            long temp = Math.abs(sequence[left] - sequence[right]);
            if (temp < M) {
                left++;
                continue;
            }
            if (temp == M) {
                min = temp;
                break;
            }
            min = Math.min(min, temp);
            right++;
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ2230.solution();
    }
}
