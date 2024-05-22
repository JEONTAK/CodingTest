package BaekJoon.Gold4.이모티콘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ14226 {

    static class Emoji implements Comparable<Emoji>{
        int s;
        int t;
        int c;

        public Emoji(int s, int t, int c) {
            this.s = s;
            this.t = t;
            this.c = c;
        }

        @Override
        public int compareTo(Emoji o) {
            return this.t - o.t;
        }
    }

    static int S;
    static boolean[][] visited;
    static final int MAX = 2001;
    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        visited = new boolean[MAX][MAX];
        Queue<Emoji> q = new LinkedList<>();
        q.add(new Emoji(1, 0, 0));
        while (!q.isEmpty()) {
            Emoji cur = q.poll();
            if (cur.s == S) {
                System.out.println(cur.t);
                return;
            }
            if (isAvailable(cur.s) && !visited[cur.s][cur.s]) {
                visited[cur.s][cur.s] = true;
                q.offer(new Emoji(cur.s, cur.t + 1, cur.s));
            }
            if (isAvailable(cur.s - 1) && !visited[cur.s -1][cur.c]) {
                visited[cur.s - 1][cur.c] = true;
                q.offer(new Emoji(cur.s - 1, cur.t + 1, cur.c));
            }
            if (isAvailable(cur.s + cur.c) && !visited[cur.s + cur.c][cur.c]) {
                visited[cur.s + cur.c][cur.c] = true;
                q.offer(new Emoji(cur.s + cur.c, cur.t + 1, cur.c));
            }
        }
    }

    static boolean isAvailable(int s){
        return s > 0 && s < 2000;
    }

    public static void main(String[] args) throws IOException {
        BOJ14226.solution();
    }
}
