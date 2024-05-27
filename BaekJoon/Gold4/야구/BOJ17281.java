package BaekJoon.Gold4.야구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17281 {

    static int N;
    static final int pN = 9;
    static int[] player;
    static int[][] inning;
    static boolean[] visited;
    static boolean[] base;
    static int maxScore = 0;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inning = new int[N + 1][pN + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= pN; j++) {
                inning[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        player = new int[pN + 1];
        visited = new boolean[pN + 1];
        base = new boolean[4];
        player[4] = 1;
        visited[4] = true;
        compute(2);
        System.out.println(maxScore);
    }

    static void compute(int idx) {
        if (idx == 10) {
            calScore();
            return;
        }

        for (int i = 1; i <= pN; i++) {
            if (!visited[i]) {
                visited[i] = true;
                player[i] = idx;
                compute(idx + 1);
                player[i] = 0;
                visited[i] = false;
            }
        }
    }

    static void calScore() {
        int cur = 1;
        int score = 0;
        for (int i = 1; i <= N; i++) {
            int out = 0;
            for (int j = 1; j <= 3; j++) {
                base[j] = false;
            }
            while (true) {
                if (inning[i][player[cur]] == 0) {
                    out++;
                }else{
                    score += hit(inning[i][player[cur]]);
                }
                cur = cur % 9 + 1;
                if (out == 3) {
                    break;
                }
            }
        }
        maxScore = Math.max(maxScore, score);
    }

    static int hit(int d) {
        int s = 0;
        if (d == 4) {
            for (int i = 1; i <= 3; i++) {
                if (base[i]) {
                    s++;
                    base[i] = false;
                }
            }
            s++;
        }else{
            for (int i = 3; i >= 1; i--) {
                if (base[i]) {
                    if (i + d >= 4) {
                        base[i] = false;
                        s++;
                    }else{
                        base[i] = false;
                        base[i + d] = true;
                    }
                }
            }
            base[d] = true;
        }
        return s;
    }

    public static void main(String[] args) throws IOException {
        BOJ17281.solution();
    }
}
