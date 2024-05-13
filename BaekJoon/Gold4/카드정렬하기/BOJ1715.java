package BaekJoon.Gold4.카드정렬하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1715 {

    static int N;
    static int[] cards;
    static int min = 0;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(br.readLine());
            pq.add(cards[i]);
        }
        while (!pq.isEmpty()) {
            if (pq.size() == 1) {
                System.out.println(min);
                break;
            }
            int f = pq.poll();
            int s = pq.poll();
            pq.add(f + s);
            min += f + s;
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ1715.solution();
    }
}
