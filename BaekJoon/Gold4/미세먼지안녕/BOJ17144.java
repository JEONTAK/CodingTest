package BaekJoon.Gold4.미세먼지안녕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17144 {

    static int R, C, T;
    static int[][] map;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int air1, air2;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < R; i++) {
            if (map[i][0] == -1) {
                air1 = i;
                air2 = i + 1;
                break;
            }
        }
        for (int i = 0; i < T; i++) {
            map = compute();
            runAirCon();
        }
        int result = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                result += map[i][j];
            }
        }
        System.out.println((result + 2));
    }

    static int[][] compute(){
        int[][] temp = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) {
                    temp[i][j] = -1;
                    continue;
                }
                temp[i][j] += map[i][j];
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(!isAvailable(nx,ny)) continue;
                    if(map[nx][ny] == -1) continue;
                    temp[nx][ny] += map[i][j] / 5;
                    temp[i][j] -= (map[i][j] / 5);
                }
            }
        }
        return temp;
    }

    static void runAirCon() {
        int top = air1;
        for (int i = top - 1; i > 0; i--) {
            map[i][0] = map[i - 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            map[0][i] = map[0][i + 1];
        }
        for (int i = 0; i < top; i++) {
            map[i][C - 1] = map[i + 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            map[top][i] = map[top][i - 1];
        }

        map[top][1] = 0;

        int bottom = air2;

        for (int i = bottom + 1; i < R - 1; i++) {
            map[i][0] = map[i + 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            map[R - 1][i] = map[R - 1][i + 1];
        }
        for (int i = R - 1; i > bottom; i--) {
            map[i][C - 1] = map[i - 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            map[bottom][i] = map[bottom][i - 1];
        }
        map[bottom][1] = 0;
    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && y >= 0 && x < R && y < C;
    }

    public static void main(String[] args) throws IOException {
        BOJ17144.solution();
    }
}
