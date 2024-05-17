package BaekJoon.Gold4.좋다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1253 {

    static int N;
    static int[] num;
    static int sum = 0;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N - 1;
            while(true){
                if (left == i) {
                    left++;
                } else if (right == i) {
                    right--;
                }
                if(left >= right) break;
                if(num[left] + num[right] > num[i]) right--;
                else if(num[left] + num[right] < num[i]) left++;
                else{
                    sum++;
                    break;
                }
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        BOJ1253.solution();
    }
}
