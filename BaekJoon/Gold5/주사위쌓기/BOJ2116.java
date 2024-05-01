package BaekJoon.Gold5.주사위쌓기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2116 {

    static int N;
    static int[][] dice;
    static int[][] result;
    static int loc = 0;
    static int max = Integer.MIN_VALUE;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dice = new int[N][6];
        result = new int[6][N + 1];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 6; i++) {
            result[loc][0] = dice[0][i];
            compute(0, dice[0][i]);
            loc++;
        }
        for (int i = 0; i < 6; i++) {
            max = Math.max(max, findMax(i,0));
        }
        System.out.println(max);
    }

    static int findMax(int cur, int idx){
        if (idx == N) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            int num = dice[idx][i];
            if (num != result[cur][idx] && num != result[cur][idx + 1]) {
                sum = Math.max(sum, num);
            }
        }
        return (sum + findMax(cur, idx + 1));
    }

    static void compute(int cur, int bottom) {
        int b = 0;
        if (cur == N) {
            return;
        }
        //아랫면찾기
        for (int i = 0; i < 6; i++) {
            if (bottom == dice[cur][i]) {
                b = i;
                break;
            }
        }
        //윗면 찾기
        if (b == 0) {
            b = 5;
        }else if(b == 1){
            b = 3;
        }else if(b == 2){
            b = 4;
        }else if(b == 3){
            b = 1;
        }else if(b == 4){
            b = 2;
        }else if(b == 5){
            b = 0;
        }
        result[loc][cur + 1] = dice[cur][b];
        compute(cur + 1, dice[cur][b]);
    }

    public static void main(String[] args) throws IOException {
        BOJ2116.solution();
    }
}
