package BaekJoon.Gold4.미로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ2665 {

    static class Location implements Comparable<Location>{
        int x;
        int y;
        int c;

        public Location(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }

        @Override
        public int compareTo(Location o) {
            return this.c - o.c;
        }
    }

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
            }
        }
        PriorityQueue<Location> pq = new PriorityQueue<>();
        pq.add(new Location(0, 0, 0));
        while (!pq.isEmpty()) {
            Location cur = pq.poll();

            if (cur.x == N - 1 && cur.y == N - 1) {
                System.out.println(cur.c);
                System.exit(0);
            }

            if(visited[cur.x][cur.y]) continue;
            visited[cur.x][cur.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (isAvailable(nx, ny) && !visited[nx][ny]) {
                    if (map[nx][ny] == 0) {
                        pq.add(new Location(nx, ny, cur.c + 1));
                    }else{
                        pq.add(new Location(nx, ny, cur.c));
                    }
                }
            }

        }
    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static void main(String[] args) throws IOException {
        BOJ2665.solution();
    }
}
