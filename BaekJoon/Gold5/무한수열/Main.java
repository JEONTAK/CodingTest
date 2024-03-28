package BaekJoon.Gold5.무한수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static long N, P, Q;
    static HashMap<Long, Long> dp = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        dp.put(0L, 1L);
        System.out.println(compute(N));
    }

    static long compute(long N){
        if(dp.containsKey(N)) return dp.get(N);
        long N1 = (long) Math.floor(N / P);
        long N2 = (long) Math.floor(N / Q);
        dp.put(N, compute(N1) + compute(N2));
        return dp.get(N);
    }
}
