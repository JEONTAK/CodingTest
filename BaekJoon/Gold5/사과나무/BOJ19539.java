package BaekJoon.Gold5.사과나무;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ19539 {

    static int N;
    static int sum = 0;
    static int one = 0;
    static int two = 0;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tree = Integer.parseInt(st.nextToken());
            sum += tree;
            two += tree / 2;
            one += tree % 2;
        }

        if (sum % 3 != 0) {
            System.out.println("NO");
        }else{
            if (one > two) {
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ19539.solution();
    }
}
