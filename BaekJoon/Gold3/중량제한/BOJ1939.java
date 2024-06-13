package BaekJoon.Gold3.중량제한;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1939 {

    static class Node{
        int e;
        int d;

        public Node(int e, int d) {
            this.e = e;
            this.d = d;
        }
    }

    static int N, M;
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int maxW = 0;
    static int result = 0;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list[s].add(new Node(e, d));
            list[e].add(new Node(s, d));
            maxW = Math.max(maxW, d);
        }
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int minW = 0;

        while (minW <= maxW) {
            int mid = (minW + maxW) / 2;
            result = -1;
            visited = new boolean[N + 1];
            compute(a, b, mid);
            if (result != -1) {
                minW = mid + 1;
            }else{
                maxW = mid - 1;
            }
        }
        System.out.println(maxW);
    }

    static void compute(int a, int b, int max) {
        if (a == b) {
            result = a;
            return;
        }
        visited[a] = true;
        for (Node next : list[a]) {
            if (!visited[next.e] && max <= next.d) {
                compute(next.e, b, max);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ1939.solution();
    }
}
