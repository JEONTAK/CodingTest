package BaekJoon.Gold3.벽부수고이동하기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14442 {

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int t;
        int wall;

        public Node(int x, int y, int t, int wall) {
            this.x = x;
            this.y = y;
            this.t = t;
            this.wall = wall;
        }

        @Override
        public int compareTo(Node o) {
            return this.t - o.t;
        }
    }

    static int N, M, K;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][][] visited;
    static int result = Integer.MAX_VALUE;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
            }
        }
        Queue<Node> pq = new LinkedList<>();
        visited = new boolean[N][M][K + 1];
        visited[0][0][0] = true;
        pq.offer(new Node(0, 0, 0, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if(cur.t > result) continue;
            if (cur.x == N - 1 && cur.y == M - 1) {
                result = Math.min(result, cur.t + 1);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (isAvailable(nx, ny)) {
                    if (map[nx][ny] == 1) {
                        if (cur.wall < K) {
                            if (!visited[nx][ny][cur.wall + 1]) {
                                visited[nx][ny][cur.wall + 1] = true;
                                pq.offer(new Node(nx, ny, cur.t + 1, cur.wall + 1));
                            }
                        }
                    }else{
                        if (!visited[nx][ny][cur.wall]) {
                            visited[nx][ny][cur.wall] = true;
                            pq.offer(new Node(nx, ny, cur.t + 1, cur.wall));
                        }
                    }
                }
            }
        }
        System.out.println((result == Integer.MAX_VALUE) ? -1 : result);

    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static void main(String[] args) throws IOException {
        BOJ14442.solution();
    }
}
