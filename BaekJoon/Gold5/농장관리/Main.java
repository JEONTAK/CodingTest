package BaekJoon.Gold5.농장관리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] delta = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static boolean flag;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && map[i][j] != 0){
                    flag = true;
                    compute(i,j);
                    if(flag) result++;
                }
            }
        }
        System.out.println(result);
    }

    static void compute(int curX, int curY){
        for (int i = 0; i < 8; i++) {
            int nX = curX + delta[i][0];
            int nY = curY + delta[i][1];
            if(isAvailable(nX,nY)){
                if(map[curX][curY] < map[nX][nY]) flag = false;
                if(!visited[nX][nY] && map[curX][curY] == map[nX][nY]){
                    visited[nX][nY] = true;
                    compute(nX,nY);
                }
            }
        }
    }

    static boolean isAvailable(int curX, int curY){
        return curX >= 0 && curX < N && curY >= 0 && curY < M;
    }

}
