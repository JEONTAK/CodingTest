package BaekJoon.Gold5.ABCDE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ13023 {

    static int N, M;
    static List<Integer>[] friends;
    static boolean[] visited;
    static int result = 0;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        friends = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            friends[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            friends[x].add(y);
            friends[y].add(x);
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            compute(i,1);
            if (result == 1) {
                break;
            }
        }
        System.out.println(result);
    }

    static void compute(int cur, int idx){
        if(idx == 5){
            result = 1;
            return;
        }
        visited[cur] = true;
        for (int i : friends[cur]) {
            if (!visited[i]) {
                compute(i, idx + 1);
            }
        }
        visited[cur] = false;
    }

    public static void main(String[] args) throws IOException {
        BOJ13023.solution();
    }
}
