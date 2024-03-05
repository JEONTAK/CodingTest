package BaekJoon.제곱수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int[][] array;
    static int result = -1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N][M];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
            }
        }
        compute();
        System.out.println(result);

    }
    static void compute(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int ni = -N; ni < N; ++ni) {
                    for (int mj = -M; mj < M; ++mj) {
                        if (ni == 0 && mj == 0) {
                            continue;
                        }

                        int num = 0;
                        int newI = i;
                        int newJ = j;

                        while (available(newI, newJ)) {
                            num = 10 * num + array[newI][newJ];

                            if (Math.abs(Math.sqrt(num) - (int) Math.sqrt(num)) < 1e-10) {
                                result = Math.max(result,num);
                            }

                            newI += ni;
                            newJ += mj;
                        }
                    }
                }
            }
        }
    }

    static boolean available(int i, int j){
        return i >= 0 && i < N && j >= 0 && j < M;
    }

}
