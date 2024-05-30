package BaekJoon.Gold4.친구비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ16562 {

    static class Node implements Comparable<Node>{
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

    static int N, M, K;
    static ArrayList<Node>[] list;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            list[0].add(new Node(i, Integer.parseInt(st.nextToken())));
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(new Node(e, 0));
            list[e].add(new Node(s, 0));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));
        boolean[] visited = new boolean[N + 1];
        int dist = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist > K) {
                System.out.println("Oh no");
                System.exit(0);
            }
            if(visited[cur.e]) continue;
            visited[cur.e] = true;
            dist += cur.d;
            for (Node next : list[cur.e]) {
                if (!visited[next.e]) {
                    pq.add(next);
                }
            }
        }
        System.out.println(dist);
    }

    public static void main(String[] args) throws IOException {
        BOJ16562.solution();
    }
}
