package BaekJoon.Gold5.리모컨;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1107 {

    static int N;
    static int M;
    static List<Integer> downNum = new ArrayList<>();
    static List<Integer> num = new ArrayList<>();
    static int channel = 100;
    static int push;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        if (M != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                downNum.add(Integer.parseInt(st.nextToken()));
            }
        }
        for (int i = 0; i < 10; i++) {
            if (!downNum.contains(i)) {
                num.add(i);
            }
        }
        push = Math.abs(N - channel);
        int digit = 0;
        if(num.size() != 0){
            compute(digit, 0);
        }
        System.out.println(push);
    }

    static void compute(int digit, int c){
        if(digit < 6){
            digit++;
            for(int i = 0 ; i < num.size() ; i++){
                push = Math.min(push, Math.abs((c * 10 + num.get(i)) - N) + digit);
                compute(digit,c * 10 + num.get(i));
            }
        }
    }
}
