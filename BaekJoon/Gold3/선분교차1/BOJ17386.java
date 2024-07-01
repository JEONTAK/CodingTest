package BaekJoon.Gold3.선분교차1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17386 {

    static class Point{
        long x;
        long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

    }

    static int[] ccw;
    static Point[] point = new Point[4];

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int idx = 0;
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                point[idx] = new Point(x, y);
                idx++;
            }
        }
        ccw = new int[4];
        ccw[0] = compute(point[0], point[1], point[2]);
        ccw[1] = compute(point[0], point[1], point[3]);
        ccw[2] = compute(point[2], point[3], point[0]);
        ccw[3] = compute(point[2], point[3], point[1]);
        if(ccw[0] * ccw[1] < 0 && ccw[2] * ccw[3] < 0) System.out.println(1);
        else System.out.println(0);
    }

    private static int compute(Point p1, Point p2, Point p3) {
        return (p1.x * p2.y) + (p2.x * p3.y) + (p3.x * p1.y) - (p1.y * p2.x) - (p2.y * p3.x) - (p3.y * p1.x) < 0 ? -1 : 1;
    }

    public static void main(String[] args) throws IOException {
        BOJ17386.solution();
    }
}
