package BaekJoon.Gold5.백도어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17396 {

    static class Map implements Comparable<Map> {

        int toward;
        long c;

        public Map(int toward, long c) {
            this.toward = toward;
            this.c = c;
        }

        @Override
        public int compareTo(Map o) {
            if(this.c - o.c > 0) return 1;
            else return -1;
        }
    }
    static int N, M;
    static int[] visible;
    static long[] min;
    static ArrayList<Map>[] list;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visible = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visible[i] = Integer.parseInt(st.nextToken());
        }
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[x].add(new Map(y, c));
            list[y].add(new Map(x,c));
        }

        min = new long[N];
        Arrays.fill(min, Long.MAX_VALUE);
        min[0] = 0;
        compute();
        if (min[N - 1] == Long.MAX_VALUE) {
            System.out.println(-1);
        }else{
            System.out.println(min[N - 1]);
        }
    }

    static void compute(){
        PriorityQueue<Map> q = new PriorityQueue<>();
        boolean[] visited = new boolean[N];
        q.offer(new Map(0, 0));
        while (!q.isEmpty()) {
            Map cur = q.poll();
            if(visited[cur.toward]) continue;
            visited[cur.toward] = true;
            for (int i = 0; i < list[cur.toward].size(); i++) {
                Map next = list[cur.toward].get(i);
                if(next.toward != N - 1 && visible[next.toward] == 1) continue;
                if (min[next.toward] > min[cur.toward] + next.c) {
                    min[next.toward] = min[cur.toward] + next.c;
                    q.offer(new Map(next.toward, min[next.toward]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ17396.solution();
    }
}
