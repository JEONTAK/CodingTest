package BaekJoon.Gold4.다이어트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ19942 {

    static int N;
    static int[] min = new int[4];
    static int[][] food;
    static int minCost = Integer.MAX_VALUE;
    static ArrayList<Integer> eatList;
    static String result;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            min[i] = Integer.parseInt(st.nextToken());
        }
        food = new int[N + 1][5];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                food[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] total = new int[4];
        eatList = new ArrayList<>();
        compute(1, 0, total);

        if (result == null) {
            System.out.println(-1);
        }else{
            System.out.println(minCost);
            System.out.println(result);
        }
    }

    static void compute(int idx, int cost, int[] total) {
        if (cost > minCost) {
            return;
        }
        if (idx > N) {
            for (int i = 0; i < 4; i++) {
                if(min[i] > total[i])return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < eatList.size(); i++) {
                sb.append(eatList.get(i) + " ");
            }

            if (cost == minCost) {
                if (result != null && result.compareTo(sb.toString()) < 0) {
                    return;
                }
            }
            minCost = cost;
            result = sb.toString();
            return;
        }
        eatList.add(idx);
        for (int i = 0; i < 4; i++) {
            total[i] += food[idx][i];
        }
        compute(idx + 1, cost + food[idx][4], total);
        eatList.remove(eatList.size() - 1);
        for (int i = 0; i < 4; i++) {
            total[i] -= food[idx][i];
        }
        compute(idx + 1, cost, total);
    }

    public static void main(String[] args) throws IOException {
        BOJ19942.solution();
    }
}
