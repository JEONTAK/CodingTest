package BaekJoon.Gold5.입국심사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3079 {

    static long N;
    static long M;
    static long[] K;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
        K = new long[(int)N];
        long min = Long.MAX_VALUE - 1;
        long max = 0;
        for (int i = 0; i < N; i++) {
            K[i] = Long.parseLong(br.readLine());
            min = Math.min(min, K[i]);
            max = Math.max(max, K[i]);
        }
        compute(min,max * M);
    }

    static void compute(long left, long right) {
        while (left <= right) {
            long mid = (left + right) / 2;
            if (isAvailable(mid)) {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(left);
    }

    static boolean isAvailable(long mid){
        long fin = 0;
        for (int i = 0; i < N; i++) {
            fin += (mid / K[i]);
            if(fin >= M) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BOJ3079.solution();
    }
}
