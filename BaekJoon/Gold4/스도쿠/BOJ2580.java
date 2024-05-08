package BaekJoon.Gold4.스도쿠;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2580 {

    static int N = 9;
    static int[][] sudoku;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sudoku = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        compute(0,0);
    }

    static void compute(int row, int col) {
        if (col == N) {
            compute(row + 1, 0);
            return;
        }

        if (row == N) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(sudoku[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        if (sudoku[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (isAvailable(row, col, i)) {
                    sudoku[row][col] = i;
                    compute(row, col + 1);
                }
            }
            sudoku[row][col] = 0;
            return;
        }
        compute(row, col + 1);
    }

    static boolean isAvailable(int row, int col, int v) {
        for (int i = 0; i < N; i++) {
            if (sudoku[row][i] == v) {
                return false;
            }
            if (sudoku[i][col] == v) {
                return false;
            }
        }

        int smallR = (row / 3) * 3;
        int smallC = (col / 3) * 3;
        for (int i = smallR; i < smallR + 3; i++) {
            for (int j = smallC; j < smallC + 3; j++) {
                if (sudoku[i][j] == v) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BOJ2580.solution();
    }
}
