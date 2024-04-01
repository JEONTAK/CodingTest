package BaekJoon.Gold5.토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] ground;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0,0,1,-1};

    static Queue<Tomato> q = new LinkedList<>();

    static class Tomato{
        int x;
        int y;
        int day;

        public Tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        ground = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                if (ground[i][j] == 1) {
                    q.offer(new Tomato(i,j,0));
                }
            }
        }
        compute();
    }

    static void compute(){
        int day = 0;
        while (!q.isEmpty()) {
            Tomato tomato  = q.poll();
            day = tomato.day;
            for (int i = 0; i < 4; i++) {
                int nx = tomato.x + dx[i];
                int ny = tomato.y + dy[i];
                if (isAvailable(nx, ny)) {
                    if (ground[nx][ny] == 0) {
                        ground[nx][ny] = 1;
                        q.add(new Tomato(nx,ny,day + 1));
                    }
                }
            }
        }
        if (allGrown()) {
            System.out.println(day);
        }else{
            System.out.println(-1);
        }
    }

    static boolean allGrown(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ground[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }


    static boolean isAvailable(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
