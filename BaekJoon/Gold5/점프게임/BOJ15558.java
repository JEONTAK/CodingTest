package BaekJoon.Gold5.점프게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ15558 {
    static class Location{
        int idx;
        int lr;
        int loss;

        public Location(int idx, int lr, int loss) {
            this.idx = idx;
            this.lr = lr;
            this.loss = loss;
        }
    }
    static int N, K;
    static boolean[][] map;
    static int[] delta;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        delta = new int[]{1, -1, K};
        map = new boolean[N + 1 + K][2];
        for (int i = 0; i < 2; i++) {
            String temp = br.readLine();
            for (int j = 1; j <= N; j++) {
                if (Integer.parseInt(String.valueOf(temp.charAt(j - 1))) == 1) {
                    map[j][i] = true;
                }
            }
            for (int j = N + 1; j < N + K + 1; j++) {
                map[j][i] = true;
            }
        }
        Queue<Location> q = new LinkedList<>();
        q.add(new Location(1, 0, 0));
        while (!q.isEmpty()) {
            Location cur = q.poll();
            if (cur.idx > N) {
                System.out.println(1);
                System.exit(0);
            }
            for (int i = 0; i < 3; i++) {
                int nextIdx = cur.idx + delta[i];
                int nextLR = cur.lr;
                if (i == 2) {
                    nextLR = (cur.lr == 0) ? 1 : 0;
                }
                if (nextIdx > cur.loss + 1 && map[nextIdx][nextLR]) {
                    map[nextIdx][nextLR] = false;
                    q.add(new Location(nextIdx, nextLR, cur.loss + 1));
                }
            }
        }
        System.out.println(0);
    }
    public static void main(String[] args) throws IOException {
        BOJ15558.solution();
    }
}
