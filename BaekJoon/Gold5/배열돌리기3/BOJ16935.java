package BaekJoon.Gold5.배열돌리기3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16935 {

    static int N, M, R;
    static int [][] list;
    static int o;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        list = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            o = Integer.parseInt(st.nextToken());
            compute(o);
        }

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[0].length; j++) {
                System.out.print(list[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void compute(int operation){
        if (operation == 1) {
            reverseTD();
        } else if (operation == 2) {
            reverseLR();
        } else if (operation == 3) {
            turnR();
        } else if (operation == 4) {
            turnL();
        } else if (operation == 5) {
            separateTurnR();
        } else if (operation == 6) {
            separateTurnL();
        }
    }
    static void reverseTD(){
        int[][] temp = new int[list.length][list[0].length];
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[0].length; j++) {
                temp[i][j] = list[list.length - i - 1][j];
            }
        }
        list = temp.clone();
    }
    static void reverseLR(){
        int[][] temp = new int[list.length][list[0].length];
        for (int i = 0; i < list.length; i++) {
            for(int j = 0 ; j < list[0].length ; j++)
                temp[i][j] = list[i][list[0].length - j - 1];
        }
        list = temp.clone();
    }
    static void turnR(){
        int[][] temp = new int[list[0].length][list.length];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                temp[i][j] = list[(list.length - j - 1) % list.length][i];
            }
        }
        list = temp.clone();
    }
    static void turnL(){
        int[][] temp = new int[list[0].length][list.length];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                temp[i][j] = list[j][(list[0].length - i - 1) % list[0].length];
            }
        }
        list = temp.clone();
    }

    static void separateTurnR(){
        int col = list.length / 2;
        int row = list[0].length / 2;
        int[][] temp = new int[list.length][list[0].length];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                temp[i][j + row] = list[i][j];
            }
        }
        for (int i = 0; i < col; i++) {
            for (int j = row; j < list[0].length; j++) {
                temp[i + col][j] = list[i][j];
            }
        }
        for (int i = col; i < list.length; i++) {
            for (int j = row; j < list[0].length; j++) {
                temp[i][j - row] = list[i][j];
            }
        }
        for (int i = col; i < list.length; i++) {
            for (int j = 0; j < row; j++) {
                temp[i - col][j] = list[i][j];
            }
        }
        list = temp.clone();
    }
    static void separateTurnL(){
        int col = list.length / 2;
        int row = list[0].length / 2;
        int[][] temp = new int[list.length][list[0].length];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                temp[i + col][j] = list[i][j];
            }
        }
        for (int i = col; i < list.length; i++) {
            for (int j = 0; j < row; j++) {
                temp[i][j + row] = list[i][j];
            }
        }
        for (int i = col; i < list.length; i++) {
            for (int j = row; j < list[0].length; j++) {
                temp[i - col][j] = list[i][j];
            }
        }
        for (int i = 0; i < col; i++) {
            for (int j = row; j < list[0].length; j++) {
                temp[i][j - row] = list[i][j];
            }
        }
        list = temp.clone();
    }

    public static void main(String[] args) throws IOException {
        BOJ16935.solution();
    }
}
