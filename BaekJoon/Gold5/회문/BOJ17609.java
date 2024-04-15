package BaekJoon.Gold5.회문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17609 {

    static int N;
    static char[] str;
    static int ptr1, ptr2;
    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            str = br.readLine().toCharArray();
            ptr1 = 0;
            ptr2 = str.length - 1;
            int result = compute(ptr1, ptr2, 0);
            System.out.println(result);
        }
    }
    static int compute(int start, int end, int result){
        if(result == 2){
            return 2;
        }
        while (start <= end) {
            if(str[start] == str[end]){
                start++;
                end--;
            }else{
                return Math.min(compute(start + 1, end, result + 1), compute(start, end - 1, result + 1));
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BOJ17609.solution();
    }
}
