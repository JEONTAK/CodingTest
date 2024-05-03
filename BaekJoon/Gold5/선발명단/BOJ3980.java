package BaekJoon.Gold5.선발명단;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3980 {

    static int T;
    static final int Mem = 11;
    static int player[][];
    static boolean[] visited;
    static int max;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st;
            player = new int[Mem][Mem];
            for (int j = 0; j < Mem; j++) {
              st = new StringTokenizer(br.readLine());
                for (int k = 0; k < Mem; k++) {
                    player[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            max = Integer.MIN_VALUE;
            visited = new boolean[Mem];
            compute(0,0);
            System.out.println(max);
        }
    }

    static void compute(int idx, int value) {
        if (idx == Mem) {
            max = Math.max(max,value);
            return;
        }

        for (int i = 0; i < Mem; i++) {
            if (player[idx][i] > 0 && !visited[i]) {
                visited[i] = true;
                compute(idx + 1, value + player[idx][i]);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ3980.solution();
    }
}
