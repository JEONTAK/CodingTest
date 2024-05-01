package BaekJoon.Gold5.최소회의실개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ19598 {

    static class Lecture implements Comparable<Lecture>{
        int time;
        boolean isStart;

        public Lecture(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Lecture o) {
            return this.time - o.time;
        }
    }
    static int N;
    static PriorityQueue<Lecture> pq = new PriorityQueue<>();
    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.add(new Lecture(s, true));
            pq.add(new Lecture(e, false));
        }

        int rooms = 0;
        int ans = 0;

        while (!pq.isEmpty()) {
            Lecture cur = pq.poll();

            if (cur.isStart) {
                rooms++;
                ans = Math.max(ans, rooms);
            }else{
                rooms--;
            }
        }
        System.out.println(ans);
    }


    public static void main(String[] args) throws IOException {
        BOJ19598.solution();
    }
}
