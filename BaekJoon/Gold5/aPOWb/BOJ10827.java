package BaekJoon.Gold5.aPOWb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class BOJ10827 {

    static BigDecimal a;
    static int b;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = new BigDecimal(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        System.out.println(a.pow(b).toPlainString());
    }

    public static void main(String[] args) throws IOException {
        BOJ10827.solution();
    }
}
