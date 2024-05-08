package BaekJoon.Gold4.부분합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806 {

    static int N, S;
    static int[] seq;
    static int front, back;
    static int sum = 0;
    static int min = Integer.MAX_VALUE;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        seq = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
            sum += seq[i];
            if (seq[i] >= S) {
                System.out.println(1);
                System.exit(0);
            }
        }
        front = 0;
        back = 0;
        int total = 0;
        if (sum < S) {
            System.out.println(0);
        }else{
            while (front <= N && back <= N) {
                if(total >= S && min > back - front) min = back - front;
                if(total <S) total += seq[back++];
                else total -= seq[front++];
                if (min == 2) {
                    System.out.println(min);
                    System.exit(0);
                }
            }
            System.out.println(min);
        }
    }
    public static void main(String[] args) throws IOException {
        BOJ1806.solution();
    }
}
