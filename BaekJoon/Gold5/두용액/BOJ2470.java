package BaekJoon.Gold5.두용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470 {

    static int N, ptr1, ptr2;
    static int s1,s2, min = Integer.MAX_VALUE;
    static int[] solution;
    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        solution = new int[N];
        ptr1 = 0;
        ptr2 = N - 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(solution);

        while (ptr1 != ptr2) {
            if (min > Math.abs(solution[ptr1] + solution[ptr2])) {
                s1 = solution[ptr1];
                s2 = solution[ptr2];
                min = Math.abs(solution[ptr1] + solution[ptr2]);
            }
            if (solution[ptr1] + solution[ptr2] < 0) {
                ptr1++;
            }else{
                ptr2--;
            }
        }

        System.out.println(s1 + " " + s2);
    }

    public static void main(String[] args) throws IOException {
        BOJ2470.solution();
    }
}
