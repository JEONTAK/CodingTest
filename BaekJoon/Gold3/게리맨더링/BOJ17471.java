package BaekJoon.Gold3.게리맨더링;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17471 {

    static int N;
    static int[] pop;
    static boolean[] RB, visited;
    static ArrayList<Integer>[] list;
    static int result = Integer.MAX_VALUE;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pop = new int[N + 1];
        RB = new boolean[N + 1];
        list = new ArrayList[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            pop[i] = Integer.parseInt(st.nextToken());
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int e = Integer.parseInt(st.nextToken());
                list[i].add(e);
                list[e].add(i);
            }
        }

        compute(1);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    static void compute(int idx) {
        if (idx == N + 1) {
            visited = new boolean[N + 1];
            int r = 0, b = 0;
            for (int i = 1; i <= N; i++) {
                if(RB[i]) r += pop[i];
                else b += pop[i];
            }
            int cnt = 0;

            for (int i = 1; i <= N; i++) {
                if(visited[i]) continue;
                connect(i, RB[i]);
                cnt++;
            }
            if(cnt == 2) result = Math.min(result, Math.abs(r - b));
            return;
        }

        RB[idx] = true;
        compute(idx + 1);
        RB[idx] = false;
        compute(idx + 1);
    }

    static void connect(int idx, boolean flag) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(idx);
        visited[idx] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : list[cur]) {
                if (RB[next] == flag && !visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ17471.solution();
    }
}
