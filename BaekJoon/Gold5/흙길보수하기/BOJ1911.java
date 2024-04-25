package BaekJoon.Gold5.흙길보수하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1911 {

    static class Water implements Comparable<Water> {
        int x;
        int y;

        public Water(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Water o) {
            return this.x - o.x;
        }
    }
    static int N, L;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        PriorityQueue<Water> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.offer(new Water(x,y));
        }
        int result = 0;
        int curIdx = 0;
        while (!pq.isEmpty()) {
            Water w = pq.poll();
            if (w.y < curIdx) {
                continue;
            }
            if (curIdx < w.x) {
                curIdx = w.x;
            }
            int remain = (w.y - curIdx) % L;
            result += (w.y - curIdx) / L;
            curIdx = w.y;
            if (remain != 0) {
                result++;
                curIdx += L - remain;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        BOJ1911.solution();
    }
}
