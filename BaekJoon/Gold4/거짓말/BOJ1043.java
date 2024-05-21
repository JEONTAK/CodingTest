package BaekJoon.Gold4.거짓말;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1043 {

    static int N, M, S;
    static ArrayList<Integer> knowP = new ArrayList<>();
    static int[] parents;
    static List<Integer>[] party;
    static int result = 0;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        for(int i = 1 ; i <= N ; i++)
            parents[i] = i;

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        if (S == 0) {
            System.out.println(M);
            System.exit(0);
        }
        for (int i = 0; i < S; i++) {
            knowP.add(Integer.parseInt(st.nextToken()));
        }
        party = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            party[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            party[i].add(x);
            for (int j = 1; j < num; j++) {
                int y = Integer.parseInt(st.nextToken());
                union(x, y);
                party[i].add(y);
            }
        }

        for (int i = 0; i < M; i++) {
            boolean flag = true;
            for (int n : party[i]) {
                if (knowP.contains(find(parents[n]))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result++;
            }
        }
        System.out.println(result);
    }

    static int find(int x) {
        if(parents[x] == x) return x;
        return find(parents[x]);
    }

    static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (knowP.contains(ry)) {
            int tmp = rx;
            rx = ry;
            ry = tmp;
        }
        parents[ry] = rx;
    }

    public static void main(String[] args) throws IOException {
        BOJ1043.solution();
    }
}
