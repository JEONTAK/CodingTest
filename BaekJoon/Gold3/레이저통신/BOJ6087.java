package BaekJoon.Gold3.레이저통신;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ6087 {

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int d;
        int cnt;

        public Node(int x, int y, int d, int cnt) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return this.cnt - o.cnt;
        }
    }

    static int W, H;
    static char[][] map;
    static int sX = -1,sY = -1, fX = -1, fY = -1;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int[][][] visited;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        for (int i = 0; i < H; i++) {
            String temp = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = temp.charAt(j);
                if (map[i][j] == 'C') {
                    if (sX == -1) {
                        sX = i;
                        sY = j;
                    }else{
                        fX = i;
                        fY = j;
                    }
                }
            }
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        visited = new int[4][H][W];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < H; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }
        pq.offer(new Node(sX, sY, -5, -1));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.x == fX && cur.y == fY) {
                System.out.println(cur.cnt);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nCnt = (cur.d == i) ? cur.cnt : cur.cnt + 1;
                if (!isAvailable(nx, ny) || map[nx][ny] == '*' || Math.abs(cur.d - i) == 2) {
                    continue;
                }
                if (visited[i][nx][ny] > nCnt) {
                    pq.offer(new Node(nx, ny, i, nCnt));
                    visited[i][nx][ny] = nCnt;
                }
            }
        }
    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < H && y >= 0 && y < W;
    }

    public static void main(String[] args) throws IOException {
        BOJ6087.solution();
    }
}
