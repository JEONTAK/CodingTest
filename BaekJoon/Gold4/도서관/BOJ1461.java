package BaekJoon.Gold4.도서관;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1461 {

    static int N, M;
    static ArrayList<Integer> pos = new ArrayList<>();
    static ArrayList<Integer> neg = new ArrayList<>();
    static int walk = 0;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if(temp > 0) pos.add(temp);
            else neg.add(temp);
        }
        Collections.sort(neg);
        Collections.sort(pos, Collections.reverseOrder());
        ArrayList<Integer> dist = new ArrayList<>();
        while (!neg.isEmpty()) {
            int d = 0;
            d = neg.remove(0);
            for (int i = 1; i < M; i++) {
                if (!neg.isEmpty()) {
                    neg.remove(0);
                }
            }
            dist.add(-d);
        }
        while (!pos.isEmpty()) {
            int d = 0;
            d = pos.remove(0);
            for (int i = 1; i < M; i++) {
                if (!pos.isEmpty()) {
                    pos.remove(0);
                }
            }
            dist.add(d);
        }
        Collections.sort(dist);
        for (int i = 0; i < dist.size() - 1; i++) {
            walk += dist.get(i) * 2;
        }
        walk += dist.get(dist.size() - 1);
        System.out.println(walk);
    }

    public static void main(String[] args) throws IOException {
        BOJ1461.solution();
    }
}
