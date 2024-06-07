package BaekJoon.Gold3.벽부수고이동하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206 {

    static class Location implements Comparable<Location>{
        int x;
        int y;
        int t;
        int wall;

        public Location(int x, int y, int t, int wall) {
            this.x = x;
            this.y = y;
            this.t = t;
            this.wall = wall;
        }

        @Override
        public int compareTo(Location o) {
            return this.t - o.t;
        }
    }
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int result = Integer.MAX_VALUE;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
            }
        }
        visited = new boolean[N][M][2];

        PriorityQueue<Location> q = new PriorityQueue<>();
        q.add(new Location(0, 0, 0, 0));

        while (!q.isEmpty()) {
            Location cur = q.poll();
            if (cur.x == N - 1 && cur.y == M - 1) {
                System.out.println(cur.t + 1);
                System.exit(0);
            }
            if(visited[cur.x][cur.y][cur.wall]) continue;
            visited[cur.x][cur.y][cur.wall] = true;
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (isAvailable(nx, ny) && !visited[nx][ny][cur.wall]) {
                    if (map[nx][ny] == 1) {
                        if (cur.wall == 0) {
                            q.offer(new Location(nx, ny, cur.t + 1, 1));
                        }
                    }else{
                        q.offer(new Location(nx, ny, cur.t + 1, cur.wall));
                    }
                }
            }
        }
        System.out.println(-1);
    }


    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static void main(String[] args) throws IOException {
        BOJ2206.solution();
    }
}
