package BaekJoon.Gold3.아기상어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16236 {

    static class Shark{
        int x;
        int y;
        int d;

        public Shark(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static int N, cX, cY, dist;
    static int size = 2, eat = 0, result = 0;
    static int [][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    cX = i;
                    cY = j;
                    map[i][j] = 0;
                }
            }
        }
        while (compute()) {
            result += dist;
        }
        System.out.println(result);
    }

    static boolean compute() {
        dist = 0;
        if (eat == size) {
            eat = 0;
            size++;
        }
        visited = new boolean[N][N];
        Queue<Shark> q = new LinkedList<>();
        q.offer(new Shark(cX, cY, 0));
        visited[cX][cY] = true;
        int nX, nY, nD;
        nX = Integer.MAX_VALUE;
        nY = Integer.MAX_VALUE;
        nD = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Shark cur = q.poll();
            if (cur.d >= nD) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(!isAvailable(nx,ny)) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] > size) continue;

                if (map[nx][ny] > 0 && map[nx][ny] < size) {
                    if (nx < nX) {
                        nX = nx;
                        nY = ny;
                        nD = cur.d + 1;
                    } else if (nx == nX) {
                        if (ny < nY) {
                            nY = ny;
                            nD = cur.d + 1;
                        }
                    }
                }
                q.offer(new Shark(nx, ny, cur.d + 1));
                visited[nx][ny] = true;
            }
        }
        if (nD == Integer.MAX_VALUE) {
            return false;
        }else{
            cX = nX;
            cY = nY;
            eat++;
            dist = nD;
            map[cX][cY] = 0;
            return true;
        }
    }
    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
    public static void main(String[] args) throws IOException {
        BOJ16236.solution();
    }
}
