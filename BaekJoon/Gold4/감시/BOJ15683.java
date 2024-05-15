package BaekJoon.Gold4.감시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15683 {

    static class CCTV{
        int x;
        int y;
        int c;
        int d;

        public CCTV(int x, int y, int c, int d) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.d = d;
        }
    }

    static int N, M, C;
    static int[][] map;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static ArrayList<CCTV> list = new ArrayList<>();
    static int min = Integer.MAX_VALUE;

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
                if (map[i][j] != 0 && map[i][j] != 6) {
                    list.add(new CCTV(i, j, map[i][j], 0));
                }
            }
        }
        C = list.size();
        ArrayList<CCTV> result = new ArrayList<>();
        compute(0, result);
        System.out.println(min);
    }

    static void compute(int idx, ArrayList<CCTV> result) {
        if (idx == C) {
            findMax(result);
            return;
        }

        CCTV cur = list.get(idx);
        for (int i = 0; i < 4; i++) {
            result.add(new CCTV(cur.x, cur.y, cur.c, i));
            compute(idx + 1, result);
            result.remove(idx);
        }
    }

    static void findMax(ArrayList<CCTV> result) {
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            temp[i] = map[i].clone();
        }
        for (int i = 0; i < result.size(); i++) {
            CCTV cur = result.get(i);
            int nx;
            int ny;
            int c = cur.c;
            int d = cur.d;
            if (cur.c == 5) {
                for (int j = 0; j < 4; j++) {
                    d = (cur.d + j) % 4;
                    nx = cur.x + dx[d];
                    ny = cur.y + dy[d];
                    while (isAvailable(nx, ny) && map[nx][ny] != 6) {
                        temp[nx][ny] = c;
                        nx += dx[d];
                        ny += dy[d];
                    }
                }
            } else if (cur.c == 4) {
                for (int j = 0; j < 3; j++) {
                    d = (cur.d + j) % 4;
                    nx = cur.x + dx[d];
                    ny = cur.y + dy[d];
                    while (isAvailable(nx, ny) && map[nx][ny] != 6) {
                        temp[nx][ny] = c;
                        nx += dx[d];
                        ny += dy[d];
                    }
                }
            } else if (cur.c == 3) {
                for (int j = 0; j < 2; j++) {
                    d = (cur.d + j) % 4;
                    nx = cur.x + dx[d];
                    ny = cur.y + dy[d];
                    while (isAvailable(nx, ny) && map[nx][ny] != 6) {
                        temp[nx][ny] = c;
                        nx += dx[d];
                        ny += dy[d];
                    }
                }
            } else if (cur.c == 2) {
                nx = cur.x + dx[d];
                ny = cur.y + dy[d];
                while (isAvailable(nx, ny) && map[nx][ny] != 6) {
                    temp[nx][ny] = c;
                    nx += dx[d];
                    ny += dy[d];
                }
                d = (cur.d + 2) % 4;
                nx = cur.x + dx[d];
                ny = cur.y + dy[d];
                while (isAvailable(nx, ny) && map[nx][ny] != 6) {
                    temp[nx][ny] = c;
                    nx += dx[d];
                    ny += dy[d];
                }
            } else{
                nx = cur.x + dx[d];
                ny = cur.y + dy[d];
                while (isAvailable(nx, ny) && map[nx][ny] != 6) {
                    temp[nx][ny] = c;
                    nx += dx[d];
                    ny += dy[d];
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(temp[i][j] == 0)
                    sum++;
            }
        }
        min = Math.min(min, sum);
    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static void main(String[] args) throws IOException {
        BOJ15683.solution();
    }
}
