package BaekJoon.Gold4.공유기설치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110 {

    static int N, C;
    static int[] house;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        house = new int[N];
        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);

        int minLen = 1;
        int maxLen = house[N - 1] - house[0] + 1;

        while (minLen < maxLen) {
            int mid = (minLen + maxLen) / 2;

            if (isAvailable(mid) < C) {
                maxLen = mid;
            }else{
                minLen = mid + 1;
            }
        }
        System.out.println(minLen - 1);
    }

    static int isAvailable(int dist) {
        int cnt = 1;
        int lH = house[0];

        for (int i = 1; i < house.length; i++) {
            int curH = house[i];

            if (curH - lH >= dist) {
                cnt++;
                lH = curH;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BOJ2110.solution();
    }
}
