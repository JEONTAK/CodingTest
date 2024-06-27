package BaekJoon.Gold3.움직이는미로탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ16954 {

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static final int N = 8;
    static char[][] map = new char[N][N];
    static boolean[][] visited;
    static int sX = 7, sY = 0;
    static int[][] delta = {{0, 0}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = temp.charAt(j);
            }
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(sX, sY));
        while (!q.isEmpty()) {
            int size = q.size();
            visited = new boolean[N][N];
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if(map[cur.x][cur.y] == '#') continue;

                if (cur.x == 0 && cur.y == 7) {
                    System.out.println(1);
                    return;
                }

                for (int j = 0; j < 9; j++) {
                    int nx = cur.x + delta[j][0];
                    int ny = cur.y + delta[j][1];

                    if (isAvailable(nx, ny) && !visited[nx][ny] && map[nx][ny] != '#') {
                        q.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
            moveWall();
        }
        System.out.println(0);
    }

    static void moveWall() {
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '#') {
                    map[i][j] = '.';
                    if (i != N - 1) {
                        map[i + 1][j] = '#';
                    }
                }
            }
        }
    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static void main(String[] args) throws IOException {
        BOJ16954.solution();
    }
}
