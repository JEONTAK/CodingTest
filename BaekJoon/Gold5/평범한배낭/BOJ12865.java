package BaekJoon.Gold5.평범한배낭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ12865 {

   static Integer[][] backPack;
   static int[] W;
   static int[] V;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, K;

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        W = new int[N];
        V = new int[N];

        backPack = new Integer[N][K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(knapSack(N - 1, K));
    }

    static int knapSack(int i, int k){
        if (i < 0) {
            return 0;
        }

        if (backPack[i][k] == null) {
            if (W[i] > k) {
                backPack[i][k] = knapSack(i - 1, k);
            }
            else{
                backPack[i][k] = Math.max(knapSack(i - 1, k), knapSack(i - 1, k - W[i]) + V[i]);
            }
        }
        return backPack[i][k];
    }


    public static void main(String[] args) throws IOException {
        BOJ12865.solution();
    }
}
