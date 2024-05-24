package BaekJoon.Gold4.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ4803 {

    static int N, M;
    static int[] parent;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int idx = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) {
                break;
            }
            parent = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                union(s, e);
            }

            HashSet<Integer> set = new HashSet<>();
            for (int i = 1; i <= N; i++) {
                int cur = find(i);
                if (cur > 0) {
                    set.add(cur);
                }
            }
            int cnt = set.size();
            if (cnt == 0) {
                sb.append("Case " + idx + ": No trees.");
            } else if (cnt == 1) {
                sb.append("Case " + idx + ": There is one tree.");
            }else{
                sb.append("Case " + idx + ": A forest of " + cnt + " trees.");
            }
            sb.append("\n");
            idx++;
        }
        System.out.println(sb);
    }

    static int find(int x) {
        if(x == parent[x]) return x;
        return find(parent[x]);
    }

    static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (ry < rx) {
            int tmp = rx;
            rx = ry;
            ry = tmp;
        }

        if (rx == ry) {
            parent[rx] = 0;
        }else{
            parent[ry] = rx;
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ4803.solution();
    }
}
