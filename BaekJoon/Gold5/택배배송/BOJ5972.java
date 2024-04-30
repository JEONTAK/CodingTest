package BaekJoon.Gold5.택배배송;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ5972 {

    static class Node implements Comparable<Node> {

        int end;
        int cow;

        public Node(int end, int cow) {
            this.end = end;
            this.cow = cow;
        }

        @Override
        public int compareTo(Node o) {
            return this.cow - o.cow;
        }
    }

    static int N, M;
    static int[] map;
    static boolean visited[];
    static ArrayList<Node>[] list;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1];
        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[s].add(new Node(e, c));
            list[e].add(new Node(s, c));
        }

        compute();
        System.out.println(map[N]);
    }

    static void compute(){
        Arrays.fill(map, Integer.MAX_VALUE);
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(1, 0));
        map[1] = 0;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if(!visited[cur.end]) visited[cur.end] = true;
            else continue;
            for (Node next : list[cur.end]) {
                if (map[next.end] > map[cur.end] + next.cow) {
                    map[next.end] = map[cur.end] + next.cow;
                    q.offer(new Node(next.end, map[next.end]));
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BOJ5972.solution();
    }
}
