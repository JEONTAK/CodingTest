package BaekJoon.Gold3.캐슬디펜스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17135 {

    static int N, M, D;
    static int[] archer = new int[3];
    static int[][] map;
    static int result = 0;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        setArcher(0,0);
        System.out.println(result);
    }

    static void setArcher(int cnt, int idx) {
        if (cnt == 3) {
            result = Math.max(result, compute());
            return;
        }

        for (int i = idx; i < M; i++) {
            archer[cnt] = i;
            setArcher(cnt + 1, i + 1);
        }
    }

    static int compute(){
        int cnt = 0;
        int[][] temp = new int[N][M];

        for (int i = N; i > 0; i--) {
            for (int j : archer) {
                for (int k = 1; k <= D; k++) {
                    int sum = fire(temp, k, i, j);
                    if(sum < 0) continue;
                    cnt += sum;
                    break;
                }
            }
        }
        return cnt;
    }

    private static int fire(int[][] temp, int d, int x, int y) {
        int dist;
        for (int i = y - d; i <= y + d; i++) {
            dist = x - (d - Math.abs(i - y));
            if(dist < 0 || dist >= x || i < 0 || i >= M) continue;
            if (map[dist][i] == 0)continue;
            if (temp[dist][i] == 0) {
                temp[dist][i] = x;
                return 1;
            }else if(temp[dist][i] == x)return 0;
        }
        return -1;
    }


    public static void main(String[] args) throws IOException {
        BOJ17135.solution();
    }
}
