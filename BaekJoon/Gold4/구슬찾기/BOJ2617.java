package BaekJoon.Gold4.구슬찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2617 {
    static class Ball{
        int e;
        int d;

        public Ball(int e, int d) {
            this.e = e;
            this.d = d;
        }
    }
    static int N, M;
    static ArrayList<Ball>[] ball;
    static int[][] dist;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ball = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            ball[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ball[a].add(new Ball(b, 1));
        }
        dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        for (int i = 1; i <= N; i++) {
            compute(i);
        }
        int[] row = new int[N + 1];
        int[] col = new int[N +1];
        int result = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i == j || dist[i][j] == Integer.MAX_VALUE) continue;
                row[i]++;
                col[j]++;
            }
        }
        int mid = (N + 1) / 2;
        for (int i = 1; i <= N; i++) {
            if(row[i] >= mid) result++;
            if(col[i] >= mid) result++;
        }
        System.out.println(result);
    }
    static void compute(int start) {
        boolean[] visited = new boolean[N + 1];
        Queue<Ball> q = new LinkedList<>();
        q.add(new Ball(start, 0));

        while (!q.isEmpty()) {
            Ball cur = q.poll();
            if(visited[cur.e]) continue;
            visited[cur.e] = true;
            for (Ball next : ball[cur.e]) {
                if (!visited[next.e] && dist[start][next.e] > dist[start][cur.e] + next.d) {
                    dist[start][next.e] = dist[start][cur.e] + next.d;
                    q.add(new Ball(next.e, dist[start][next.e]));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BOJ2617.solution();
    }
}