package BaekJoon.Gold1.외판원순회;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int INF = 16_000_000;
    static int[][] road, dp;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        road = new int[N][N];

        for(int i = 0 ; i < N ; i ++){
            for(int j = 0 ; j < N ; j++){
                road[i][j] = sc.nextInt();
            }
        }

        dp = new int[N][(1<<N)-1];

        for(int i = 0 ; i < N ; i++){
            Arrays.fill(dp[i], -1);
        }

        System.out.println(dfs(0,1));
    }

    static int dfs(int current, int visit){
        if(visit == (1 << N) -1 ){
            if(road[current][0] == 0) return INF;
            return road[current][0];
        }

        if(dp[current][visit] != -1) return dp[current][visit];
        dp[current][visit] = INF;

        for(int i = 0 ; i < N ; i++){
            if((visit & (1 << i)) == 0 && road[current][i] != 0){
                dp[current][visit] = Math.min(dfs(i, visit | (1 << i)) + road[current][i], dp[current][visit]);
            }
        }
        return dp[current][visit];
    }
}
