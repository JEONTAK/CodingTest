package BaekJoon.Gold4.배열돌리기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17406 {

    static int N, M, K;
    static int[][] arr;
    static int[][] oper;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        oper = new int[K][3];
        visited = new boolean[K];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            oper[i][0] = (r - 1);
            oper[i][1] = (c - 1);
            oper[i][2] = s;
        }

        compute(0, new int[K]);

        System.out.println(min);
    }
    static void compute(int idx, int[] seq) {
        if(idx == K) {
            cycle(seq);
            return;
        }
        for(int i=0; i<K; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            seq[idx] = i;
            compute(idx + 1, seq);
            visited[i] = false;
        }
    }

    static void cycle(int[] seq) {
        int[][] tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = arr[i][j];
            }
        }

        for(int k=0; k<K; k++) {
            int r = oper[seq[k]][0];
            int c = oper[seq[k]][1];
            int S = oper[seq[k]][2];

            for(int s=1; s<=S; s++) {
                int upTmp = tmp[r-s][c+s];
                for(int y = c+s; y > c-s; y--) {
                    tmp[r-s][y] = tmp[r-s][y-1];
                }
                int rightTmp = tmp[r+s][c+s];
                for(int x = r+s; x > r-s; x--) {
                    tmp[x][c+s] = tmp[x-1][c+s];
                }
                tmp[r-s+1][c+s] = upTmp;
                int leftTmp = tmp[r+s][c-s];
                for(int y = c-s; y < c+s; y++) {
                    tmp[r+s][y] = tmp[r+s][y+1];
                }
                tmp[r+s][c+s-1] = rightTmp;
                for(int x = r-s; x < r+s; x++) {
                    tmp[x][c-s] = tmp[x+1][c-s];
                }
                tmp[r+s-1][c-s] = leftTmp;
            }
        }
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum+= tmp[i][j];
            }
            min = Math.min(min, sum);
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ17406.solution();
    }
}
