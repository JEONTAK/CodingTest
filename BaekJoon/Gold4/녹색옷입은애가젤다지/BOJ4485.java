package BaekJoon.Gold4.녹색옷입은애가젤다지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ4485 {
    static class Link implements Comparable<Link>{
        int x;
        int y;
        int d;

        public Link(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }

        @Override
        public int compareTo(Link o) {
            return this.d - o.d;
        }
    }
    static int N, idx = 1;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        while (N != 0) {
            map = new int[N][N];
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            PriorityQueue<Link> pq = new PriorityQueue<>();
            pq.add(new Link(0, 0, map[0][0]));
            while (!pq.isEmpty()) {
                Link cur = pq.poll();
                if (cur.x == N - 1 && cur.y == N - 1) {
                    System.out.println("Problem " + idx + ": " + cur.d);
                    break;
                }
                if(visited[cur.x][cur.y]) continue;
                visited[cur.x][cur.y] = true;
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if (isAvailable(nx, ny) && !visited[nx][ny]) {
                        pq.add(new Link(nx, ny, cur.d + map[nx][ny]));
                    }
                }
            }
            N = Integer.parseInt(br.readLine());
            idx++;
        }
    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static void main(String[] args) throws IOException {
        BOJ4485.solution();
    }
}
