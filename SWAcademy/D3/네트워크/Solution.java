package SWAcademy.D3.네트워크;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int start = 0;
        boolean flag;
        while(true){
            flag = true;
            answer++;
            q.offer(start);
            visited[start] = true;
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int i = 0; i < n; i++) {
                    if (computers[cur][i] == 1 && !visited[i]) {
                        visited[i] = true;
                        q.offer(i);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if(!visited[i]) {
                    start = i;
                    flag = false;
                }
            }
            if(flag)break;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        Solution.solution(3, computers);
    }
}
