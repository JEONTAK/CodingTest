package BaekJoon.Gold5.문자열게임2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ20437 {

    static int T, K;
    static String W;
    static ArrayList<Integer>[] alphabet;
    //a = 97, z = 122
    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            W = br.readLine();
            K = Integer.parseInt(br.readLine());
            alphabet = new ArrayList[26];
            for (int j = 0; j < 26; j++) {
                alphabet[j] = new ArrayList<>();
            }
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            compute();
            if (min > W.length() || max < 0) {
                System.out.println(-1);
            } else {
                System.out.println(min + " " + max);
            }
        }
    }

    static void compute(){
        for (int i = 0; i < W.length(); i++) {
            int alpha = W.charAt(i) - 97;
            alphabet[alpha].add(i);
        }

        for (int i = 0; i < 26; i++) {
            if (alphabet[i].size() >= K) {
                for (int j = 0; j <= alphabet[i].size() - K; j++) {
                    min = Math.min(min, alphabet[i].get(j + (K - 1)) - alphabet[i].get(j) + 1);
                    max = Math.max(max, alphabet[i].get(j + (K - 1)) - alphabet[i].get(j) + 1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ20437.solution();
    }
}
