package BaekJoon.감소하는수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    static List<Long> list = new ArrayList<>();
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        if (n <= 10) {
            System.out.println(n);
        } else{
            for (int i = 0; i < 10; i++) {
                setList(i,1);
            }
            if (n >= list.size()) {
                System.out.println(-1);
            }
            else{
                Collections.sort(list);
                System.out.println(list.get(n));
            }
        }

    }

    static void setList(long num, int value) {
        if(value > 10) return;

        list.add(num);
        for (int i = 0; i < num % 10; i++) {
            setList((num * 10) + i, value + 1);
        }

    }
}
