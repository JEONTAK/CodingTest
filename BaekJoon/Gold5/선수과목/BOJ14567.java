package BaekJoon.Gold5.선수과목;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14567 {

    static int N, M;
    static int[] semester, parent;
    static ArrayList<Integer>[] list;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        semester = new int[N + 1];
        parent = new int[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(e);
            parent[e]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (parent[i] == 0) {
                q.add(i);
            }
        }
        int result = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                semester[cur] = result;
                for (int child : list[cur]) {
                    if (--parent[child] == 0) {
                        q.add(child);
                    }
                }
            }
            result++;
        }
        for (int i = 1; i <= N; i++) {
            System.out.print(semester[i] + " ");
        }

    }
    public static void main(String[] args) throws IOException {
        BOJ14567.solution();
    }
}
