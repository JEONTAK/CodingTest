package BaekJoon.Gold5.행복유치원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ13164 {

    static int N, K, ans;
    static int[] height;
    static ArrayList<Integer> result = new ArrayList<>();

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        height = new int[N];
        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(height);
        compute();
        System.out.println(ans);
    }
    static void compute(){
        for (int i = 1; i < N; i++) {
            result.add(height[i] - height[i - 1]);
        }
        Collections.sort(result);
        for (int i = 0; i < N - K; i++) {
            ans += result.get(i);
        }
    }
    public static void main(String[] args) throws IOException {
        BOJ13164.solution();
    }
}
