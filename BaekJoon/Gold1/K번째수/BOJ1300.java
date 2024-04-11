package BaekJoon.Gold1.K번째수;

import java.util.Scanner;

public class BOJ1300 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        long cnt;
        int left = 1, right = K, result = 0;
        while (left <= right) {
            cnt = 0;
            int mid = (left + right) / 2;
            for (int i = 1; i <= N; i++) {
                cnt += Math.min(mid / i, N);
            }
            if (cnt < K) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }
        System.out.println(result);
    }
}
