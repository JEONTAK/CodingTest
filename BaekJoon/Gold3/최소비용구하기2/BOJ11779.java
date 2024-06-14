package BaekJoon.Gold3.최소비용구하기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11779 {

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
    static int[] dist, route;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list[s].add(new Node(e, d));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];
        route = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist[cur.e] < cur.d) continue;

            for (Node next : list[cur.e]) {
                if (dist[next.e] > dist[cur.e] + next.d) {
                    dist[next.e] = dist[cur.e] + next.d;
                    route[next.e] = cur.e;
                    pq.offer(new Node(next.e, dist[next.e]));
                }
            }
        }

        System.out.println(dist[end]);
        Stack<Integer> s = new Stack<>();
        s.push(end);
        int cnt = 0;
        while (route[end] != 0) {
            cnt++;
            s.push(route[end]);
            end = route[end];
        }
        System.out.println(cnt + 1);
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ11779.solution();
    }
}
