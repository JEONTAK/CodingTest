package BaekJoon.Gold3.소수의연속합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ1644 {

    static int N;
    static boolean[] isPrime;
    static ArrayList<Integer> prime = new ArrayList<>();

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 0; i <= N; i++) {
            if (isPrime[i]) {
                prime.add(i);
            }
        }
        int left = 0;
        int right = 0;
        int result = 0;
        int sum = 2;
        int size = prime.size();
        while (left < size && right < size) {
            if (sum == N) {
                result++;
                sum -= prime.get(left);
                left++;
            } else if (sum > N) {
                sum -= prime.get(left);
                left++;
            } else {
                right++;
                if(right >= size)break;
                sum += prime.get(right);
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        BOJ1644.solution();
    }
}
