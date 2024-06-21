package BaekJoon.Gold3.오등큰수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17299 {

    static int N;
    static int[] seq;
    static int[] cnt;
    static int[] result;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        seq = new int[N];
        cnt = new int[1_000_001];
        result = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            seq[i] = cur;
            cnt[cur]++;
        }

        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < N; i++) {
            while (!s.isEmpty() && cnt[seq[i]] > cnt[seq[s.peek()]]) {
                result[s.pop()] = seq[i];
            }
            s.push(i);
        }

        while (!s.isEmpty()) {
            result[s.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i] + " ");
        }
        System.out.println(sb.toString());

    }

    public static void main(String[] args) throws IOException {
        BOJ17299.solution();
    }
}
