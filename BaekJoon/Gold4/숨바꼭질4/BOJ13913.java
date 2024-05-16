package BaekJoon.Gold4.숨바꼭질4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ13913 {

    static int N, K;
    static int[] visited = new int[100001];
    static int[] road = new int[100001];

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        compute();
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        sb.append(visited[K] + "\n");
        int last = K;
        while (last != N) {
            stack.push(last);
            last = road[last];
        }
        stack.push(N);

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb.toString());
    }

    static void compute(){
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == K) {
                break;
            }

            if (cur > 0 && visited[cur - 1] == 0) {
                q.add(cur - 1);
                visited[cur -1] = visited[cur] + 1;
                road[cur - 1] = cur;
            }
            if (cur + 1 < 100001 && visited[cur + 1] == 0) {
                q.add(cur + 1);
                visited[cur + 1] = visited[cur] + 1;
                road[cur + 1] = cur;
            }
            if (cur * 2 < 100001 && visited[cur * 2] == 0) {
                q.add(cur * 2);
                visited[cur * 2] = visited[cur] + 1;
                road[cur * 2] = cur;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ13913.solution();
    }
}
