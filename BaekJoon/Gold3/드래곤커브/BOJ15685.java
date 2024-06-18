package BaekJoon.Gold3.드래곤커브;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15685 {

    static int N;
    static boolean[][] map = new boolean[101][101];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};


    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            compute(x, y, d, g);
        }
        int result = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    static void compute(int x, int y, int d, int g) {
        ArrayList<Integer> list =  new ArrayList<>();
        list.add(d);
        for (int i = 0; i < g; i++) {
            for (int j = list.size() - 1; j >= 0; j--) {
                list.add((list.get(j) + 1) % 4);
            }
        }
        map[y][x] = true;
        for (int direct : list) {
            x += dx[direct];
            y += dy[direct];
            if(!isAvailable(x,y)) break;
            map[y][x] = true;
        }
    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && x <= 100 && y >= 0 && y <= 100;
    }

    public static void main(String[] args) throws IOException {
        BOJ15685.solution();
    }
}
