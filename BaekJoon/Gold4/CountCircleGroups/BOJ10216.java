package BaekJoon.Gold4.CountCircleGroups;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10216 {

    static class Enemy{
        int x;
        int y;
        int R;

        public Enemy(int x, int y, int r) {
            this.x = x;
            this.y = y;
            R = r;
        }
    }

    static int T, N;
    static int[] parents;
    static Enemy[] enemies;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int a = 0; a < T; a++) {
            N = Integer.parseInt(br.readLine());
            parents = new int[N];
            enemies = new Enemy[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int R = Integer.parseInt(st.nextToken());
                enemies[i] = new Enemy(x, y, R);
                parents[i] = i;
            }
            compute();
        }
    }
    static void compute(){
        int result = N;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isRange(i,j)) {
                    if (find(i) != find(j)) {
                        union(i, j);
                        result--;
                    }
                }
            }
        }
        System.out.println(result);
    }

    static int find(int x) {
        if(x == parents[x])return x;
        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if(x < y)parents[y] = x;
            else parents[x] = y;
        }
    }
    static boolean isRange(int i ,int j) {
        int x = enemies[i].x - enemies[j].x;
        int y = enemies[i].y - enemies[j].y;
        int R = enemies[i].R + enemies[j].R;
        return x * x + y * y <= R * R;
    }
    public static void main(String[] args) throws IOException {
        BOJ10216.solution();
    }
}
