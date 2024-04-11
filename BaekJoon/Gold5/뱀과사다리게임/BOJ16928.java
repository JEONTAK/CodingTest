package BaekJoon.Gold5.뱀과사다리게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16928 {

    static class Game {
        int loc;
        int ladder;
        int snake;
        int dice;

        public Game(int loc, int ladder, int snake, int dice) {
            this.loc = loc;
            this.ladder = ladder;
            this.snake = snake;
            this.dice = dice;
        }
    }

    static int N, M;
    static Game[] games;
    static boolean visited[];

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        games = new Game[101];
        visited = new boolean[101];
        for (int i = 1; i < 101; i++) {
            games[i] = new Game(i,0,0,Integer.MAX_VALUE);
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            games[Integer.parseInt(st.nextToken())].ladder = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            games[Integer.parseInt(st.nextToken())].snake = Integer.parseInt(st.nextToken());
        }
        compute();
    }

    static void compute() {
        Queue<Game> q = new LinkedList<>();
        games[1].dice = 0;
        visited[1] = true;
        q.offer(games[1]);

        while (true) {
            Game game = q.poll();
            visited[game.loc] = true;
            if (game.loc == 100) {
                System.out.println(game.dice);
                break;
            }

            for (int i = 1; i < 7; i++) {
                int nextIdx = game.loc + i;
                if (nextIdx > 100) {
                    continue;
                }
                if(!visited[nextIdx]){
                    if (games[nextIdx].ladder != 0) {
                        games[games[nextIdx].ladder].dice = Math.min(games[games[nextIdx].ladder].dice,game.dice + 1);
                        q.offer(games[games[nextIdx].ladder]);
                    } else if (games[nextIdx].snake != 0) {
                        games[games[nextIdx].snake].dice = Math.min(games[games[nextIdx].snake].dice,game.dice + 1);
                        q.offer(games[games[nextIdx].snake]);
                    } else {
                        games[nextIdx].dice = Math.min(games[nextIdx].dice,game.dice + 1);
                        q.offer(games[nextIdx]);
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BOJ16928.solution();
    }
}
