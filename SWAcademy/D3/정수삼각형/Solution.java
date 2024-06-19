package SWAcademy.D3.정수삼각형;

public class Solution {
    private static int solution(int[][] triangle) {
        int answer = 0;
        int h = triangle.length;
        int d = triangle[h - 1].length;
        int[][] dp = new int[h + 1][d + 1];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < h; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }
        for (int i = 2; i < h; i++) {
            for (int j = 1; j < triangle[i].length - 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
        }
        for (int i = 0; i <= h; i++) {
            for (int j = 0; j <= d; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < d; i++) {
            answer = Math.max(answer, dp[h - 1][i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        Solution.solution(triangle);
    }

}
