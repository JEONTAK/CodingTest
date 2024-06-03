package BaekJoon.Gold4.휴게소세우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1477 {

    static int N, M, L;
    static int[] store;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        store = new int[N + 2];
        store[0] = 0;
        store[N + 1] = L;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            store[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(store);
        int left = 1;
        int right = L - 1;
        int result = 0;
        while (left <= right) {
            int dist = (left + right) / 2;
            int cnt = compute(dist);
            if (cnt > M) {
                left = dist + 1;
            }else{
                right = dist - 1;
                result = dist;
            }
        }
        System.out.println(result);
    }

    static int compute(int dist) {
        int cnt = 0;
        for (int i = 0; i < store.length - 1; i++) {
            int tD = store[i + 1] - store[i];
            cnt += tD/dist;
            if (tD % dist == 0) {
                cnt--;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BOJ1477.solution();
    }
}
