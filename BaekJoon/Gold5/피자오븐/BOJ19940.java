package BaekJoon.Gold5.피자오븐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ19940 {

    static class Oven{
        int ADDH;
        int ADDT;
        int MINT;
        int ADDO;
        int MINO;
        int time;

        public Oven(int ADDH, int ADDT, int MINT, int ADDO, int MINO, int time) {
            this.ADDH = ADDH;
            this.ADDT = ADDT;
            this.MINT = MINT;
            this.ADDO = ADDO;
            this.MINO = MINO;
            this.time = time;
        }
    }

    static int T, N;
    static boolean[] visited = new boolean[65];
    static Oven[] ovens = new Oven[65];
    static Queue<Oven> q = new LinkedList<>();


    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        make60();
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            int R = N % 60;
            int M = N / 60;

            System.out.print(ovens[R].ADDH + M + " ");
            System.out.print(ovens[R].ADDT + " ");
            System.out.print(ovens[R].MINT + " ");
            System.out.print(ovens[R].ADDO + " ");
            System.out.println(ovens[R].MINO);
        }
    }

    static void make60() {
        Oven oven = new Oven(0, 0, 0, 0, 0, 0);
        q.add(oven);
        while (!q.isEmpty()) {
            Oven cur = q.poll();
            if ((cur.time >= 0) && (cur.time <= 60) && (!visited[cur.time])) {
                visited[cur.time] = true;
                ovens[cur.time] = cur;
                q.add(new Oven(cur.ADDH, cur.ADDT, cur.MINT, cur.ADDO, cur.MINO + 1, cur.time - 1));
                q.add(new Oven(cur.ADDH, cur.ADDT, cur.MINT, cur.ADDO + 1, cur.MINO, cur.time + 1));
                q.add(new Oven(cur.ADDH, cur.ADDT, cur.MINT + 1, cur.ADDO, cur.MINO, cur.time - 10));
                q.add(new Oven(cur.ADDH, cur.ADDT + 1, cur.MINT, cur.ADDO, cur.MINO, cur.time + 10));
                q.add(new Oven(cur.ADDH + 1, cur.ADDT, cur.MINT, cur.ADDO, cur.MINO, cur.time + 60));

            }
        }
    }
    public static void main(String[] args) throws IOException {
        BOJ19940.solution();
    }
}
