package BaekJoon.Gold4.알고스팟;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1261 {

    static class Loc implements Comparable<Loc> {
        int x;
        int y;
        int b;

        public Loc(int x, int y, int b) {
            this.x = x;
            this.y = y;
            this.b = b;
        }

        @Override
        public int compareTo(Loc o) {
            return this.b - o.b;
        }
    }

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map= new int[N][M];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        PriorityQueue<Loc> pq = new PriorityQueue<>();
        pq.add(new Loc(0, 0, 0));
        visited = new boolean[N][M];
        while (!pq.isEmpty()) {
            Loc cur = pq.poll();
            if (cur.x == N - 1 && cur.y == M - 1) {
                System.out.println(cur.b);
                System.exit(0);
            }
            if(visited[cur.x][cur.y]) continue;
            visited[cur.x][cur.y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (isAvailable(nx, ny) && !visited[nx][ny]) {
                    if (map[nx][ny] == 1) {
                        pq.add(new Loc(nx, ny, cur.b + 1));
                    }else{
                        pq.add(new Loc(nx, ny, cur.b));
                    }
                }
            }
        }
    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    public static void main(String[] args) throws IOException {
        BOJ1261.solution();
    }
}
