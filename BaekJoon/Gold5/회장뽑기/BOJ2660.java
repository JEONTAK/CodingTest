package BaekJoon.Gold5.회장뽑기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2660 {

    static int N;
    static int[][] node;
    static int[] score;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static ArrayList<Integer> result = new ArrayList<>();

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        node = new int[N + 1][N + 1];
        score = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        while (x != -1 && y != -1) {
            node[x][y] = 1;
            node[y][x] = 1;
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            compute(i);
        }

        for (int i = 1; i <= N; i++) {
            if (score[i] < min) {
                min = score[i];
                result.clear();
                result.add(i);
            } else if (score[i] == min) {
                result.add(i);
            }
        }
        Collections.sort(result);
        System.out.println(min + " " + result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }

    static void compute(int start) {
        Queue<int[]> q = new LinkedList<>();
        int[] s = {start, 0};
        q.add(s);
        visited = new boolean[N + 1];
        visited[start] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && node[cur[0]][i] == 1) {
                    visited[i] = true;
                    int sum = cur[1] + 1;
                    int[] n = {i,sum};
                    q.add(n);
                    score[start] = sum;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ2660.solution();
    }
}
