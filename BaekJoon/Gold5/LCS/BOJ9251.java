package BaekJoon.Gold5.LCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9251 {

    static char[] N,M;
    static Integer[][] board;
    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine().toCharArray();
        M = br.readLine().toCharArray();
        board = new Integer[N.length + 1][M.length + 1];

        int result = compute(N.length - 1,M.length - 1);
        System.out.println(result);
    }

    static int compute(int first, int second){
        if (first == -1 || second == -1) {
            return 0;
        }

        if (board[first][second] == null) {
            board[first][second] = 0;

            if (N[first] == M[second]) {
                board[first][second] = compute(first - 1, second - 1) + 1;
            } else {
                board[first][second] = Math.max(compute(first - 1, second), compute(first, second - 1));
            }
        }
        return board[first][second];
    }


    public static void main(String[] args) throws IOException {
        BOJ9251.solution();
    }
}
