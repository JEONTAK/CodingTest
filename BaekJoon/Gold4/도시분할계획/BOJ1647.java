package BaekJoon.Gold4.도시분할계획;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1647 {

    static class House implements Comparable<House>{
        int e;
        int d;

        public House(int e, int d) {
            this.e = e;
            this.d = d;
        }

        @Override
        public int compareTo(House o) {
            return this.d - o.d;
        }
    }
    static int N, M;
    static ArrayList<House>[] list;
    static int result;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list[s].add(new House(e, d));
            list[e].add(new House(s, d));
        }
        PriorityQueue<House> pq = new PriorityQueue<>();
        pq.add(new House(1, 0));
        result = 0;
        int max = 0;
        boolean[] visited = new boolean[N + 1];
        while (!pq.isEmpty()) {
            House cur = pq.poll();
            if(visited[cur.e]) continue;
            visited[cur.e] = true;
            result += cur.d;
            max = Math.max(max, cur.d);
            for (House next : list[cur.e]) {
                if (!visited[next.e]) {
                    pq.add(next);
                }
            }
        }
        System.out.println(result - max);
    }

    public static void main(String[] args) throws IOException {
        BOJ1647.solution();
    }
}
