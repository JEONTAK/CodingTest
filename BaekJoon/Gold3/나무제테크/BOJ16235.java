package BaekJoon.Gold3.나무제테크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16235 {

    static class Tree implements Comparable<Tree>{
        int x;
        int y;
        int age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }

    static int N, M, K;
    static int[][] map, nutrient;
    static int[][] delta = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    static ArrayList<Tree> list = new ArrayList<>();

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nutrient = new int[N][N];
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                nutrient[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = 5;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            list.add(new Tree(x - 1, y - 1, z));
        }

        for (int i = 0; i < K; i++) {
            compute();
        }
        System.out.println(list.size());
    }

    static void compute(){
        ArrayList<Tree> dead;
        dead = spring();
        summer(dead);
        fall();
        winter();
    }

    static ArrayList<Tree> spring(){
        ArrayList<Tree> dead = new ArrayList<>();
        PriorityQueue<Tree> pq = new PriorityQueue<>();
        for (int i = 0; i < list.size(); i++) {
            pq.offer(list.get(i));
        }
        list.clear();
        while (!pq.isEmpty()) {
            Tree cur = pq.poll();
            if (cur.age > map[cur.x][cur.y]) {
                dead.add(cur);
            }else{
                map[cur.x][cur.y] -= cur.age;
                cur.age++;
                list.add(cur);
            }
        }
        return dead;
    }
    static void summer(ArrayList<Tree> dead){
        for (int i = 0; i < dead.size(); i++) {
            Tree cur = dead.get(i);
            map[cur.x][cur.y] += (cur.age / 2);
        }
        dead.clear();
    }
    static void fall(){
        PriorityQueue<Tree> pq = new PriorityQueue<>();
        for (int i = 0; i < list.size(); i++) {
            pq.add(list.get(i));
        }
        list.clear();
        while (!pq.isEmpty()) {
            Tree cur = pq.poll();
            if (cur.age % 5 != 0) {
                list.add(cur);
            }else{
                for (int i = 0; i < 8; i++) {
                    int nx = cur.x + delta[i][0];
                    int ny = cur.y + delta[i][1];
                    if (isAvailable(nx, ny)) {
                        list.add(new Tree(nx, ny, 1));
                    }
                }
                list.add(cur);
            }
        }
    }

    static void winter(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] += nutrient[i][j];
            }
        }
    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static void main(String[] args) throws IOException {
        BOJ16235.solution();
    }
}
