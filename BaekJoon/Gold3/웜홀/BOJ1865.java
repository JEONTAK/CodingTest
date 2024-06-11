package BaekJoon.Gold3.웜홀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1865 {

    static class Node{
        int e;
        int d;

        public Node(int e, int d) {
            this.e = e;
            this.d = d;
        }
    }

    static int TC, N, M, W;
    static ArrayList<Node>[] list;
    static int[] dist;
    static final int INF = 1_000_000_000;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        TC = Integer.parseInt(br.readLine());
        for (int a = 0; a < TC; a++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
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
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                list[s].add(new Node(e, d * -1));
            }
            boolean flag = false;
            for (int i = 1; i <= N; i++) {
                if (compute(i)) {
                    flag = true;
                    sb.append("YES\n");
                    break;
                }
            }
            if (!flag) {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }

    static boolean compute(int start) {
        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        boolean visited = false;
        for (int i = 1; i < N; i++) {
            visited = false;
            for (int j = 1; j <= N; j++) {
                for (Node next : list[j]) {
                    if (dist[j] != INF && dist[next.e] > dist[j] + next.d) {
                        dist[next.e] = dist[j] + next.d;
                        visited = true;
                    }
                }
            }

            if(!visited)break;
        }

        if (visited) {
            for (int i = 1; i <= N; i++) {
                for (Node next : list[i]) {
                    if (dist[i] != INF && dist[next.e] > dist[i] + next.d) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BOJ1865.solution();
    }
}
