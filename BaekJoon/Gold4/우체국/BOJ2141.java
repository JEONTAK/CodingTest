package BaekJoon.Gold4.우체국;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ2141 {

    static class House implements Comparable<House> {
        long l;
        long p;

        public House(long l, long p) {
            this.l = l;
            this.p = p;
        }

        @Override
        public int compareTo(House o) {
            if(this.l - o.l < 0) return -1;
            else if(this.l - o.l > 0) return 1;
            else return 0;
        }
    }

    static int N;
    static long result = 0, pS = 0;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<House> pq = new PriorityQueue<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long s = Integer.parseInt(st.nextToken());
            long p = Integer.parseInt(st.nextToken());
            pq.add(new House(s, p));
            pS += p;
        }
        long people = 0;
        for (int i = 0; i < N; i++) {
            House cur = pq.poll();
            people += cur.p;
            if ((pS + 1) / 2 <= people) {
                result = cur.l;
                break;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        BOJ2141.solution();
    }
}
