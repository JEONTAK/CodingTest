package BaekJoon.Gold5.용액합성하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14921 {

    static int N;
    static int[] water;
    static int min = Integer.MAX_VALUE;
    static int minTrue;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        water = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            water[i] = Integer.parseInt(st.nextToken());
        }
        int front = 0, back = N - 1;
        while (front < back) {
            int curSum = water[front] + water[back];
            if (Math.abs(curSum) < min) {
                min = Math.abs(curSum);
                minTrue = curSum;
                if (minTrue == 0) {
                    break;
                }
            }
            if (curSum < 0) {
                front++;
            } else {
                back--;
            }
        }
        System.out.println(minTrue);
    }

    public static void main(String[] args) throws IOException {
        BOJ14921.solution();
    }
}
