package BaekJoon.Gold5.머리톡톡;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ1241 {

    static int N;
    static int[] num;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            num[i] = Integer.parseInt(st.nextToken());
            resultMap.put(num[i],resultMap.getOrDefault(num[i] , 0) + 1);
        }
        int[]result = new int[N];
        for (int i = 0; i < N; i++) {
            int curNum = num[i];
            int sqrtNum = (int)Math.sqrt(curNum);
            if(sqrtNum * sqrtNum == curNum){
                result[i] = -resultMap.getOrDefault(sqrtNum,0);
            } else{
                result[i] = 0;
            }
            for (int j = 1; j <= sqrtNum; j++) {
                if(curNum % j != 0) continue;
                result[i] += resultMap.getOrDefault(j, 0) + resultMap.getOrDefault(curNum / j, 0);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i] - 1).append('\n');
        }
        System.out.println(sb);
    }
}
