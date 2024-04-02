package BaekJoon.Gold5.숨바꼭질3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ13549 {

    static class Location{
        int loc;
        int time;

        public Location(int loc, int time) {
            this.loc = loc;
            this.time = time;
        }
    }
    static int min = Integer.MAX_VALUE;
    static int max = 100000;
    static int N, K;
    static boolean[] visited = new boolean[max + 1];
    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        compute();
        System.out.println(min);
    }

    static void compute(){
        Queue<Location> q = new LinkedList<>();
        q.offer(new Location(N,0));

        while (!q.isEmpty()) {
            Location cur = q.poll();
            visited[cur.loc] = true;

            if (cur.loc == K) {
                min = Math.min(min, cur.time);
            }

            int goDouble = cur.loc * 2;
            int goOne = cur.loc + 1;
            int backOne = cur.loc - 1;
            if (goDouble <= max && visited[goDouble] == false) {
                q.offer(new Location(goDouble, cur.time));
            }
            if (goOne <= max && visited[goOne] == false) {
                q.offer(new Location(goOne, cur.time + 1));
            }
            if (backOne >= 0 && visited[backOne] == false) {
                q.offer(new Location(backOne, cur.time + 1));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ13549.solution();
    }
}
