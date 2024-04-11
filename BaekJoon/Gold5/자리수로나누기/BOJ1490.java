package BaekJoon.Gold5.자리수로나누기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BOJ1490 {

    static long N;
    static ArrayList<Integer> digit = new ArrayList<>();
    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String temp = String.valueOf(N);

        for (int i = 0; i < temp.length(); i++) {
            if(temp.charAt(i) != '0'){
                digit.add(temp.charAt(i) - '0');
            }
        }
        compute();
    }

    static void compute() {
        Queue<Long> q = new ArrayDeque<>();
        q.add(N);
        while(!q.isEmpty()){
            long cur = q.poll();
            if (canNum(cur)) {
                System.out.println(cur);
                return;
            }
            for (int i = 0; i <= 9; i++) {
                q.add(cur * 10 + i);
            }
        }
    }

    static boolean canNum(long num){
        for (int i = 0; i < digit.size(); i++) {
            if(num % digit.get(i) != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BOJ1490.solution();
    }
}
