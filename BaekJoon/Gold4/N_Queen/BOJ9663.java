package BaekJoon.Gold4.N_Queen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9663 {

    static int N;
    static int[] board;
    static int count = 0;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N];
        compute(0);
        System.out.println(count);
    }

    static void compute(int idx){
        if (idx == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            board[idx] = i;
            if (isAvailable(idx)) {
                compute(idx + 1);
            }
        }
    }

    static boolean isAvailable(int col) {
        for (int i = 0; i < col; i++) {
            if (board[col] == board[i]) {
                return false;
            } else if (Math.abs(col - i) == Math.abs(board[col] - board[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BOJ9663.solution();
    }
}
