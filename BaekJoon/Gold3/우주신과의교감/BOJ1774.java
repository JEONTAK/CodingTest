package BaekJoon.Gold3.우주신과의교감;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1774 {

    static class Alien {
        int idx;
        double x;
        double y;

        public Alien(int idx, double x, double y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge>{
        int s;
        int e;
        double d;

        public Edge(int s, int e, double d) {
            this.s = s;
            this.e = e;
            this.d = d;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.d < o.d) {
                return -1;
            }
            return 1;
        }
    }

    static int N, M;
    static Alien[] aliens;
    static int[] parent;
    static ArrayList<Edge> list;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        aliens = new Alien[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            aliens[i] = new Alien(i, x, y);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                double d = Math.sqrt(Math.pow(aliens[i].x - aliens[j].x, 2) + Math.pow(aliens[i].y - aliens[j].y, 2));
                list.add(new Edge(aliens[i].idx, aliens[j].idx, d));
            }
        }
        Collections.sort(list);

        double result = 0;

        for (int i = 0; i < list.size(); i++) {
            Edge cur = list.get(i);
            if (find(cur.s) != find(cur.e)) {
                result += cur.d;
                union(cur.s, cur.e);
            }
        }

        String r = String.format("%.2f", result);
        System.out.println(r);

    }

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ1774.solution();
    }
}
