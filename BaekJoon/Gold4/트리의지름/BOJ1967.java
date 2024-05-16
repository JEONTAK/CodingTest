package BaekJoon.Gold4.트리의지름;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1967 {

    static class Edge implements Comparable<Edge>{
        int e;
        int d;

        public Edge(int e, int d) {
            this.e = e;
            this.d = d;
        }

        @Override
        public int compareTo(Edge o) {
            return o.d - this.d;
        }
    }

    static int N;
    static ArrayList<Edge>[] list;
    static boolean visited[];
    static int max = 0;
    static int mN = 1;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list[s].add(new Edge(e, d));
            list[e].add(new Edge(s, d));
        }
        visited = new boolean[N + 1];
        compute(1, 0);
        int tempM = max;
        max = 0;
        Arrays.fill(visited, false);
        compute(mN, 0);
        max = Math.max(max, tempM);
        System.out.println(max);
    }

    static void compute(int idx, int dist){
        visited[idx] = true;
        if (dist > max) {
            max = dist;
            mN = idx;
        }

        for (Edge next : list[idx]) {
            if (!visited[next.e]) {
                compute(next.e, dist + next.d);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ1967.solution();
    }
}
