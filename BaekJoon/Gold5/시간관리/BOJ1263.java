package BaekJoon.Gold5.시간관리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1263 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] TS = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            TS[i][0] = Integer.parseInt(st.nextToken());
            TS[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(TS, (o1, o2) -> o2[1] - o1[1]);
        int result = TS[0][1] - TS[0][0];

        for (int i = 1; i < N; i++) {
            if (TS[i][1] < result) {
                result = TS[i][1];
            }
            result -= TS[i][0];
        }

        StringBuilder sb = new StringBuilder();
        if (result > 0) {
            sb.append(result);
        }else{
            sb.append(-1);
        }
        System.out.println(sb);
    }
}
