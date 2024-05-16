package BaekJoon.Gold4.검문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2981 {

    static int N;
    static int[] num;
    static int minNum;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(num);
        minNum = num[1] - num[0];

        for (int i = 2; i < N; i++) {
            minNum = gcd(minNum, num[i] - num[i - 1]);
        }

        for (int i = 2; i <= minNum; i++) {
            if (minNum % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }else {
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ2981.solution();
    }
}
