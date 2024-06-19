package BaekJoon.Gold3.LCA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11437 {

    static int N, M;
    static int[] parent, depth;
    static ArrayList<Integer>[] list;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        parent = new int[N + 1];
        depth = new int[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(e);
            list[e].add(s);
        }

        set(1, 1, 0);

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(compute(s, e) + "\n");
        }
        System.out.println(sb.toString());
    }

    static int compute(int a, int b) {
        int ah = depth[a];
        int bh = depth[b];
        while (ah > bh) {
            a = parent[a];
            ah--;
        }
        while (bh > ah) {
            b = parent[b];
            bh--;
        }
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }

    static void set(int cur, int h, int p) {
        depth[cur] = h;
        parent[cur] = p;
        for (int next : list[cur]) {
            if (next != p) {
                set(next, h + 1, cur);
            }
        }
    }

    static int find(int x) {
        if(x == parent[x]) return x;
        return find(parent[x]);
    }

    public static void main(String[] args) throws IOException {
        BOJ11437.solution();
    }
}
