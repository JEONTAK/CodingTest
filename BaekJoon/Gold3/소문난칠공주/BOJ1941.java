package BaekJoon.Gold3.소문난칠공주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1941 {

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static final int N = 5;
    static char[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int result = 0;
    static boolean[] visited;
    static int[] seq = new int[7];

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = temp.charAt(j);
            }
        }
        compute(0, 0, 0);
        System.out.println(result);
    }

    static void compute(int d, int Y, int start) {
        if(Y >= 4) return;
        if (d == 7) {
            visited = new boolean[7];
            BFS();
            return;
        }
        for (int i = start; i < 25; i++) {
            seq[d] = i;
            if (map[i / 5][i % 5] == 'Y') {
                compute(d + 1, Y + 1, i + 1);
            }else{
                compute(d + 1, Y, i + 1);
            }
        }
    }

    static void BFS(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(seq[0] / 5, seq[0] % 5));
        visited[0] = true;
        int connect = 1;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int ni = nx * 5 + ny;
                if (isAvailable(nx, ny)) {
                    for (int j = 0; j < 7; j++) {
                        if (!visited[j] && seq[j] == ni) {
                            q.offer(new Node(nx, ny));
                            visited[j] = true;
                            connect++;
                        }
                    }
                }
            }
        }
        if (connect == 7) {
            result++;
        }
    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }

    public static void main(String[] args) throws IOException {
        BOJ1941.solution();
    }
}
