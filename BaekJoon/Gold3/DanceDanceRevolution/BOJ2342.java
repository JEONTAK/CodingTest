package BaekJoon.Gold3.DanceDanceRevolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2342 {

    static int[][][] foot;
    static int[] seq;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int len = st.countTokens();
        seq = new int[len - 1];
        for (int i = 0; i < len - 1; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        foot = new int[5][5][len];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(foot[i][j], -1);
            }
        }
        int result = compute(0, 0, 0);
        System.out.println(result);
    }

    static int compute(int left, int right, int cnt) {
        if(cnt == seq.length) return 0;
        if(foot[left][right][cnt] != -1) return foot[left][right][cnt];
        foot[left][right][cnt] = Math.min(compute(seq[cnt], right, cnt + 1) + moving(left, seq[cnt]), compute(left, seq[cnt], cnt + 1) + moving(right, seq[cnt]));
        return foot[left][right][cnt];
    }

    static int moving(int start, int fin) {
        int num = Math.abs(start - fin);
        if(start == 0) return 2;
        else if(num == 0)return 1;
        else if(num == 1 || num == 3) return 3;
        else return 4;
    }

    public static void main(String[] args) throws IOException {
        BOJ2342.solution();
    }
}
