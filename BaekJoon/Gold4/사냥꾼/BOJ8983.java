package BaekJoon.Gold4.사냥꾼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ8983 {

    static class Animal{
        int x;
        int y;

        public Animal(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int M, N, L;
    static int[] fireSpot;
    static Animal[] animals;
    static int result = 0;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        fireSpot = new int[M];
        animals = new Animal[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            fireSpot[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            animals[i] = new Animal(x, y);
        }
        compute();
        System.out.println(result);
    }

    static void compute(){
        Arrays.sort(fireSpot);
        for (int i = 0; i < N; i++) {
            if(animals[i].y > L) continue;
            result += find(i);
        }
    }

    static int find(int idx){
        int start = 0;
        int end = M;
        int mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;
            if(mid >= M)return 0;
            int dist = Math.abs(fireSpot[mid] - animals[idx].x) + animals[idx].y;
            if (L < dist && animals[idx].x < fireSpot[mid]) {
                end = mid -1;
            } else if (L < dist && animals[idx].x >= fireSpot[mid]) {
                start = mid + 1;
            } else if (L >= dist) {
                return 1;
            }
        }
        return 0;
    }


    public static void main(String[] args) throws IOException {
        BOJ8983.solution();
    }
}
