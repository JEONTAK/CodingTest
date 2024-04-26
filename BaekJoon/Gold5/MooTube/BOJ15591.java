package BaekJoon.Gold5.MooTube;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ15591 {

    static class Cow{

        int y;
        int r;

        public Cow(int y, int r) {
            this.y = y;
            this.r = r;
        }
    }

    static int N, Q;
    static boolean[] visited;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        ArrayList<Cow>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            graph[x].add(new Cow(y, r));
            graph[y].add(new Cow(x, r));
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            int cnt = 0;
            Queue<Integer> q = new LinkedList<>();
            visited = new boolean[N + 1];
            visited[v] = true;
            q.add(v);

            while (!q.isEmpty()) {
                int curIdx = q.poll();

                List<Cow> list = graph[curIdx];

                for (int j = 0; j < list.size(); j++) {
                    if (!visited[list.get(j).y] && list.get(j).r >= k) {
                        cnt++;
                        q.add(list.get(j).y);
                        visited[list.get(j).y] = true;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
    public static void main(String[] args) throws IOException {
        BOJ15591.solution();
    }
}
