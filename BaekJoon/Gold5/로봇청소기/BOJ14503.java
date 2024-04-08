package BaekJoon.Gold5.로봇청소기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503 {

    static int N, M;
    static int curX, curY, d;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] room;
    static int result = 1;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];
        st = new StringTokenizer(br.readLine());
        curX = Integer.parseInt(st.nextToken());
        curY = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        compute(curX,curY,d);
        System.out.println(result);
    }

    static void compute(int x, int y, int d){
        room[x][y] = -1;
        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (isAvailable(nx, ny)) {
                if (room[nx][ny] == 0) {
                    result++;
                    compute(nx,ny,d);
                    return;
                }
            }
         }

        int dir = (d + 2) % 4;
        int bx = x + dx[dir];
        int by = y + dy[dir];
        if(isAvailable(bx,by) && room[bx][by] != 1){
            compute(bx, by, d);
        }
    }

    static boolean isAvailable(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static void main(String[] args) throws IOException {
        BOJ14503.solution();
    }
}
