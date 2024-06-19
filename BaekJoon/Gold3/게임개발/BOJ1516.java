package BaekJoon.Gold3.게임개발;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1516 {

    static class Node implements Comparable<Node>{
        int idx;
        int t;

        public Node(int idx, int t) {
            this.idx = idx;
            this.t = t;
        }

        @Override
        public int compareTo(Node o) {
            return this.t - o.t;
        }
    }

    static int N;
    static ArrayList<Integer>[] list;
    static Node[] node;
    static int[] construct;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        node = new Node[N + 1];
        construct = new int[N + 1];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            node[i] = new Node(i, t);
            while(true){
                int n = Integer.parseInt(st.nextToken());
                if(n == -1)break;
                list[n].add(i);
                construct[i]++;
            }
        }

        compute();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(node[i].t + "\n");
        }
        System.out.println(sb.toString());
    }

    static void compute(){

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (construct[i] == 0) {
                pq.offer(node[i]);
            }
        }

        while (!pq.isEmpty()) {
            int cur = pq.poll().idx;
            for (int next : list[cur]) {
                construct[next]--;
                if (construct[next] == 0) {
                    node[next].t += node[cur].t;
                    pq.offer(new Node(next, node[next].t));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ1516.solution();
    }
}
