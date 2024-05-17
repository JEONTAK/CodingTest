package BaekJoon.Gold3.불;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ4179 {

    static class Location implements Comparable<Location>{
        int x;
        int y;
        int t;
        int JF;

        public Location(int x, int y, int t, int JF) {
            this.x = x;
            this.y = y;
            this.t = t;
            this.JF = JF;
        }

        @Override
        public int compareTo(Location o) {
            if (this.t == o.t) {
                return this.JF - o.JF;
            }
            return this.t - o.t;
        }
    }
    static int R, C;
    static char[][] maze;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] fire, visited;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Location> pq = new PriorityQueue<>();
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        maze = new char[R][C];
        fire = new boolean[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                maze[i][j] = temp.charAt(j);
                if(maze[i][j] == 'J'){
                    pq.add(new Location(i, j, 0, 0));
                    visited[i][j] = true;
                } else if (maze[i][j] == 'F') {
                    pq.add(new Location(i, j, 0, 1));
                    fire[i][j] = true;
                } else if (maze[i][j] == '#') {
                    fire[i][j] = true;
                }
            }
        }

        while (!pq.isEmpty()) {
            Location cur = pq.poll();
            if (cur.JF == 0 && fire[cur.x][cur.y])continue;
            if (cur.x == 0 || cur.x == R - 1 || cur.y == 0 || cur.y == C - 1) {
                if (cur.JF == 0) {
                    System.out.println(cur.t + 1);
                    System.exit(0);
                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (cur.JF == 0) {
                    if (isAvailable(nx, ny) && !visited[nx][ny] && !fire[nx][ny]) {
                        visited[nx][ny] = true;
                        pq.add(new Location(nx, ny, cur.t + 1, cur.JF));
                    }
                }else {
                    if (isAvailable(nx, ny) && !fire[nx][ny]) {
                        fire[nx][ny] = true;
                        pq.add(new Location(nx, ny, cur.t + 1, cur.JF));
                    }
                }

            }
        }
        System.out.println("IMPOSSIBLE");
    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    public static void main(String[] args) throws IOException {
        BOJ4179.solution();
    }
}
