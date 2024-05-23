package BaekJoon.Gold4.운동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1956 {

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
    static int V, E;
    static ArrayList<Node>[] list;
    static final int MAX = 1_000_000_000;
    static int min = MAX;
    static int[] dist;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list[s].add(new Node(e, d));
        }

        for (int i = 1; i <= V; i++) {
            dist = new int[V + 1];
            Arrays.fill(dist, MAX);
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(i, 0));
            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                if (cur.e == i && cur.d != 0) {
                    min = Math.min(min, cur.d);
                    break;
                }
                if (dist[cur.e] < cur.d) {
                    continue;
                }
                for (Node next : list[cur.e]) {
                    if (dist[next.e] > next.d + cur.d) {
                        dist[next.e] = next.d + cur.d;
                        pq.add(new Node(next.e, dist[next.e]));
                    }
                }
            }
        }
        System.out.println((min != MAX) ? min : -1);
    }

    public static void main(String[] args) throws IOException {
        BOJ1956.solution();
    }
}
