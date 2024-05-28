package BaekJoon.Gold4.소수경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1963 {

    static class Number implements Comparable<Number> {

        int n1000;
        int n100;
        int n10;
        int n1;
        int t;

        public Number(int n1000, int n100, int n10, int n1, int t) {
            this.n1000 = n1000;
            this.n100 = n100;
            this.n10 = n10;
            this.n1 = n1;
            this.t = t;
        }

        @Override
        public int compareTo(Number o) {
            return this.t - o.t;
        }

        public int getNum(int n1000, int n100, int n10, int n1) {
            int num = 0;
            num += (n1000 * 1000);
            num += (n100 * 100);
            num += (n10 * 10);
            num += (n1);
            return num;
        }
    }


    static int T;
    static String A;
    static int B;
    static boolean[] prime;
    static StringBuilder sb = new StringBuilder();

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        prime = new boolean[10000];
        prime[0] = prime[1] = false;
        for (int i = 2; i < 10000; i++) {
            if (!prime[i]) {
                for (int j = i * i; j < 10000; j += i) {
                    prime[j] = true;
                }
            }
        }
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            boolean flag = false;
            st = new StringTokenizer(br.readLine());
            A = st.nextToken();
            B = Integer.parseInt(st.nextToken());
            PriorityQueue<Number> pq = new PriorityQueue<>();
            Number number = new Number(A.charAt(0) - '0', A.charAt(1) - '0', A.charAt(2) - '0', A.charAt(3) - '0', 0);
            pq.add(number);
            boolean[] visited = new boolean[10000];
            while (!pq.isEmpty()) {
                Number cur = pq.poll();
                int curNum = cur.getNum(cur.n1000,cur.n100,cur.n10,cur.n1);
                if (curNum == B) {
                    sb.append(cur.t).append("\n");
                    flag = true;
                    break;
                }
                for (int j = 1; j <= 9; j++) {
                    if (j != cur.n1000) {
                        int n = cur.getNum(j, cur.n100, cur.n10, cur.n1);
                        if (!visited[n] && !prime[n]) {
                            visited[n] = true;
                            pq.add(new Number(j, cur.n100, cur.n10, cur.n1, cur.t + 1));
                        }
                    }
                }
                for (int j = 0; j <= 9; j++) {
                    if (j != cur.n100) {
                        int n = cur.getNum(cur.n1000, j, cur.n10, cur.n1);
                        if (!visited[n] && !prime[n]) {
                            visited[n] = true;
                            pq.add(new Number(cur.n1000, j, cur.n10, cur.n1, cur.t + 1));
                        }
                    }
                }
                for (int j = 0; j <= 9; j++) {
                    if (j != cur.n10) {
                        int n = cur.getNum(cur.n1000, cur.n100, j, cur.n1);
                        if (!visited[n] && !prime[n]) {
                            visited[n] = true;
                            pq.add(new Number(cur.n1000, cur.n100, j, cur.n1, cur.t + 1));
                        }
                    }
                }
                for (int j = 0; j <= 9; j++) {
                    if (j != cur.n1) {
                        int n = cur.getNum(cur.n1000, cur.n100, cur.n10, j);
                        if (!visited[n] && !prime[n]) {
                            visited[n] = true;
                            pq.add(new Number(cur.n1000, cur.n100, cur.n10, j, cur.t + 1));
                        }
                    }
                }
            }
            if (!flag) {
                sb.append("Impossible\n");
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BOJ1963.solution();
    }
}
