package BaekJoon.Gold5.용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2467 {

    static int N, ptr1, ptr2;
    static int min1,min2;
    static int min = Integer.MAX_VALUE;
    static int[] water;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        water = new int[N];
        ptr1 = 0;
        ptr2 = N - 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            water[i] = Integer.parseInt(st.nextToken());
        }
        while (ptr1 != ptr2) {
            int sumWater = water[ptr1] + water[ptr2];
            if (Math.abs(sumWater) < min) {
                min = Math.abs(sumWater);
                min1 = water[ptr1];
                min2 = water[ptr2];
            }
            if(sumWater < 0){
                ptr1++;
            }else{
                ptr2--;
            }
        }
        System.out.println(min1 + " " + min2);
    }

    public static void main(String[] args) throws IOException {
        BOJ2467.solution();
    }
}
