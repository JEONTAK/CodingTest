package BaekJoon.Gold4.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1753 {

    static class Edge implements Comparable<Edge>{
        int e;
        int d;

        public Edge(int e, int d) {
            this.e = e;
            this.d = d;
        }

        @Override
        public int compareTo(Edge o) {
            return this.d - o.d;
        }
    }

    static int V, E, start;
    static int[] dist;
    static ArrayList<Edge>[] list;
    static boolean[] visited;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        dist = new int[V + 1];
        list = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list[x].add(new Edge(y, d));

        }
        compute();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }else{
                System.out.println(dist[i]);
            }
        }
    }

    static void compute(){
        PriorityQueue<Edge> q = new PriorityQueue<>();
        visited = new boolean[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        q.add(new Edge(start, 0));
        while (!q.isEmpty()) {
            Edge curEdge = q.poll();
            int cur = curEdge.e;
            if(!visited[cur]) visited[cur] = true;
            for (Edge edge : list[cur]) {
                if (!visited[edge.e] && dist[edge.e] > curEdge.d + edge.d) {
                    dist[edge.e] = dist[cur] + edge.d;
                    q.add(new Edge(edge.e, dist[edge.e]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ1753.solution();
    }
}
