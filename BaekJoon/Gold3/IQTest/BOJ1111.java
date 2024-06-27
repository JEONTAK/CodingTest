package BaekJoon.Gold3.IQTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1111 {

    static int N;
    static int[] seq;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        seq = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        if (N == 1 || (N == 2 && seq[0] != seq[1])) {
            System.out.println("A");
        } else if (N == 2) {
            System.out.println(seq[0]);
        }else{
            int a, b;
            if (seq[1] == seq[0]) {
                a = 1;
                b = 0;
            }else{
                a = (seq[2] - seq[1]) / (seq[1] - seq[0]);
                b = seq[1] - (seq[0] * a);
            }
            if (isAvailable(a, b)) {
                System.out.println((a * seq[N - 1] + b));
            }else{
                System.out.println("B");
            }
        }
    }

    static boolean isAvailable(int a, int b) {
        for (int i = 0; i < N - 1; i++) {
            if(seq[i + 1] != (seq[i] * a + b))
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BOJ1111.solution();
    }
}
