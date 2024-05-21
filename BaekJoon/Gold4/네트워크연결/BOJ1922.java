package BaekJoon.Gold4.네트워크연결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1922 {

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
    static int N, M;
    static ArrayList<Node>[] list;
    static boolean[] visited;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer st;
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
            list[e].add(new Node(s, d));
        }
        visited = new boolean[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        int result = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.e]) continue;
            visited[cur.e] = true;
            result += cur.d;
            for (Node next : list[cur.e]) {
                if (!visited[next.e]) {
                    pq.add(next);
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        BOJ1922.solution();
    }
}
