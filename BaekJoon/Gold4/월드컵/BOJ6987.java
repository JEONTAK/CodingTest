package BaekJoon.Gold4.월드컵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6987 {

    static int N = 4, M = 6, S = 15;
    static int[][] match;
    static boolean flag = false;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        match = new int[S][2];
        int idx = 0;
        for (int i = 0; i < M - 1; i++) {
            for (int j = i + 1; j < M; j++) {
                match[idx][0] = i;
                match[idx][1] = j;
                idx++;
            }
        }
        for (int i = 0; i < N; i++) {
            int[][] result = new int[M][3];
            flag = false;
            st = new StringTokenizer(br.readLine());
            boolean isAvailable = true;
            for (int j = 0; j < M; j++) {
                int w = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                result[j][0] = w;
                result[j][1] = d;
                result[j][2] = l;
                if (w + d + l != 5) {
                    isAvailable = false;
                    break;
                }
            }
            if (isAvailable) {
                compute(result, 0);
                if (flag) {
                    sb.append("1 ");
                }else{
                    sb.append("0 ");
                }
            }else{
                sb.append("0 ");
            }
        }
        System.out.println(sb);

    }

    static void compute(int[][] result, int idx) {
        if (flag) {
            return;
        }
        if (idx == S) {
            flag = true;
            return;
        }
        int home = match[idx][0];
        int away = match[idx][1];
        if (result[home][0] > 0 && result[away][2] > 0) {
            result[home][0]--;
            result[away][2]--;
            compute(result, idx + 1);
            result[home][0]++;
            result[away][2]++;
        }
        if (result[home][1] > 0 && result[away][1] > 0) {
            result[home][1]--;
            result[away][1]--;
            compute(result, idx + 1);
            result[home][1]++;
            result[away][1]++;
        }
        if (result[home][2] > 0 && result[away][0] > 0) {
            result[home][2]--;
            result[away][0]--;
            compute(result, idx + 1);
            result[home][2]++;
            result[away][0]++;
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ6987.solution();
    }
}
