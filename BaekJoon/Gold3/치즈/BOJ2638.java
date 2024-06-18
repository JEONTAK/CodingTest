package BaekJoon.Gold3.치즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2638 {

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] map;
    static int cheese = 0;
    static int t = 0;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cheese++;
                }
            }
        }

        while (cheese > 0) {
            cheese = compute();
            t++;
        }
        System.out.println(t);
    }

    static int compute(){
        int c = cheese;
        visited = new boolean[N][M];
        Queue<Node> q = new LinkedList<>();
        visited[0][0] = true;
        q.offer(new Node(0, 0));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (isAvailable(nx, ny) && !visited[nx][ny]) {
                    if (map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        q.offer(new Node(nx, ny));
                    } else if (map[nx][ny] == 3) {
                        visited[nx][ny] = true;
                        map[nx][ny] = 0;
                        c--;
                    } else{
                        map[nx][ny]++;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 3) {
                    c--;
                    map[i][j] = 0;
                } else if (map[i][j] > 1) {
                    map[i][j] = 1;
                }
            }
        }

        return c;
    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static void main(String[] args) throws IOException {
        BOJ2638.solution();
    }
}
