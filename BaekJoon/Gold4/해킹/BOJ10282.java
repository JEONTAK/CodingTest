package BaekJoon.Gold4.해킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ10282 {

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
    static int T, N, D, C;
    static ArrayList<Node>[] list;
    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int a = 0; a < T; a++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            list = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                list[e].add(new Node(s, d));
            }
            PriorityQueue<Node> pq = new PriorityQueue<>();
            boolean[] visited = new boolean[N + 1];
            int[] dist = new int[N + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[C] = 0;
            pq.add(new Node(C, 0));
            int cnt = 0;
            int time = 0;
            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                if(visited[cur.e]) continue;
                visited[cur.e] = true;
                cnt++;
                for (Node next : list[cur.e]) {
                    if (!visited[next.e] && dist[next.e] > dist[cur.e] + next.d) {
                        dist[next.e] = dist[cur.e] + next.d;
                        pq.add(new Node(next.e, dist[next.e]));
                    }
                }
            }
            for (int i = 1; i <= N; i++) {
                if (dist[i] != Integer.MAX_VALUE) {
                    time = Math.max(time, dist[i]);
                }
            }
            System.out.println(cnt + " " + time);
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ10282.solution();
    }
}
