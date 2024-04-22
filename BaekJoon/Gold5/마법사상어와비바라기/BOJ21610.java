package BaekJoon.Gold5.마법사상어와비바라기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ21610 {

    static class Rain{
        int x;
        int y;

        public Rain(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] A;
    static int[][] delta = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
    static boolean[][] rainDrop;
    static Queue<Rain> q = new LinkedList<>();
    static Queue<Rain> rainFin = new LinkedList<>();

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        q.add(new Rain(N - 1, 0));
        q.add(new Rain(N - 1, 1));
        q.add(new Rain(N - 2, 0));
        q.add(new Rain(N - 2, 1));

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            compute(d - 1,s);
        }

        int sum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += A[i][j];
            }
        }
        System.out.println(sum);
    }

    static void compute(int d, int s){
        rainDrop = new boolean[N][N];
        int nx = delta[d][0] * s % N;
        int ny = delta[d][1] * s % N;
        while (!q.isEmpty()) {
            Rain rain = q.poll();
            A[(nx + rain.x + N) % N][(ny + rain.y + N) % N]++;
            rainFin.add(new Rain((nx + rain.x + N) % N,(ny + rain.y + N) % N));
        }
        while (!rainFin.isEmpty()) {
            Rain rain = rainFin.poll();
            rainDrop[rain.x][rain.y] = true;
            int bucketSum = 0;
            for (int i = 1; i <= 7; i = i + 2) {
                int x = rain.x + delta[i][0];
                int y = rain.y + delta[i][1];
                if (isAvailable(x, y) && A[x][y] > 0) {
                    bucketSum++;
                }
            }
            A[rain.x][rain.y] += bucketSum;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!rainDrop[i][j]){
                    if (A[i][j] >= 2) {
                        q.add(new Rain(i,j));
                        A[i][j] -= 2;
                    }
                }
            }
        }
    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static void main(String[] args) throws IOException {
        BOJ21610.solution();
    }
}
