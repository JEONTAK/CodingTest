package BaekJoon.Gold5.노드사이의거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static int N,M;
    static boolean visited[];
    static int[][] node;
    static int distance[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        node = new int[N+1][N+1];
        distance = new int[N + 1][N + 1];

        int start, end, dis;

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            dis = Integer.parseInt(st.nextToken());
            node[start][end] = 1;
            node[end][start] = 1;
            distance[start][end] = dis;
            distance[end][start] = dis;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            compute(start,end,N);
        }

    }

    static void compute(int start, int end, int N) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[N + 1];
        visited[start] = true;
        queue.add(start);
        int result[] = new int[N + 1];

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 1; i <= N; i++) {
                if (node[cur][i] == 1 && !visited[i]) {
                    result[i] += distance[cur][i] + result[cur];

                    if (i == end) {
                        System.out.println(result[end]);
                        return;
                    }

                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
