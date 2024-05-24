package BaekJoon.Gold4.회전초밥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ15961 {

    static int N, D, K, C;
    static int[] sushi;
    static int s, e;
    static int max = 0;
    static ArrayList<Integer> eat;


    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> hm = new HashMap<>();
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        sushi = new int[N];
        eat = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        s = 0;
        e = s + K - 1;
        for (int i = s; i <= e; i++) {
            if (hm.containsKey(sushi[i])) {
                hm.replace(sushi[i],hm.get(sushi[i]), hm.get(sushi[i]) + 1);
            }else{
                hm.put(sushi[i], 1);
            }
        }
        if (hm.containsKey(C)) {
            max = Math.max(max, hm.size());
        }else{
            max = Math.max(max, hm.size() + 1);
        }
        for (int i = 0; i < N; i++) {
            e = (e + 1) % N;
            if (hm.get(sushi[s]) >= 2) {
                hm.replace(sushi[s], hm.get(sushi[s]), hm.get(sushi[s]) - 1);
            }else{
                hm.remove(sushi[s]);
            }
            if (hm.containsKey(sushi[e])) {
                hm.replace(sushi[e],hm.get(sushi[e]), hm.get(sushi[e]) + 1);
            }else{
                hm.put(sushi[e], 1);
            }
            s = (s + 1) % N;
            if (hm.containsKey(C)) {
                max = Math.max(max, hm.size());
            }else{
                max = Math.max(max, hm.size() + 1);
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        BOJ15961.solution();
    }
}
