package BaekJoon.ACM_Craft;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int K;
    static int[] D;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();

        for (int i = 0; i < testcase; i++) {
            N = sc.nextInt();
            K = sc.nextInt();
            D = new int[N + 1];
            boolean[][] matrix = new boolean[N + 1][N + 1];
            int[] link = new int[N + 1];

            for (int j = 1; j <= N; j++) {
                D[j] = sc.nextInt();
            }
            for (int j = 0; j < K; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                matrix[x][y] = true;
                link[y]++;
            }

            int fin = sc.nextInt();
            int[] result = compute(D, matrix, link);
            System.out.println(result[fin]);
        }
    }

    private static int[] compute(int[] D, boolean[][] matrix, int[] link) {
        Queue<Integer> queue = new LinkedList<>();

        int[] result = new int[link.length];

        for (int i = 1; i < link.length; i++) {

            if (link[i] == 0) {
                result[i] = D[i];
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int prev = queue.poll();

            for (int i = 1; i < link.length; i++) {
                if (matrix[prev][i]) {
                    result[i] = Math.max(result[i], result[prev] + D[i]);

                    --link[i];

                    if (link[i] == 0) {
                        queue.add(i);
                    }
                }
            }
        }

        return result;

    }
}
