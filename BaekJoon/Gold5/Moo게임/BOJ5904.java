package BaekJoon.Gold5.Moo게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5904 {

    static int N;
    static int[] S;
    static char[] moo = {'m', 'm', 'o', 'o'};

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[30];
        S[0] = 3;
        int idx = 0;
        while (S[idx] < N) {
            S[idx + 1] = 2 * S[idx] + 4 + idx;
            idx++;
        }
        compute(1, S[idx - 1], S[idx - 1] + 3 + idx, S[idx], idx);

    }

    static void compute(int start, int s1, int mid, int s2, int idx) {
        if (idx == 1) {
            if (start <= N && N <= s1) {
                System.out.println(moo[N]);
            } else if (s1 < N && N <= mid) {
                N = N - s1;
                if (N == 1) {
                    System.out.println("m");
                }
                else{
                    System.out.println("o");
                }
            }else{
                N = N - mid;
                System.out.println(moo[N]);
            }
            return;
        }
        if (start <= N && N <= s1) {
            idx = idx - 1;
            compute(start, S[idx - 1], S[idx - 1] + 3 + idx, S[idx], idx);
        } else if (s1 < N && N <= mid) {
            N = N - s1;
            if (N == 1) {
                System.out.println("m");
            }
            else{
                System.out.println("o");
            }
        } else {
            N = N - mid;
            idx = idx - 1;
            compute(start, S[idx - 1], S[idx - 1] + 3 + idx, S[idx], idx);
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ5904.solution();
    }
}
