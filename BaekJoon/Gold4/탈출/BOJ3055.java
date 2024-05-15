package BaekJoon.Gold4.탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ3055 {

    static class Location implements Comparable<Location>{
        int x;
        int y;
        int t;
        int DW;

        public Location(int x, int y, int t, int DW) {
            this.x = x;
            this.y = y;
            this.t = t;
            this.DW = DW;
        }

        @Override
        public int compareTo(Location o) {
            if (this.t == o.t) {
                return this.DW - o.DW;
            }
            return this.t - o.t;
        }
    }

    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};


    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Location> pq = new PriorityQueue<>();
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = temp.charAt(j);
                if(map[i][j] == 'S'){
                    pq.add(new Location(i, j, 0, 1));
                }else if(map[i][j] == '*'){
                    pq.add(new Location(i, j, 0, 0));
                } else if (map[i][j] == 'X') {
                    visited[i][j] = true;
                }
            }
        }

        while (!pq.isEmpty()) {
            Location cur = pq.poll();
            if (cur.DW == 1 && map[cur.x][cur.y] == 'D') {
                System.out.println(cur.t);
                System.exit(0);
            }

            if(visited[cur.x][cur.y]) continue;
            visited[cur.x][cur.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (isAvailable(nx, ny) && !visited[nx][ny]) {
                    if(cur.DW == 0){
                        if (map[nx][ny] != 'D') {
                            pq.add(new Location(nx, ny, cur.t + 1, cur.DW));
                        }
                    }else{
                        pq.add(new Location(nx, ny, cur.t + 1, cur.DW));
                    }
                }
            }
        }
        System.out.println("KAKTUS");
    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    public static void main(String[] args) throws IOException {
        BOJ3055.solution();
    }
}
