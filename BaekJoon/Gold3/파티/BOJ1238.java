package BaekJoon.Gold3.파티;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1238 {
    static class Node implements Comparable<Node> {

        int e;
        int d;

        public Node(int e, int d) {
            this.e = e;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            return this.d - o.d;
        }
    }

    static int N, M, X;
    static ArrayList<Node>[] list;
    static int[][] dist;
    static boolean[] visited;
    static final int INF = 10_000_000;
    static int max = 0;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list[s].add(new Node(e, d));
        }
        dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for (int i = 1; i <= N; i++) {
            compute(i);
        }
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dist[i][X] + dist[X][i]);
        }
        System.out.println(max);
    }

    static void compute(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        visited = new boolean[N + 1];
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if(visited[cur.e]) continue;
            visited[cur.e] = true;
            for (Node next : list[cur.e]) {
                if (!visited[next.e] && dist[start][next.e] > dist[start][cur.e] + next.d) {
                    dist[start][next.e] = dist[start][cur.e] + next.d;
                    pq.offer(new Node(next.e, dist[start][next.e]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ1238.solution();
    }
}
