package BaekJoon.Gold4.PuyoPuyo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BOJ11559 {

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static char[][] map;
    static int H, W;
    static int idx = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Stack<Node> nq = new Stack<>();

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        H = 12;
        W = 6;
        map = new char[H][W];
        for (int i = 0; i < H; i++) {
            String temp = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = temp.charAt(j);
            }
        }
        while (true) {
            if (puyo()) {
                idx++;
            } else {
                break;
            }
        }
        System.out.println(idx);
    }

     static boolean puyo() {
         boolean flag = false;
         for (int i = 0; i < H; i++) {
             for (int j = 0; j < W; j++) {
                 if (map[i][j] != '.') {
                     if (compute(i, j)) {
                         flag = true;
                     }
                 }
             }
         }

         while (!nq.isEmpty()) {
             Node cur = nq.pop();
             map[cur.x][cur.y] = '.';
         }

         for (int i = H - 2; i >= 0; i--) {
             for (int j = 0; j < W; j++) {
                 if (map[i][j] != '.') {
                     goDown(i, j);
                 }
             }
         }
         return flag;
    }

    static boolean compute(int x, int y) {
        boolean[][] visited = new boolean[H][W];
        Queue<Node> q = new LinkedList<>();
        char color = map[x][y];
        int sum = 0;
        q.add(new Node(x, y));
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            nq.add(cur);
            sum++;
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (isAvailable(nx, ny) && !visited[nx][ny]) {
                    if (map[nx][ny] == color) {
                        q.add(new Node(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        if(sum <= 3){
            for (int i = 0; i < sum; i++) {
                nq.pop();
            }
            return false;
        }else{
            return true;
        }
    }

    static void goDown(int i, int j) {
        char color = map[i][j];
        map[i][j] = '.';
        int nx = i;
        while (true) {
            nx++;
            if (map[nx][j] != '.') {
                map[nx - 1][j] = color;
                break;
            }
            if (nx == H - 1) {
                map[nx][j] = color;
                break;
            }
        }
    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < H && y >= 0 && y < W;
    }

    public static void main(String[] args) throws IOException {
        BOJ11559.solution();
    }
}
