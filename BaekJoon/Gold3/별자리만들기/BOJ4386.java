package BaekJoon.Gold3.별자리만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ4386 {

    static class Star implements Comparable<Star>{
        int s;
        int e;
        double d;

        public Star(int s, int e, double d) {
            this.s = s;
            this.e = e;
            this.d = d;
        }

        @Override
        public int compareTo(Star o) {
            if(this.d < o.d)return -1;
            return 1;
        }
    }

    static int N;
    static ArrayList<Star> list = new ArrayList<>();
    static double[][] stars;
    static double result = 0;
    static boolean[] visited;
    static int[] parent;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stars = new double[N][2];
        visited = new boolean[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            stars[i][0] = x;
            stars[i][1] = y;
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double dist = Math.sqrt(Math.pow(stars[i][0] - stars[j][0], 2) + Math.pow(stars[i][1] - stars[j][1], 2));
                list.add(new Star(i, j, dist));
                list.add(new Star(j, i, dist));
            }
        }
        Collections.sort(list);
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            if (cnt == N - 1) break;
            Star cur = list.get(i);
            cnt += union(cur.s, cur.e, cur.d);
        }
        System.out.printf("%.2f", result);
    }

    private static int union(int s, int e, double d) {
        int s1 = find(s);
        int s2 = find(e);
        if (s1 > s2) {
            parent[s1] = s2;
            result += d;
            return 1;
        } else if (s1 < s2){
            parent[s2] = s1;
            result += d;
            return 1;
        }
        return 0;
    }

    static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void main(String[] args) throws IOException {
        BOJ4386.solution();
    }
}
