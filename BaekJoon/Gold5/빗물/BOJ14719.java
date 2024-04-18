package BaekJoon.Gold5.빗물;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14719 {

    static int N, M;
    static int[] height;
    static int result = 0;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        height = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }
        compute();
        System.out.println(result);
    }

    static void compute(){
        int location = 0;
        for (int i = 1; i < M; i++) {
            if(height[i] >= height[location]){
                computeWater(location, i);
                location = i;
            }
        }
        location = M - 1;
        for (int i = M - 2; i >= 0; i--) {
            if (height[i] > height[location]) {
                computeWater(location, i);
                location = i;
            }
        }
    }

    static void computeWater(int curLoc, int target){
        int sum = 0;
        if (curLoc < target) {
            for (int i = curLoc + 1; i < target; i++) {
                sum += Math.max(height[curLoc] - height[i], 0);
            }
        }else{
            for (int i = curLoc - 1; i > target; i--) {
                sum += Math.max(height[curLoc] - height[i], 0);
            }
        }
        result += sum;
    }

    public static void main(String[] args) throws IOException {
        BOJ14719.solution();
    }
}
