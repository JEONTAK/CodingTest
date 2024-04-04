package BaekJoon.Gold5.탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493 {

    static class Tower{
        int idx;
        int h;

        public Tower(int idx, int h) {
            this.idx = idx;
            this.h = h;
        }
    }

    static int N;
    static StringBuilder sb = new StringBuilder();
    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Stack<Tower> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int h = Integer.parseInt(st.nextToken());
            while (true) {
                if (stack.isEmpty()) {
                       sb.append("0 ");
                       stack.push(new Tower(i, h));
                       break;
                }
                Tower tower = stack.peek();
                if(tower.h > h){
                    sb.append(tower.idx + " ");
                    stack.push(new Tower(i, h));
                    break;
                }
                else{
                    stack.pop();
                }
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BOJ2493.solution();
    }
}
