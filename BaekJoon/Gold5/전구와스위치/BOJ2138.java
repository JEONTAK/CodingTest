package BaekJoon.Gold5.전구와스위치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2138 {

    static int N;
    static int[][] give;
    static int[] result;
    static int min = Integer.MAX_VALUE;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        give = new int[N][2];
        result = new int[N];
        String temp = br.readLine();
        for (int i = 0; i < N; i++) {
            give[i][0] = Integer.parseInt(String.valueOf(temp.charAt(i)));
            give[i][1] = give[i][0];
        }
        temp = br.readLine();
        for (int i = 0; i < N; i++) {
            result[i] = Integer.parseInt(String.valueOf(temp.charAt(i)));
        }
        compute(0);
        compute(1);

        if (min > 1000000) {
            System.out.println(-1);
        }else{
            System.out.println(min);
        }
    }

    static void compute(int loc){
        boolean flag = true;
        int sum = 0;
        if (loc == 0) {
            changeLight(0, loc);
            changeLight(1, loc);
            sum++;
        }else{

        }
        for (int i = 1; i < N; i++) {
            if (give[i - 1][loc] != result[i - 1]){
                changeLight(i - 1, loc);
                changeLight(i,loc);
                if (i < N - 1) {
                    changeLight(i + 1, loc);
                }
                sum++;
            }
        }
        for (int i = 0; i < N; i++) {
            if(give[i][loc] != result[i]){
                flag = false;
            }
        }
        if (flag) {
            min = Math.min(min, sum);
        }
    }

    static void changeLight(int idx, int loc){
        give[idx][loc] = give[idx][loc] == 1 ? 0 : 1;
    }

    public static void main(String[] args) throws IOException {
        BOJ2138.solution();
    }
}
