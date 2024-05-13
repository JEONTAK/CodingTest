package BaekJoon.Gold4.플로이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ11404 {

    static class Bus implements Comparable<Bus>{
        int e;
        int d;

        public Bus(int e, int d) {
            this.e = e;
            this.d = d;
        }

        @Override
        public int compareTo(Bus o) {
            return this.d - o.d;
        }
    }

    static int N, M;
    static int[][] city;
    static ArrayList<Bus>[] list;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        city = new int[N + 1][N + 1];
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            Arrays.fill(city[i], Integer.MAX_VALUE);
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list[s].add(new Bus(e, d));
        }
        for (int i = 1; i <= N; i++) {
            city[i][i] = 0;
            compute(i);
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print((city[i][j] != Integer.MAX_VALUE) ? city[i][j] : 0);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    static void compute(int start){
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        pq.add(new Bus(start, 0));
        boolean[] visited = new boolean[N + 1];
        while (!pq.isEmpty()) {
            Bus curB = pq.poll();
            if(!visited[curB.e]) visited[curB.e] = true;
            for (Bus nextB : list[curB.e]) {
                if (!visited[nextB.e] && city[start][nextB.e] > city[start][curB.e] + nextB.d) {
                    city[start][nextB.e] = city[start][curB.e] + nextB.d;
                    pq.add(new Bus(nextB.e, city[start][nextB.e]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ11404.solution();
    }
}
