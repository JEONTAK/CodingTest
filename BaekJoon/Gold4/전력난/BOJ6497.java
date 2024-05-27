package BaekJoon.Gold4.전력난;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ6497 {

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

    static int M, N;
    static ArrayList<Node>[] list;
    static long max = 0;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            max = 0;
            if (M == 0 && N == 0) {
                break;
            }
            list = new ArrayList[M];
            for (int i = 0; i < M; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                max += d;
                list[s].add(new Node(e, d));
                list[e].add(new Node(s, d));
            }
            PriorityQueue<Node> pq = new PriorityQueue<>();
            boolean[] visited = new boolean[M];
            long minD = 0;
            pq.add(new Node(0, 0));
            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                if(visited[cur.e]) continue;
                visited[cur.e] = true;
                minD += cur.d;
                for (Node next : list[cur.e]){
                    if (!visited[next.e]) {
                        pq.add(next);
                    }
                }
            }
            System.out.println(max - minD);
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ6497.solution();
    }
}
