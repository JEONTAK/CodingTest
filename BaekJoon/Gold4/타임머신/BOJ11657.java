package BaekJoon.Gold4.타임머신;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11657 {

    static class Node{

        int s;
        int e;
        int d;

        public Node(int s, int e, int d) {
            this.s = s;
            this.e = e;
            this.d = d;
        }

    }
    static int N, M;
    static ArrayList<Node> list;
    static long[] dist;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        dist = new long[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list.add(new Node(s, e, d));
        }
        Arrays.fill(dist, Long.MAX_VALUE);
        if (compute(1)) {
            System.out.println(-1);
        }else{
            for (int i = 2; i <= N; i++) {
                System.out.print(dist[i] != Long.MAX_VALUE ? dist[i] : -1);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    static boolean compute(int start){
        dist[start] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                Node cur = list.get(j);
                if (dist[cur.s] != Long.MAX_VALUE && dist[cur.e] > dist[cur.s] + cur.d) {
                    dist[cur.e] = dist[cur.s] + cur.d;
                    if (i == N) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BOJ11657.solution();
    }
}
