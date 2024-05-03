package BaekJoon.Gold5.수나누기게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ27172 {

    static int N;
    static final int MAX = 1_000_001;
    static int[] player, score, selected;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        player = new int[N];
        selected = new int[MAX];
        score = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            player[i] = Integer.parseInt(st.nextToken());
            selected[player[i]] = i + 1;
        }
        compute();

        for (int i = 1; i <= N; i++) {
            System.out.print(score[i] + " ");
        }
    }

    static void compute(){
        for (int i = 0; i < N; i++) {
            int start = player[i];
            for (int j = start * 2; j < MAX; j += start) {
                if (selected[j] > 0) {
                    score[selected[j]] -= 1;
                    score[selected[start]] += 1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BOJ27172.solution();
    }
}
