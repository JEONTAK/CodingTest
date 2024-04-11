package BaekJoon.Gold1.비숍;

import java.util.Scanner;

public class BOJ1799 {

    static int N;
    static int[][] chessBoard;
    static int black, white;
    //우상, 우하, 좌하, 좌상
    static int[] dx = {-1,1,1,-1};
    static int[] dy = {1,1,-1,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        chessBoard = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                int temp = sc.nextInt();
                chessBoard[i][j] = temp;
            }
        }
        boolean[][] check = new boolean[N][N];
        black = 0;
        white = 0;
        computeBlack(check, 0, 0, 0);
        computeWhite(check, 0, 1, 0);

        System.out.println(black + white);
    }

    private static void computeBlack(boolean[][] check, int x, int y, int count) {
        black = Math.max(count, black);

        if(y >= N){
            x += 1;
            if((x % 2) == 0){
                y = 0;
            }else{
                y = 1;
            }
        }

        if(x >= N) return;

        if (isAvailable(check, x, y)) {
            check[x][y] = true;
            computeBlack(check, x, y + 2, count + 1);
            check[x][y] = false;
        }

        computeBlack(check, x, y + 2, count);
    }

    private static void computeWhite(boolean[][] check, int x, int y, int count) {
        white = Math.max(count, white);

        if(y >= N){
            x += 1;
            if((x % 2) == 0){
                y = 1;
            }else{
                y = 0;
            }
        }

        if(x >= N) return;

        if (isAvailable(check, x, y)) {
            check[x][y] = true;
            computeWhite(check, x, y + 2, count + 1);
            check[x][y] = false;
        }

        computeWhite(check, x, y + 2, count);
    }


    private static boolean isAvailable(boolean [][] check, int x, int y) {
        if (chessBoard[x][y] == 0) return false;

        for (int i = 0; i < 4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];

            for(int j = 1 ; j <= N ; j ++) {
                if (nX >= 0 && nY >= 0 && nX < N && nY < N) {
                    if (check[nX][nY])
                        return false;
                    nX += dx[i];
                    nY += dy[i];
                }
            }
        }
        return true;
    }

}
