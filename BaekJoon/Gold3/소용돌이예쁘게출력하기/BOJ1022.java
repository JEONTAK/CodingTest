package BaekJoon.Gold3.소용돌이예쁘게출력하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1022 {

    static int r1, c1, r2, c2;
    static int[][] sq;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        sq = new int[r2 - r1 + 1][c2 - c1 + 1];
        compute();

        int maxL = 0;
        for (int i = 0; i <= r2 - r1; i++) {
            for (int j = 0; j <= c2 - c1; j++) {
                int len = Integer.toString(sq[i][j]).length();
                maxL = Math.max(maxL, len);
            }
        }
        for (int i = 0; i <= r2 - r1; i++) {
            for (int j = 0; j <= c2 - c1; j++) {
                System.out.format("%" + maxL + "d ", sq[i][j]);
            }
            System.out.println();
        }
    }

    static void compute() {
        int x = 0, y = 0, d = 0;
        int idx = 1, dNum = 1, cnt = 0;
        while (!isFinish()) {
            if (x >= r1 && x <= r2 && y >= c1 && y <= c2) {
                sq[x - r1][y - c1] = idx;
            }
            idx++;
            cnt++;
            x += dx[d];
            y += dy[d];

            if (cnt == dNum) {
                cnt = 0;
                if(d == 1 || d == 3) dNum++;
                d = (d + 1) % 4;
            }
        }
    }

    static boolean isFinish() {
        return sq[0][0] != 0 && sq[r2 - r1][0] != 0 && sq[0][c2 - c1] != 0 && sq[r2 - r1][c2 - c1] != 0;
    }

    public static void main(String[] args) throws IOException {
        BOJ1022.solution();
    }
}
