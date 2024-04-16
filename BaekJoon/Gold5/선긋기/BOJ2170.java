package BaekJoon.Gold5.선긋기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2170 {

    static class Line implements Comparable<Line>{
        long start;
        long end;

        public Line(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Line o) {
            return (int) (this.start - o.start);
        }
    }
    static int N;
    static ArrayList<Line> lines = new ArrayList<>();
    static ArrayList<Line> result = new ArrayList<>();

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            lines.add(new Line(x, y));
        }
        Collections.sort(lines);
        compute();
        long answer = 0;
        for (int i = 0; i < result.size(); i++) {
            answer += (result.get(i).end - result.get(i).start);
        }
        System.out.println(answer);
    }
    static void compute(){
        int idx = 0;
        result.add(lines.get(idx));
        long s = result.get(idx).start;
        long e = result.get(idx).end;
        for (int i = 1; i < lines.size(); i++) {
            long x = lines.get(i).start;
            long y = lines.get(i).end;
            if (s <= x && y <= e) {
            } else if (s <= x && x < e && y > e) {
                result.get(idx).end = y;
                e = y;
            } else {
                result.add(lines.get(i));
                s = x;
                e = y;
                idx++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BOJ2170.solution();
    }
}
