package BaekJoon.Gold4.특정한최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1504 {

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

    static int N, E, V1, V2;
    static ArrayList<Node>[] graph;
    static boolean visited[];
    static int[] dist;
    static final int INF = 200000000;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph[s].add(new Node(e, d));
            graph[e].add(new Node(s, d));
        }
        st = new StringTokenizer(br.readLine());
        V1 = Integer.parseInt(st.nextToken());
        V2 = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];

        int result1 = 0;
        result1 += compute(1, V1);
        result1 += compute(V1, V2);
        result1 += compute(V2, N);


        int result2 = 0;
        result2 += compute(1, V2);
        result2 += compute(V2, V1);
        result2 += compute(V1, N);

        int answer = (result1 >= INF && result2 >= INF) ? -1 : Math.min(result1, result2);
        System.out.println(answer);
    }

    static int compute(int start, int end){

        Arrays.fill(dist, INF);
        visited = new boolean[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (!visited[cur.e]) {
                visited[cur.e] = true;
                for (Node next : graph[cur.e]) {
                    if (!visited[next.e] && dist[next.e] > dist[cur.e] + next.d) {
                        dist[next.e] = dist[cur.e] + next.d;
                        pq.add(new Node(next.e, dist[next.e]));
                    }
                }
            }
        }
        return dist[end];
    }

    public static void main(String[] args) throws IOException {
        BOJ1504.solution();
    }
}
