package BaekJoon.Gold4.가르침;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1062 {

    static int N, K;
    static int[] alphabet;
    static String[] word;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;
    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        alphabet = new int[26];
        word = new String[N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            str = str.replace("anta", "");
            str = str.replace("tica", "");
            word[i] = str;
        }
        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        }

        visited = new boolean[26];
        visited['a' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;

        compute(0, 0);
        System.out.println(max);
    }

    static void compute(int alpha, int idx) {
        if (idx == K - 5) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                boolean canR = true;
                for (int j = 0; j < word[i].length(); j++) {
                    if (!visited[word[i].charAt(j) - 'a']) {
                        canR = false;
                        break;
                    }
                }
                if (canR) {
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
        }

        for (int i = alpha; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                compute(i, idx + 1);
                visited[i] = false;
            }
        }

    }


    public static void main(String[] args) throws IOException {
        BOJ1062.solution();
    }
}