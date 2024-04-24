package BaekJoon.Gold5.소트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1083 {

    static int N, S;
    static int[] seq;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        seq = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        S = Integer.parseInt(br.readLine());

        for (int i = 0; i < N && S > 0; i++) {
            int max = seq[i];
            int idx = -1;
            for (int j = i + 1; j < N && j <= i + S; j++) {
                if (seq[j] > max) {
                    max = seq[j];
                    idx = j;
                }
            }
            if(idx == -1) continue;
            S -= idx - i;
            for (int j = idx; j >= i + 1; j--) {
                int temp = seq[j];
                seq[j] = seq[j - 1];
                seq[j - 1] = temp;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(seq[i] + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ1083.solution();
    }
}
