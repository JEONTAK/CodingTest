package BaekJoon.Gold1.책페이지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] count = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        compute(N);

        for (int i = 0; i < 9; i++) {
            System.out.print(count[i] + " ");
        }
        System.out.print(count[9]);
    }

    static void compute(int num) {
        int start = 1;
        int digit = 1;

        while (start <= num) {
            while (num % 10 != 9 && start <= num) {
                count(num, digit);
                num--;
            }

            if (num < start) {
                break;
            }
            while (start % 10 != 0 && start <= num) {
                count(start, digit);
                start++;
            }

            start /= 10;
            num /= 10;

            for (int i = 0; i < 10; i++) {
                count[i] += (num - start + 1) * digit;
            }

            digit *= 10;

        }
    }

    static void count(int num, int digit) {
        while (num > 0) {
            count[num % 10] += digit;
            num /= 10;
        }
    }
}
