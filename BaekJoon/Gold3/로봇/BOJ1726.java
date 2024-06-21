package BaekJoon.Gold3.로봇;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1726 {

    static class Robot{
        int x;
        int y;
        int d;
        int cnt;

        public Robot(int x, int y, int d, int cnt) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.cnt = cnt;
        }
    }

    static int M, N;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][][] visited;
    static Robot start;
    static Robot fin;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N][4];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        start = new Robot(x - 1, y - 1, d - 1, 0);
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        fin = new Robot(x - 1, y - 1, d - 1, 0);

        Queue<Robot> q = new LinkedList<>();
        visited[start.x][start.y][start.d] = true;
        q.add(start);

        while (!q.isEmpty()) {
            Robot cur = q.poll();
            if (cur.x == fin.x && cur.y == fin.y && cur.d == fin.d) {
                System.out.println(cur.cnt);
                return;
            }

            for (int i = 1; i <= 3; i++) {
                int nx = cur.x + dx[cur.d] * i;
                int ny = cur.y + dy[cur.d] * i;
                if (isAvailable(nx, ny) && !visited[nx][ny][cur.d]) {
                    if (map[nx][ny] == 0) {
                        visited[nx][ny][cur.d] = true;
                        q.add(new Robot(nx, ny, cur.d, cur.cnt + 1));
                    } else {
                        break;
                    }
                }
            }
            int n1, n2;
            if (cur.d == 0 || cur.d == 1) {
                n1 = 2;
                n2 = 3;
            } else{
                n1 = 0;
                n2 = 1;
            }
            if (!visited[cur.x][cur.y][n1]) {
                visited[cur.x][cur.y][n1] = true;
                q.add(new Robot(cur.x, cur.y, n1, cur.cnt + 1));
            }

            if (!visited[cur.x][cur.y][n2]) {
                visited[cur.x][cur.y][n2] = true;
                q.add(new Robot(cur.x, cur.y, n2, cur.cnt + 1));
            }
        }
    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }

    public static void main(String[] args) throws IOException {
        BOJ1726.solution();
    }
}
