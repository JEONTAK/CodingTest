package BaekJoon.Gold5.링크와스타트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15661 {

    static int N;
    static int[][] overall;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static int t;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        overall = new int[N][N];
        visited = new boolean[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                overall[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (t = 1; t < N; t++) {
            compute(0,0);
        }
        System.out.println(min);
    }

    static void compute(int teamCnt, int idx) {
        if (teamCnt == t) {
            min = Math.min(min, sumOverall());
            if (min == 0) {
                System.out.println(min);
                System.exit(0);
            }
            return;
        }
        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                compute(teamCnt + 1, i + 1);
                visited[i] = false;
            }

        }

    }
    static int sumOverall(){
        int startTeam = 0;
        int linkTeam = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if(visited[i] && visited[j]){
                    startTeam += overall[i][j] + overall[j][i];
                } else if (!visited[i] && !visited[j]) {
                    linkTeam += overall[i][j] + overall[j][i];
                }
            }
        }
        return Math.abs(startTeam - linkTeam);
    }
    public static void main(String[] args) throws IOException {
        BOJ15661.solution();
    }
}
