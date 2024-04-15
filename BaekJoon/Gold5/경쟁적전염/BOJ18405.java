package BaekJoon.Gold5.경쟁적전염;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ18405 {

    static class Location implements Comparable<Location>{
        int x;
        int y;
        int time;
        int virus;

        public Location(int x, int y, int time, int virus) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.virus = virus;
        }

        @Override
        public int compareTo(Location o) {
            return this.virus - o.virus;
        }
    }

    static int N, K;
    static int x, y, time;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<Location> q = new LinkedList<>();

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        ArrayList<Location> locations = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int virus = Integer.parseInt(st.nextToken());
                if (virus != 0) {
                    locations.add(new Location(i,j,0,virus));
                }
                map[i][j] = virus;
            }
        }
        Collections.sort(locations);
        for (Location location : locations) {
            q.add(location);
        }
        st = new StringTokenizer(br.readLine());
        time = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        compute();
        System.out.println(map[x - 1][y - 1]);
    }
    static void compute(){
        while (!q.isEmpty()) {
            Location loc = q.poll();
            if (loc.time == time) {
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = loc.x + dx[i];
                int ny = loc.y + dy[i];
                if (isAvailable(nx, ny)) {
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = loc.virus;
                        q.add(new Location(nx,ny,loc.time + 1, loc.virus));
                    }
                }
            }
        }
    }
    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static void main(String[] args) throws IOException {
        BOJ18405.solution();
    }
}
