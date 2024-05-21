package BaekJoon.Gold4.단어수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1339 {

    static int N;
    static String[] words;
    static int[] wN;
    static int[] alphabet;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        words = new String[N];
        wN = new int[N];
        alphabet = new int[26];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            int t = (int) Math.pow(10, words[i].length() - 1);
            for (int j = 0; j < words[i].length(); j++) {
                alphabet[(int)words[i].charAt(j) - 'A'] += t;
                t /= 10;
            }
        }
        Arrays.sort(alphabet);
        int idx = 9;
        int result = 0;
        for (int i = alphabet.length - 1; i >= 0; i--) {
            if (alphabet[i] == 0) {
                break;
            }
            result += alphabet[i] * idx;
            idx--;
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        BOJ1339.solution();
    }
}
