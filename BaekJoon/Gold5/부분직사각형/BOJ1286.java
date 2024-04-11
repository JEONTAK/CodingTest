package BaekJoon.Gold5.부분직사각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1286 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] square = new char[2 * N][2 * M];
        long[] alphabet = new long[26];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                square[i][j] = line.charAt(j);
                square[i][j + M] = line.charAt(j);
                square[i + N][j] = line.charAt(j);
                square[i + N][j + M] = line.charAt(j);
            }

        }

        for (int i = 0; i < 2 * N; i++) {
            for (int j = 0; j <  2 * M; j++) {
                int sum = (i + 1) * (2 * N - i) * (j + 1) * (2 * M - j);
                alphabet[square[i][j] - 'A'] += sum;
            }
        }

        for (int i = 0; i < 26; i++) {
            System.out.println(alphabet[i]);
        }
    }
}
