package BaekJoon.Gold5.강의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ11000 {

    static class lecture implements Comparable<lecture>{
        int start;
        int fin;

        public lecture(int start, int fin) {
            this.start = start;
            this.fin = fin;
        }

        @Override
        public int compareTo(lecture o) {
            return this.start - o.start;
        }
    }

    static int N;
    static ArrayList<lecture> list = new ArrayList<>();
    static PriorityQueue<Integer> queue = new PriorityQueue<>();

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);

        queue.offer(list.get(0).fin);
        for (int i = 1; i < N; i++) {
            if (queue.peek() <= list.get(i).start) {
                queue.poll();
            }
            queue.offer(list.get(i).fin);
        }

        System.out.println(queue.size());

    }

    public static void main(String[] args) throws IOException {
        BOJ11000.solution();
    }
}
