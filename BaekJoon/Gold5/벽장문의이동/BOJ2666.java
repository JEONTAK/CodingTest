package BaekJoon.Gold5.벽장문의이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2666 {

    static int N, K;
    static int[] seq;
    static List<Integer> door;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        door = new ArrayList<>();
        door.add(a);
        door.add(b);
        K = Integer.parseInt(br.readLine());
        seq = new int[K];
        for (int i = 0; i < K; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(compute(0, door.get(0), door.get(1)));
    }

    static int compute(int cnt, int f, int s) {
        if (cnt == seq.length) {
            return 0;
        }

        int t1 = Math.abs(f - seq[cnt]);
        int t2 = Math.abs(s - seq[cnt]);

        return Math.min(t1 + compute(cnt + 1, s, seq[cnt]), t2 + compute(cnt + 1, f, seq[cnt]));
    }

    public static void main(String[] args) throws IOException {
        BOJ2666.solution();
    }
}
