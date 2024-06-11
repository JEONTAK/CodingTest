package BaekJoon.Gold3.나머지합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10986 {

    static int N, M;
    static long result = 0;
    static long[] S;
    static long[] cnt;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = new long[N + 1];
        cnt = new long[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            S[i] = (S[i - 1] + Integer.parseInt(st.nextToken())) % M;
            if (S[i] == 0) {
                result++;
            }
            cnt[(int)S[i]]++;
        }

        for (int i = 0; i < M; i++) {
            if (cnt[i] > 1) {
                result += (cnt[i] * (cnt[i] - 1) / 2);
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        BOJ10986.solution();
    }
}
