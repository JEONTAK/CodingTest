package BaekJoon.Gold3.연구소3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17142 {

    static class Virus{
        int x;
        int y;
        int t;

        public Virus(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    static int N, M;
    static int[][] labs;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static ArrayList<Virus> v = new ArrayList<>();
    static Virus[] act;
    static int result = Integer.MAX_VALUE;
    static int empty = 0;
    static boolean[][] visited;


    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        labs = new int[N][N];
        act = new Virus[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                labs[i][j] = Integer.parseInt(st.nextToken());
                if (labs[i][j] == 0) {
                    empty++;
                } else if (labs[i][j] == 2) {
                    v.add(new Virus(i, j, 0));
                }
            }
        }

        if (empty == 0) {
            System.out.println(0);
        }else{
            setVirus(0, 0);
            System.out.println((result == Integer.MAX_VALUE) ? -1 : result);
        }
    }

    static void setVirus(int vCnt, int idx) {
        if (vCnt == M) {
            compute(empty);
            return;
        }

        for (int i = idx; i < v.size(); i++) {
            act[vCnt] = v.get(i);
            setVirus(vCnt + 1, i + 1);
        }
    }

    static void compute(int empty){
        Queue<Virus> q = new LinkedList<>();
        visited = new boolean[N][N];
        for (int i = 0; i < M; i++) {
            Virus virus = act[i];
            visited[virus.x][virus.y] = true;
            q.add(virus);
        }

        while (!q.isEmpty()) {
            Virus cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(!isAvailable(nx,ny)) continue;
                if(visited[nx][ny] || labs[nx][ny] == 1) continue;

                if (labs[nx][ny] == 0) {
                    empty--;
                }
                if (empty == 0) {
                    result = Math.min(result, cur.t + 1);
                    return;
                }
                visited[nx][ny] = true;
                q.add(new Virus(nx, ny, cur.t + 1));
            }

        }
    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }


    public static void main(String[] args) throws IOException {
        BOJ17142.solution();
    }
}
