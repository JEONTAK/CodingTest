package BaekJoon.Gold4.경사로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14890 {

    static int N, L;
    static int[][] map;
    static int result = 0;
    static boolean[] visited;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            if (computeR(i)) result++;
            if (computeC(i)) result++;
        }
        System.out.println(result);
    }

    static boolean computeR(int idx) {
        visited = new boolean[N];
        for (int i = 0; i < N - 1; i++) {
            int diff = map[idx][i] - map[idx][i + 1];
            if (Math.abs(diff) > 1) {
                return false;
            } else if (diff == -1) {
                for (int j = 0; j < L; j++) {
                    if(i - j < 0 || visited[i - j]) return false;
                    if(map[idx][i] != map[idx][i - j]) return false;
                    visited[i - j] = true;
                }
            } else if (diff == 1) {
                for (int j = 1; j <= L; j++) {
                    if(i + j >= N || visited[i + j]) return false;
                    if(map[idx][i] - 1 != map[idx][i + j]) return false;
                    visited[i + j] = true;
                }
            }
        }
        return true;
    }

    static boolean computeC(int idx){
        visited = new boolean[N];
        for (int i = 0; i < N - 1; i++) {
            int diff = map[i][idx] - map[i + 1][idx];
            if (Math.abs(diff) > 1) {
                return false;
            } else if (diff == -1) {
                for (int j = 0; j < L; j++) {
                    if(i - j < 0 || visited[i - j]) return false;
                    if(map[i][idx] != map[i - j][idx]) return false;
                    visited[i - j] = true;
                }
            } else if (diff == 1) {
                for (int j = 1; j <= L; j++) {
                    if(i + j >= N || visited[i + j]) return false;
                    if(map[i][idx] - 1 != map[i + j][idx]) return false;
                    visited[i + j] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BOJ14890.solution();
    }
}
