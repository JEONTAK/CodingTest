package BaekJoon.Gold4.불;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ5427 {

    static class Location implements Comparable<Location>{
        int x;
        int y;
        int t;
        int SF;

        public Location(int x, int y, int t, int SF) {
            this.x = x;
            this.y = y;
            this.t = t;
            this.SF = SF;
        }

        @Override
        public int compareTo(Location o) {
            if (this.t == o.t) {
                return this.SF - o.SF;
            }
            return this.t - o.t;
        }
    }

    static int T, W, H;
    static char[][] map;
    static boolean[][] fire, visited;
    static boolean flag;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            PriorityQueue<Location> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[W][H];
            fire = new boolean[W][H];
            visited = new boolean[W][H];
            flag = false;
            for (int j = 0; j < W; j++) {
                String temp = br.readLine();
                for (int k = 0; k < H; k++) {
                    map[j][k] = temp.charAt(k);
                    if (map[j][k] == '@') {
                        pq.add(new Location(j, k, 0, 1));
                    } else if (map[j][k] == '*') {
                        pq.add(new Location(j, k, 0, 0));
                    } else if (map[j][k] == '#') {
                        visited[j][k] = true;
                        fire[j][k] = true;
                    }
                }
            }
            while (!pq.isEmpty()) {
                Location cur = pq.poll();
                if (cur.SF == 1 && !fire[cur.x][cur.y]) {
                    if (cur.x == 0 || cur.x == W - 1 || cur.y == 0 || cur.y == H - 1) {
                        System.out.println(cur.t + 1);
                        flag = true;
                        break;
                    }
                    if(visited[cur.x][cur.y])continue;
                    if(fire[cur.x][cur.y])continue;
                    visited[cur.x][cur.y] = true;
                } else{
                    if(fire[cur.x][cur.y]) continue;
                    fire[cur.x][cur.y] = true;
                }
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    if (cur.SF == 1) {
                        if (isAvailable(nx, ny) && !visited[nx][ny] && !fire[nx][ny]) {
                            pq.add(new Location(nx, ny, cur.t + 1, cur.SF));
                        }
                    }else{
                        if (isAvailable(nx, ny) && !fire[nx][ny]) {
                            pq.add(new Location(nx, ny, cur.t + 1, cur.SF));
                        }
                    }
                }
            }
            if (!flag) {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < W && y >= 0 && y < H;
    }

    public static void main(String[] args) throws IOException {
        BOJ5427.solution();
    }
}
