package BaekJoon.Gold5.치킨배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15686 {

    static class Location{
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int [][] map;
    static ArrayList<Location> person = new ArrayList<>();
    static ArrayList<Location> chicken = new ArrayList<>();
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map =  new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    person.add(new Location(i, j));
                } else if (map[i][j] == 2) {
                    chicken.add(new Location(i, j));
                }
            }
        }

        visited = new boolean[chicken.size()];
        compute(0,0);
        System.out.println(min);
    }

    static void compute(int cnt, int idx) {
        if (cnt == M) {
            int total = 0;
            for (int i = 0; i < person.size(); i++) {
                int sum = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (visited[j]) {
                        int dist = Math.abs(person.get(i).x - chicken.get(j).x) + Math.abs(person.get(i).y - chicken.get(j).y);
                        sum = Math.min(sum, dist);
                    }
                }
                total += sum;
            }
            min = Math.min(total, min);
            return;
        }

        for (int i = idx; i < chicken.size(); i++) {
            if(!visited[i]){
                visited[i] = true;
                compute(cnt + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ15686.solution();
    }
}
