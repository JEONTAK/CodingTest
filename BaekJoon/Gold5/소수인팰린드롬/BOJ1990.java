package BaekJoon.Gold5.소수인팰린드롬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1990 {

    static int a, b;
    static ArrayList<Integer> result = new ArrayList<>();

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        compute(a, b);
        Collections.sort(result);
        result.add(-1);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    static void compute(int a, int b) {
        boolean[] prime = new boolean[b + 1];
        if(b < 2){
            result.add(b);
            return;
        }

        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(b); i++) {
            if (prime[i] == true) {
                continue;
            }

            for (int j = i * i; j < prime.length; j = j + i) {
                prime[j] = true;
            }
        }

        for (int i = a; i < b + 1; i++) {
            if (!prime[i]) {
                isPalindrome(String.valueOf(i));
            }
        }
    }

    static void isPalindrome(String num){
        if (num.length() == 1) {
            result.add(Integer.valueOf(num));
            return;
        }
        int len = num.length() - 1;
        int lenHalf= num.length() / 2;
        int count = 0;
        for (int i = 0; i < lenHalf; i++, len--) {
            if (num.charAt(i) ==  num.charAt(len)) {
                count++;
            }
        }
        if (count == lenHalf) {
            result.add(Integer.valueOf(num));
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ1990.solution();
    }
}
