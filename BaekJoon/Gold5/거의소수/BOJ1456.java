package BaekJoon.Gold5.거의소수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1456 {
    final int MAX = 10_000_000;
    long a,b;
    boolean[] isNP = new boolean[MAX + 1];
    void setPrime(){
        isNP[0] = isNP[1] = true;
        for (int i = 2; i * i <= MAX; i++) {
            if(isNP[i]) continue;
            for (int j = 2 * i; j <= MAX; j += i) {
                isNP[j] = true;
            }
        }
    }
    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        setPrime();
        long count = 0;
        for (long i = 2; i <= MAX; i++) {
            if(isNP[(int)i]) continue;
            long cur = i * i;
            while (cur <= b) {
                if(cur >= a) count++;
                if(i > 100000) break;
                cur *= i;
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        new BOJ1456().solution();
    }
}
