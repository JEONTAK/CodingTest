package BaekJoon.Gold4.이분그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1707 {

    static int K, V, E;
    static ArrayList<Integer>[] graph;
    static int[] node;
    static boolean[] visited;
    static String result;
    static StringBuilder sb = new StringBuilder();

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            graph = new ArrayList[V + 1];
            node = new int[V + 1];
            boolean flag = false;
            visited = new boolean[V + 1];
            result = "YES";
            for (int j = 1; j <= V; j++) {
                graph[j] = new ArrayList<>();
            }
            int s = 1, e;
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                s = Integer.parseInt(st.nextToken());
                e = Integer.parseInt(st.nextToken());
                graph[s].add(e);
                graph[e].add(s);
            }

            for (int j = 1; j <= V; j++) {
                if (!visited[j]) {
                    compute(j, flag);
                }
            }

            for (int j = 1; j <= V; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    if (node[j] == node[graph[j].get(k)]) {
                        result = "NO";
                        break;
                    }
                }
                if (result.equals("NO")) {
                    break;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    static void compute(int depth, boolean flag){
        visited[depth] = true;
        node[depth] = (flag) ? 1 : 0;
        flag = !flag;
        for (Integer cur : graph[depth]) {
            if (!visited[cur]) {
                compute(cur, flag);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ1707.solution();
    }
}
