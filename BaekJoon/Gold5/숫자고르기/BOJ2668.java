package BaekJoon.Gold5.숫자고르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ2668 {

    static int N;
    static int[] seq;
    static boolean[] visited;
    static ArrayList<Integer> result = new ArrayList<>();

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        seq = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            compute(i, i);
            visited[i] = false;
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    static void compute(int s, int t) {
        if (!visited[seq[s]]) {
            visited[seq[s]] = true;
            compute(seq[s], t);
            visited[seq[s]] = false;
        }
        if(seq[s] == t) result.add(t);
    }


    public static void main(String[] args) throws IOException {
        BOJ2668.solution();
    }
}
