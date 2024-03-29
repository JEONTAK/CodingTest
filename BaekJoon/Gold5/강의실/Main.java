package BaekJoon.Gold5.강의실;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{
        int num;
        int start;
        int end;

        public Node(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node node) {
            return this.start - node.start;
        }
    }
    static int N;
    static List<Node> node;
    static int room = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        node = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            node.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        Collections.sort(node);
        compute();
    }

    static void compute(){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            while (!queue.isEmpty() && queue.peek() <= node.get(i).start) {
                queue.poll();
            }
            queue.add(node.get(i).end);
            room = Math.max(room, queue.size());
        }

        System.out.println(room);
    }
}
