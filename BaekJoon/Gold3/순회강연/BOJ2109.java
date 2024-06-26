package BaekJoon.Gold3.순회강연;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2109 {

    static class Lecture implements Comparable<Lecture>{
        int p;
        int d;

        public Lecture(int p, int d) {
            this.p = p;
            this.d = d;
        }

        @Override
        public int compareTo(Lecture o) {
            if (this.p == o.p) {
                return o.d - this.d;
            }
            return o.p - this.p;
        }
    }

    static int N, sum = 0, maxD = 0;
    static boolean[] day;
    static Lecture[] list;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        list = new Lecture[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list[i] = new Lecture(p, d);
            maxD = Math.max(maxD, d);
        }
        Arrays.sort(list);
        day = new boolean[maxD + 1];
        for (int i = 0; i < N; i++) {
            for (int j = list[i].d; j >= 1; j--) {
                if (!day[j]) {
                    day[j] = true;
                    sum += list[i].p;
                    break;
                }
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        BOJ2109.solution();
    }
}
