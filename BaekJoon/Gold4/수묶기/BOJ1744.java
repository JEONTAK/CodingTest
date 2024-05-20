package BaekJoon.Gold4.수묶기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ1744 {

    static int N;
    static List<Integer> negative = new ArrayList<>();
    static List<Integer> positive = new ArrayList<>();

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());
            if (cur > 0) {
                positive.add(cur);
            }else{
                negative.add(cur);
            }
        }

        Collections.sort(positive, Collections.reverseOrder());
        Collections.sort(negative);

        int result = 0;
        int idx = 0;
        while (idx < positive.size()) {
            if (idx + 1 < positive.size() && positive.get(idx) != 1 && positive.get(idx + 1) != 1) {
                result += positive.get(idx) * positive.get(idx + 1);
                idx += 2;
            }else{
                result += positive.get(idx);
                idx++;
            }
        }
        idx = 0;
        while (idx < negative.size()) {
            if (idx + 1 < negative.size()) {
                result += negative.get(idx) * negative.get(idx + 1);
                idx += 2;
            }else{
                result += negative.get(idx);
                idx++;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        BOJ1744.solution();
    }
}
