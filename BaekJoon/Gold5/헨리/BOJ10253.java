package BaekJoon.Gold5.헨리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10253 {

    static int N;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int x = 0;
            while (a != 1) {
                if (b % a == 0) {
                    x = b / a;
                }else{
                    x = b / a + 1;
                }
                a = a * x - b;
                b = b * x;
                int g = compute(a, b);
                a /= g;
                b /= g;
            }
            System.out.println(b);
        }
    }

    static int compute(int a, int b){
        if (b == 0) {
            return a;
        }else{
            return compute(b, a % b);
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ10253.solution();
    }
}
