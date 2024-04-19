package BaekJoon.Gold5.CCW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11758 {

    static int[][] coor;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        coor = new int[3][2];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            coor[i][0] = Integer.parseInt(st.nextToken());
            coor[i][1] = Integer.parseInt(st.nextToken());
        }
        compute();
    }

    static void compute(){
        int t1 = coor[0][0] * coor[1][1] + coor[1][0] * coor[2][1] + coor[2][0] * coor[0][1];
        int t2 = coor[0][1] * coor[1][0] + coor[1][1] * coor[2][0] + coor[2][1] * coor[0][0];
        int ans = t1 - t2;
        if (ans > 0) {
            System.out.println(1);
        } else if (ans == 0) {
            System.out.println(0);
        } else{
            System.out.println(-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ11758.solution();
    }
}
