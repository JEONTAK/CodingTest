package BaekJoon.Gold4.스도쿠2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2239 {

    static int N = 9;
    static int[][] sudoku = new int[N][N];
    static boolean flag;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                sudoku[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j) - '0'));
            }
        }

        compute(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(sudoku[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void compute(int idx) {
        if (idx == 81) {
            flag = true;
            return;
        }
        int r = idx / 9;
        int c = idx % 9;
        if (sudoku[r][c] != 0) {
            compute(idx + 1);
        }else{
            for (int i = 1; i <= N; i++) {
                if(!isAvailable(r,c,i))continue;
                sudoku[r][c] = i;
                compute(idx + 1);

                if(flag) return;
                sudoku[r][c] = 0;
            }
        }
    }

    static boolean isAvailable(int r, int c, int n) {
        for (int i = 0; i < N; i++) {
            if(sudoku[i][c] == n || sudoku[r][i] == n) return false;
        }

        int sr = r / 3 * 3;
        int sc = c - c % 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if(sudoku[i][j] == n)return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BOJ2239.solution();
    }
}
