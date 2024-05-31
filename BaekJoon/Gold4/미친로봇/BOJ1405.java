package BaekJoon.Gold4.미친로봇;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1405 {

    static int N;
    static double[] d;
    static boolean[][] visited;
    static double total = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = new double[4];
        for (int i = 0; i < 4; i++) {
            d[i] = Double.parseDouble(st.nextToken()) * 0.01;
        }
        visited = new boolean[N * 2 + 1][N * 2 + 1];
        visited[N][N] = true;
        compute(0, N, N, 1);
        System.out.println(total);
    }

    static void compute(int idx, int x, int y, double p){
        if (idx == N) {
            total += p;
            return;
        }
        for (int i = 0; i < 4; i++) {
            if(d[i] == 0) continue;
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                compute(idx + 1, nx, ny, p * d[i]);
                visited[nx][ny] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ1405.solution();
    }
}
