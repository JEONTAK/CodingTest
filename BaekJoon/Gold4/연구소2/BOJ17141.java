package BaekJoon.Gold4.연구소2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17141 {

    static class Virus{
        int x;
        int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] lab;
    static boolean[][] visited;
    static Virus[] virus;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int result = Integer.MAX_VALUE;
    static ArrayList<Virus> list = new ArrayList<>();

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2) {
                    list.add(new Virus(i, j));
                }
            }
        }
        virus = new Virus[M];
        setVirus(0,0);
        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
    }

    static void setVirus(int idx, int start) {
        if (idx == M) {
            compute();
            return;
        }
        for (int i = start; i < list.size(); i++) {
            virus[idx] = list.get(i);
            setVirus(idx + 1, i + 1);
        }
    }

    static void compute() {
        Queue<Virus> q = new LinkedList<>();
        int time = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < M; i++) {
            q.add(virus[i]);
            visited[virus[i].x][virus[i].y] = true;
        }

        while (!q.isEmpty()) {
            if (time >= result)return;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Virus cur = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (isAvailable(nx, ny) && !visited[nx][ny]) {
                        if (lab[nx][ny] != 1) {
                            visited[nx][ny] = true;
                            q.add(new Virus(nx, ny));
                        }
                    }
                }
            }
            time++;
        }
        if (allInfected(visited)) {
            result = Math.min(result, time - 1);
        }
    }

    private static boolean allInfected(boolean[][] visited) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (lab[i][j] != 1 && !visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static void main(String[] args) throws IOException {
        BOJ17141.solution();
    }
}
