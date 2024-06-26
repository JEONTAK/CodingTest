package BaekJoon.Gold4.치즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2636 {

    static class Cheese{
        int x;
        int y;

        public Cheese(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] map;
    static int c;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        c = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1)c++;
            }
        }
        int cNum = 0;
        int t = 0;
        while (c != 0) {
            cNum = c;
            t++;
            compute();
        }
        System.out.println(t);
        System.out.println(cNum);
    }
    static void compute(){
        Queue<Cheese> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;
        q.add(new Cheese(0, 0));
        while (!q.isEmpty()) {
            Cheese cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (isAvailable(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (map[nx][ny] == 0) {
                        q.offer(new Cheese(nx, ny));
                    }else{
                        c--;
                        map[nx][ny] = 0;
                    }
                }
            }
        }
    }
    static boolean isAvailable(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
    public static void main(String[] args) throws IOException {
        BOJ2636.solution();
    }
}
