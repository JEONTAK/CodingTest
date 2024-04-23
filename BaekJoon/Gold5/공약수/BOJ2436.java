package BaekJoon.Gold5.공약수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2436 {

    static long GCD, LCM;
    static long mul;
    static long num1, num2;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        GCD = Long.parseLong(st.nextToken());
        LCM = Long.parseLong(st.nextToken());
        mul = GCD * LCM;
        num1 = GCD;
        num2 = LCM;

        for (long i = 2 * GCD; i * i <= mul; i += GCD) {
            if (mul % i == 0) {
                long temp = mul / i;
                if (gcd(i, temp) == GCD) {
                    if (num1 + num2 > i + temp) {
                        num1 = i;
                        num2 = temp;
                    }
                }
            }
        }
        System.out.println(num1 + " " + num2);
    }

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BOJ2436.solution();
    }
}
