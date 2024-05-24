package BaekJoon.Gold4.이차원배열과연산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17140 {

    static class Num implements Comparable<Num>{
        int n;
        int cnt;

        public Num(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Num o) {
            if (this.cnt == o.cnt) {
                return this.n - o.n;
            }
            return this.cnt - o.cnt;
        }
    }

    static int R, C, K;
    static int[][] arr;
    static int time = 0;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()) - 1;
        C = Integer.parseInt(st.nextToken()) - 1;
        K = Integer.parseInt(st.nextToken());
        arr = new int[3][3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            if (time > 100) {
                System.out.println(-1);
                System.exit(0);
            }
            if (isCorrect()) {
                System.out.println(time);
                System.exit(0);
            }
            if (arr.length >= arr[0].length) {
                computeR();
            } else {
                computeC();
            }
            time++;
        }
    }

    static void computeR(){
        int maxR = 0;
        int[][] temp = new int[101][101];
        for (int i = 0; i < arr.length; i++) {
            int[] numArr = new int[101];
            List<Num> list = new ArrayList<>();

            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 0) continue;
                numArr[arr[i][j]]++;
            }
            for (int j = 1; j < numArr.length; j++) {
                if(numArr[j] == 0) continue;
                list.add(new Num(j, numArr[j]));
            }

            Collections.sort(list);
            int k = 0 ;
            for (int j = 0; j < list.size(); j++) {
                temp[i][k] = list.get(j).n;
                temp[i][k + 1] = list.get(j).cnt;
                k += 2;
            }
            maxR = Math.max(maxR, k);
        }
        maxR = Math.min(100, maxR);

        arr = new int[arr.length][maxR];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < maxR; j++) {
                arr[i][j] = temp[i][j];
            }
        }
    }

    static void computeC() {
        int maxC = 0;
        int[][] temp = new int[101][101];
        for (int i = 0; i < arr[0].length; i++) {
            int[] numArr = new int[101];
            List<Num> list = new ArrayList<>();
            for (int j = 0; j < arr.length; j++) {
                if(arr[j][i] == 0) continue;
                numArr[arr[j][i]]++;
            }
            for (int j = 1; j < numArr.length; j++) {
                if(numArr[j] == 0) continue;
                list.add(new Num(j, numArr[j]));
            }
            Collections.sort(list);
            int k = 0;
            for (int j = 0; j < list.size(); j++) {
                temp[k][i] = list.get(j).n;
                temp[k + 1][i] = list.get(j).cnt;
                k += 2;
            }
            maxC = Math.max(maxC, k);
        }
        maxC = Math.min(100, maxC);

        arr = new int[maxC][arr[0].length];
        for (int i = 0; i <maxC; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = temp[i][j];
            }
        }
    }

    static boolean isCorrect(){
        if (R < arr.length && C < arr[0].length) {
            if(arr[R][C] == K) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BOJ17140.solution();
    }
}
