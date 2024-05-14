package BaekJoon.Gold4.숨바꼭질2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ12851 {

    static class Subin implements Comparable<Subin> {
        int x;
        int t;

        public Subin(int x, int t) {
            this.x = x;
            this.t = t;
        }

        @Override
        public int compareTo(Subin o) {
            return this.t - o.t;
        }
    }

    static int N, K;
    static int time = Integer.MAX_VALUE;
    static int visited[];
    static int cnt;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[100001];
        Queue<Subin> q = new LinkedList<>();
        q.add(new Subin(N, 0));
        visited[N] = 1;
        while (!q.isEmpty()) {
            Subin cur = q.poll();
            if (cur.x == K) {
                if (cnt == 0) {
                    time = cur.t;
                }
                if (time == cur.t) {
                    cnt++;
                }
                continue;
            }

            for (int i = 0; i < 3; i++) {
                int nx;
                if(i == 0) nx = cur.x + 1;
                else if(i == 1) nx = cur.x - 1;
                else nx = cur.x * 2;

                if(nx < 0 || nx > 100000) continue;

                if (visited[nx] == 0 || visited[nx] == cur.t + 1) {
                    visited[nx] = cur.t + 1;
                    q.add(new Subin(nx, cur.t + 1));
                }
            }
        }
        System.out.println(time);
        System.out.println(cnt);
    }
    public static void main(String[] args) throws IOException {
        BOJ12851.solution();
    }
}
