package BaekJoon.Gold4.고층건물;

/*
1. 기울기를 사용함
    1.1 기준 빌딩 좌측 부분
        기울기가 기존 기울기보다 작다면 보이는 것, 크다면 안보이는 것.
        기존 보다 작다면 작은 것으로 업데이트
    1.2 기준 빌딩 우측 부분
        기울기가 기존 기울기보다 크다면 보이는 것, 작다면 안보이는 것.
        기존 보다 크다면 큰 것으로 업데이트
2. 좌측과 우측을 나누어서 풀어야 함
3. 기울기 값을 미리 배열에 저장해 놓자
4. 1번째 빌딩부터 마지막 빌딩까지 계산하면서 좌측과 우측으로 나누어 계산 하여 마지막에 더하기
    4.1 더한 값이 기존 값보다 크다면 업데이트
 */

import java.util.Scanner;

public class Main {
    static int N;

    static int[] height;

    static double[][] grad;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        height = new int[N];
        grad = new double[N][N];
        for (int i = 0; i < N; i++) {
            height[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grad[i][j] = (double) (height[i] - height[j]) / (i - j);
            }
        }

        int result = compute();

        System.out.println(result);

    }

    public static int compute() {
        int result = 0;
        int leftSum;
        int rightSum;
        double leftGrad;
        double rightGrad;

        for (int i = 0; i < N; i++) {
            leftSum = 0;
            rightSum = 0;
            leftGrad = Integer.MAX_VALUE;
            rightGrad = Integer.MIN_VALUE;
            //Left
            for (int j = i - 1; j >= 0; j--) {
                if (leftGrad > grad[i][j]) {
                    leftGrad = grad[i][j];
                    leftSum++;
                }
            }
            //Right
            for (int j = i + 1; j < N; j++) {
                if (rightGrad < grad[i][j]) {
                    rightGrad = grad[i][j];
                    rightSum++;
                }
            }

            if (result < leftSum + rightSum) {
                result = leftSum + rightSum;
            }
        }

        return result;
    }

}
