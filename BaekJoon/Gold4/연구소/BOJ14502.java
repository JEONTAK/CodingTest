package BaekJoon.Gold4.연구소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502 {

    static class Virus{
        int x;
        int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] lab;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int max = Integer.MIN_VALUE;
    static ArrayList<Virus> list = new ArrayList<>();
    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2) {
                    list.add(new Virus(i, j));
                }
            }
        }
        makeWall(0);

        System.out.println(max);
    }

    static void makeWall(int cnt) {
        if (cnt == 3) {
            compute();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (lab[i][j] == 0) {
                    lab[i][j] = 1;
                    makeWall(cnt + 1);
                    lab[i][j] = 0;
                }
            }
        }
    }

    static void compute(){
        Queue<Virus> q = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            q.add(list.get(i));
        }

        int[][] copyLab = new int[N][M];
        for (int i = 0; i < N; i++) {
            copyLab[i] = lab[i].clone();
        }

        while (!q.isEmpty()) {
            Virus cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (isAvailable(nx, ny) && copyLab[nx][ny] == 0) {
                    copyLab[nx][ny] = 2;
                    q.add(new Virus(nx, ny));
                }
            }
        }

        countSafe(copyLab);
    }

    private static void countSafe(int[][] copyLab) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyLab[i][j] == 0) {
                    sum++;
                }
            }
        }
        max = Math.max(max, sum);
    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static void main(String[] args) throws IOException {
        BOJ14502.solution();
    }
}
