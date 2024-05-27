package BaekJoon.Gold4.사이클;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20040 {

    static int N, M;
    static int[] parents;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (find(x) == find(y)) {
                System.out.println(i + 1);
                return;
            }else{
                union(x, y);
            }
        }
        System.out.println(0);
    }

    static int find(int x){
        if(parents[x] == x) return x;
        return find(parents[x]);
    }

    static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);

        if (rx < ry) {
            parents[ry] = rx;
        } else {
            parents[rx] = ry;
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ20040.solution();
    }
}
