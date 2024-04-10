package BaekJoon.Gold5.보물섬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2589 {

    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int result = 0;

    static class Location{
        int x;
        int y;
        int time;

        public Location(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    visited = new boolean[N][M];
                    int val = compute(i, j);
                    result = Math.max(result, val);
                }
            }
        }

        System.out.println(result);
    }

    static int compute(int x, int y) {
        Queue<Location> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new Location(x, y, 0));
        int val = 0;
        while (!queue.isEmpty()) {
            Location location = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nX = location.x + dx[i];
                int nY = location.y + dy[i];
                if (isAvailable(nX, nY) && !visited[nX][nY] && map[nX][nY] == 'L') {
                    visited[nX][nY] = true;
                    queue.offer(new Location(nX, nY, location.time + 1));
                    val = Math.max(val, location.time + 1);
                }
            }
        }
        return val;
    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static void main(String[] args) throws IOException {
        BOJ2589.solution();
    }
}
