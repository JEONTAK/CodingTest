package BaekJoon.Gold5.물통;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ2251 {

    static int[] bottle;
    static boolean[][] check;
    static Set<Integer> result;


    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        bottle = new int[3];
        check = new boolean[201][201];

        for (int i = 0; i < 3; i++) {
            bottle[i] = Integer.parseInt(st.nextToken());
        }

        result = new TreeSet<>();

        compute(0,0,bottle[2]);

        for (Integer val : result) {
            System.out.print(val + " ");
        }
    }

    static void compute(int a, int b, int c) {
        if(check[a][b]) return;

        if (a == 0) {
            result.add(c);
        }
        check[a][b] = true;

        if(a + b > bottle[1]){
            compute((a + b) - bottle[1], bottle[1], c);
        }else{
            compute(0, a + b, c);
        }

        if (a + b > bottle[0]) {
            compute(bottle[0], a + b - bottle[0], c);
        }else{
            compute(a + b, 0, c);
        }

        if (a + c > bottle[0]) {
            compute(bottle[0], b, a + c - bottle[0]);
        }else{
            compute(a + c, b, 0);
        }

        if (b + c > bottle[1]) {
            compute(a, bottle[1], b + c - bottle[1]);
        }else{
            compute(a, b + c, 0);
        }
        compute(a, 0, b + c);
        compute(0, b, a + c);

    }

    public static void main(String[] args) throws IOException {
        BOJ2251.solution();
    }
}
