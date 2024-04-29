package BaekJoon.Gold5.틱택토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ7682 {

    static String curBoard;
    static char[][] board;
    static int xNum, oNum;
    static StringBuilder sb = new StringBuilder();

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        curBoard = br.readLine();
        while (!curBoard.equals("end")) {
            board = new char[3][3];
            xNum = 0;
            oNum = 0;
            int idx = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = curBoard.charAt(idx);
                    if (board[i][j] == 'X') {
                        xNum++;
                    }else if(board[i][j] == 'O'){
                        oNum++;
                    }
                    idx++;
                }
            }
            compute();
            curBoard = br.readLine();
        }
    }

    static void compute(){
        if (xNum - oNum < 0 || xNum - oNum > 1) {
            System.out.println("invalid");
        }else{
            if (xNum + oNum == 9) {
                if (canT('O')) {
                    System.out.println("invalid");
                }else{
                    System.out.println("valid");
                }
            }else{
                if ((xNum - oNum) == 1 && canT('X') && !canT('O')) {
                    System.out.println("valid");
                }
                else if ((xNum - oNum) == 0 && canT('O') && !canT('X')) {
                    System.out.println("valid");
                }else{
                    System.out.println("invalid");
                }
            }
        }
    }

    static boolean canT(char stone) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][2] == stone) {
                return true;
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[2][i] == stone) {
                return true;
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] == stone) {
            return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[2][0] == stone) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BOJ7682.solution();
    }
}
