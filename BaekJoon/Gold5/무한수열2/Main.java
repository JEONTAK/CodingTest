package BaekJoon.Gold5.무한수열2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static long P, Q, X, Y;
    static HashMap<Long, Long> hm = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());
        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());

        System.out.println(compute(N));
    }

    static long compute(long N){
        if(N <= 0) {
            hm.put(N,1L);
        }
        if(hm.containsKey(N)){
            return hm.get(N);
        }
        long N1 = ((long) Math.floor(N / P)) - X;
        long N2 = ((long) Math.floor(N / Q)) - Y;

        hm.put(N, compute(N1) + compute(N2));
        return hm.get(N);
    }
}
