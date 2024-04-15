package BaekJoon.Gold5.맥주마시면서걸어가기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ9205 {
    static class Coor{
        int x;
        int y;
        int idx;

        public Coor(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }
    static int T, N;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            ArrayList<Coor> coors = new ArrayList<>();
            visited = new boolean[N + 2];
            for (int j = 0; j < N + 2; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                coors.add(new Coor(x, y, j));
            }
            if(compute(coors)){
                sb.append("happy\n");
            }else{
                sb.append("sad\n");
            }
        }
        System.out.println(sb);
    }

    static boolean compute(ArrayList<Coor> coors) {
        Queue<Coor> q = new LinkedList<>();

        q.offer(coors.get(0));
        int festival = coors.size() - 1;
        while (!q.isEmpty()) {
            Coor coor = q.poll();
            visited[coor.idx] = true;
            if (coor.idx == coors.get(festival).idx) {
                return true;
            }

            for (int i = 0; i < coors.size(); i++) {
                if (!visited[i] && beer(coor, coors.get(i))) {
                    q.add(coors.get(i));
                }
            }
        }
        return false;
    }

    static boolean beer(Coor c1, Coor c2){
        double dist = Math.abs(c1.x - c2.x) + Math.abs((c1.y - c2.y));
        if (dist > 1000) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
         BOJ9205.solution();
    }
}
