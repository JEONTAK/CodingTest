package BaekJoon.Gold3.텀프로젝트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ9466 {

    static class Node{
        int e;
        int f;

        public Node(int e, int f) {
            this.e = e;
            this.f = f;
        }
    }

    static int T, N;
    static int[] student;
    static boolean[] team, visited;
    static int result = 0;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int a = 0; a < T; a++) {
            result = 0;
            N = Integer.parseInt(br.readLine());
            student = new int[N + 1];
            team = new boolean[N + 1];
            visited = new boolean[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                student[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= N; i++) {
                if(!team[i]){
                    compute(i);
                }
            }
            System.out.println(N - result);
        }
    }

    static void compute(int idx) {
        if(team[idx])return;
        if (visited[idx]) {
            team[idx] = true;
            result++;
        }
        visited[idx] = true;
        compute(student[idx]);
        team[idx] = true;
        visited[idx] = false;
    }

    public static void main(String[] args) throws IOException {
        BOJ9466.solution();
    }
}
