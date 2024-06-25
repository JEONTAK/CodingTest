package BaekJoon.Gold3.마법사상어와파이어스톰;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ20058 {

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, Q, len = 1;
    static int[][] map, temp;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            len *= 2;
        }
        map = new int[len][len];
        for (int i = 0; i < len; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < len; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int q = Integer.parseInt(st.nextToken());
            compute(q);
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                sum += map[i][j];
            }
        }
        visited = new boolean[len][len];
        int maxI = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    maxI = Math.max(maxI, findIce(i, j));
                }
            }
        }
        System.out.println(sum);
        System.out.println(maxI);
    }

    static int findIce(int x, int y) {
        int cnt = 1;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (isAvailable(nx, ny) && !visited[nx][ny] && map[nx][ny] != 0) {
                    q.offer(new Node(nx,ny));
                    cnt++;
                    visited[nx][ny] = true;
                }
            }
        }
        return cnt;
    }

    static void compute(int q) {
        temp = new int[len][len];
        int sepLen = 1;
        for (int i = 0; i < q; i++) {
            sepLen *= 2;
        }
        for (int i = 0; i < len; i += sepLen) {
            for (int j = 0; j < len; j += sepLen) {
                turn(i, j, sepLen);
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                map[i][j] = temp[i][j];
            }
        }

        reduceIce();
    }

    static void turn(int sX, int sY, int len) {
        int tI = sY + len - 1, tJ = sX;
        for (int i = sX; i < sX + len; i++) {
            for (int j = sY; j < sY + len; j++) {
                temp[tJ][tI] = map[i][j];
                tJ++;
            }
            tJ = sX;
            tI--;
        }
    }

    static void reduceIce() {
        temp = new int[len][len];
        int cnt = 0;
        int nx, ny;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                cnt = 0;
                for (int k = 0; k < 4; k++) {
                    nx = i + dx[k];
                    ny = j + dy[k];
                    if (isAvailable(nx, ny) && map[nx][ny] != 0) {
                        cnt++;
                    }
                }
                if (cnt < 3) {
                    temp[i][j] = (map[i][j] != 0) ? map[i][j] - 1 : 0;
                }else{
                    temp[i][j] = map[i][j];
                }
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                map[i][j] = temp[i][j];
            }
        }
    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < len && y >= 0 && y < len;
    }

    public static void main(String[] args) throws IOException {
        BOJ20058.solution();
    }
}
