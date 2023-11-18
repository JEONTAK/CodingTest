package D4.보급로;

import java.util.Scanner;

public class Solution {

    static int[][] array;
    static boolean[][] visited;
    static int[][] min;

    static int len;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            len = sc.nextInt();
            array = new int[len][len];
            min = new int[len][len];
            for (int i = 0; i < len; i++) {
                String input = sc.next();
                for (int j = 0; j < len; j++) {
                    array[i][j] = input.charAt(j) - '0';
                    min[i][j] = Integer.MAX_VALUE;
                }
            }
            min[0][0] = 0;
            dfs(0, 0);
            System.out.println("#" + test_case + " " + min[len - 1][len - 1]);
        }
    }

    private static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (isRange(nextX, nextY)) {
                if (min[x][y] + array[nextX][nextY] < min[nextX][nextY]) {
                    min[nextX][nextY] = min[x][y] + array[nextX][nextY];
                    dfs(nextX, nextY);
                }
            }
        }
    }

    private static boolean isRange(int x, int y) {
        return x >= 0 && x < len && y >= 0 && y < len;
    }
}


/*
import java.util.LinkedList;
        import java.util.Scanner;

class Solution
{

    static int[][] array;
    static int[][] min;
    static int len;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            len = sc.nextInt();
            array = new int[len][len];
            min = new int[len][len];
            for(int i = 0 ; i < len ; i++){
                String str = sc.next();
                for(int j = 0 ; j < len ; j++){
                    array[i][j] = str.charAt(j) - '0';
                    min[i][j] = Integer.MAX_VALUE;
                }
            }

            compute();
            System.out.printf("#%d %d\n", test_case, min[len-1][len-1]);
        }
    }

    static void compute(){
        LinkedList<Node> queue = new LinkedList<Node>();
        min[0][0] = 0;
        queue.add(new Node(0,0));

        while(!queue.isEmpty()){
            Node current = queue.poll();
            for(int i = 0 ; i < 4 ; i++){
                int nextI = current.i + dr[i];
                int nextJ = current.j + dc[i];

                if(inRange(nextI,nextJ)){
                    if(min[current.i][current.j] + array[nextI][nextJ] < min[nextI][nextJ]){
                        min[nextI][nextJ] = min[current.i][current.j] + array[nextI][nextJ];
                        queue.add(new Node(nextI,nextJ));
                    }
                }
            }
        }
    }

    static class Node{
        int i, j;
        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static boolean inRange(int i, int j) {
        return 0 <= i && i < len && 0 <= j && j < len;
    }
}*/
