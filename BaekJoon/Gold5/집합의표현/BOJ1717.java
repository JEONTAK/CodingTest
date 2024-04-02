package BaekJoon.Gold5.집합의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1717 {

    static int N, M;
    static int a,b,c;
    static int[] set;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        set = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            set[i] = i;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            c = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (c == 0) {
                union(a,b);
            } else if (c == 1) {
                if (isInclude(a, b)) {
                    sb.append("YES\n");
                }else{
                    sb.append("NO\n");
                }
            }else{
                continue;
            }
        }
        System.out.println(sb);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a < b) {
                set[b] = a;
            }else{
                set[a] = b;
            }
        }
    }

    static int find(int a) {
        if (a == set[a]) {
            return a;
        }
        return set[a] = find(set[a]);
    }

    static boolean isInclude(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BOJ1717.solution();
    }
}
