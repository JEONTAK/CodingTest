package BaekJoon.Gold4.돌그룹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ12886 {

    static class Stone {
        int A;
        int B;
        int C;

        public Stone(int a, int b, int c) {
            A = a;
            B = b;
            C = c;
        }
    }

    static HashSet<String> hashSet = new HashSet<>();

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        Queue<Stone> q = new LinkedList<>();
        q.add(new Stone(A, B, C));
        while (!q.isEmpty()) {
            Stone cur = q.poll();
            if (cur.A == cur.B && cur.B == cur.C) {
                System.out.println(1);
                System.exit(0);
            }
            String temp = String.valueOf(cur.A) + String.valueOf(cur.B) + String.valueOf(cur.C);
            if(hashSet.contains(temp)) continue;
            hashSet.add(temp);
            if (cur.A < cur.B) {
                q.add(new Stone(cur.A + cur.A, cur.B - cur.A, cur.C));
            } else if (cur.A > cur.B) {
                q.add(new Stone(cur.A - cur.B, cur.B + cur.B, cur.C));
            }
            if (cur.B < cur.C) {
                q.add(new Stone(cur.A, cur.B + cur.B, cur.C - cur.B));
            } else if (cur.B > cur.C) {
                q.add(new Stone(cur.A, cur.B - cur.C, cur.C + cur.C));
            }
            if (cur.A < cur.C) {
                q.add(new Stone(cur.A + cur.A, cur.B, cur.C - cur.A));
            } else if (cur.A > cur.C) {
                q.add(new Stone(cur.A - cur.C, cur.B, cur.C + cur.C));
            }
        }
        System.out.println(0);
    }

    public static void main(String[] args) throws IOException {
        BOJ12886.solution();
    }
}
