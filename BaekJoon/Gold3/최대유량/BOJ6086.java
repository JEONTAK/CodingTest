package BaekJoon.Gold3.최대유량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ6086 {

    static int N, len = 52;
    static int[][] f, c;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        f = new int[len][len];
        c = new int[len][len];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = atoi(st.nextToken().charAt(0));
            int e = atoi(st.nextToken().charAt(0));
            int d = Integer.parseInt(st.nextToken());
            c[s][e] += d;
            c[e][s] += d;
        }

        int totalF = 0;
        int src = 0, sink = 25;
        int[] parent = new int[len];
        Queue<Integer> q;
        while(true){
            Arrays.fill(parent, -1);
            q = new LinkedList<>();
            parent[src] = src;
            q.offer(src);
            while (!q.isEmpty() && parent[sink] == -1) {
                int cur = q.poll();
                for (int next = 0; next < len; next++) {
                    if (c[cur][next] - f[cur][next] > 0 && parent[next] == -1) {
                        q.offer(next);
                        parent[next] = cur;
                    }
                }
            }

            if (parent[sink] == -1) {
                break;
            }

            int amount = Integer.MAX_VALUE;
            for (int i = sink; i != 0; i = parent[i]) {
                amount = Math.min(c[parent[i]][i] - f[parent[i]][i], amount);
            }
            for (int i = sink; i != 0; i = parent[i]) {
                f[parent[i]][i] += amount;
                f[i][parent[i]] -= amount;
            }
            totalF += amount;
        }
        System.out.println(totalF);
    }

    static int atoi(char c) {
        if('A' <= c && c <= 'Z') return (c - 65);
        else if('a' <= c && c <= 'z') return c - 71;
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BOJ6086.solution();
    }
}
