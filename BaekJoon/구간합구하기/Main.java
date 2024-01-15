package BaekJoon.구간합구하기;

import java.util.Scanner;

public class Main {

    static long[] numbers;

    static long[] input;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N;
        int M;
        int K;

        int a, b;
        long c;

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        numbers = new long[4 * N];
        input = new long[N];

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextLong();
        }

        init(0, N - 1, 1);

        for (int i = 0; i < M + K; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextLong();

            if (a == 1) {
                long dif = c - input[b - 1];
                input[b - 1] = c;
                update(0, N - 1, 1, b - 1, dif);
            } else {
                System.out.println(compute(0, N - 1, 1, b - 1, (int) c - 1));
            }
        }
    }

    public static long init(int start, int end, int node) {
        if (start == end) {
            return numbers[node] = input[start];
        }
        int mid = (start + end) / 2;
        return numbers[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    public static long compute(int start, int end, int node, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return numbers[node];
        }
        int mid = (start + end) / 2;
        return compute(start, mid, node * 2, left, right) + compute(mid + 1, end, node * 2 + 1, left, right);

    }

    public static void update(int start, int end, int node, int index, long dif) {
        if (index < start || index > end) {
            return;
        }
        numbers[node] += dif;
        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;
        update(start, mid, node * 2, index, dif);
        update(mid + 1, end, node * 2 + 1, index, dif);
    }
}
