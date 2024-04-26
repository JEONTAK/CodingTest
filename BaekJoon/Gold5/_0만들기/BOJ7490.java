package BaekJoon.Gold5._0만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ7490 {

    static int T, N;
    static String[] delta = {"+", "-", " "};
    static ArrayList<String> list;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            compute(1, "1");
            Collections.sort(list);
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

    static void compute(int cur, String s){
        if (cur == N) {
            String temp = s.replaceAll(" ", "");
            if (isZero(temp)) {
                list.add(s);
            }
            return;
        }
        for (int i = 0; i < 3; i++) {
            compute(cur + 1, s + delta[i] + Integer.toString(cur + 1));
        }
    }

    static boolean isZero(String temp) {
        StringTokenizer st = new StringTokenizer(temp, "-|+", true);
        int sum = Integer.parseInt(st.nextToken());
        while (st.hasMoreElements()) {
            String s = st.nextToken();
            if (s.equals("+")) {
                sum += Integer.parseInt(st.nextToken());
            }else{
                sum -= Integer.parseInt(st.nextToken());
            }
        }
        if (sum == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BOJ7490.solution();
    }
}
