package BaekJoon.Gold5.줄어드는수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        if (N <= 10) {
            System.out.println(N - 1);
        }else{
            for (int i = 0; i < 10; i++) {
                compute(i,1);
            }
            Collections.sort(list);
            try {
                System.out.println(list.get(N - 1));
            } catch (Exception e) {
                System.out.println(-1);
            }

        }
    }

    static void compute(long num, int value) {
        if (value > 10) {
            return;
        }
        list.add(num);
        for (int i = 0; i < num % 10; i++) {
            compute((num * 10) + i, value + 1);
        }
    }
}
