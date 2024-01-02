package Programmers.Level2.광물캐기;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int picksCount = picks[0] + picks[1] + picks[2];
        List<CostSum> costSum = new ArrayList<>();
        int[][] cost = new int[][]{
                {1, 1, 1},
                {5, 1, 1},
                {25, 5, 1}
        };

        int[] mineralToInt = new int[minerals.length];

        for (int i = 0; i < minerals.length; i++) {
            if (minerals[i].equals("diamond")) {
                mineralToInt[i] = 0;
            } else if (minerals[i].equals("iron")) {
                mineralToInt[i] = 1;
            } else {
                mineralToInt[i] = 2;
            }
        }

        int index = 0;

        while (picksCount > 0) {
            int diamond = 0;
            int iron = 0;
            int stone = 0;

            for (int i = 0; i < 5; i++) {
                if (index + i >= minerals.length) {
                    break;
                }

                diamond += cost[0][mineralToInt[index + i]];
                iron += cost[1][mineralToInt[index + i]];
                stone += cost[2][mineralToInt[index + i]];
            }

            picksCount--;
            index += 5;
            costSum.add(new CostSum(diamond, iron, stone));
        }

        costSum.sort(CostSum::compareTo);

        for (int i = 0; i < costSum.size(); i++) {
            if (picks[0] > 0) {
                picks[0]--;
                answer += costSum.get(i).diamond;
            } else if (picks[1] > 0) {
                picks[1]--;
                answer += costSum.get(i).iron;
            } else {
                picks[2]--;
                answer += costSum.get(i).stone;
            }
        }

        return answer;
    }

    public class CostSum implements Comparable<CostSum> {
        int diamond;
        int iron;
        int stone;

        public CostSum(int diamond, int iron, int stone) {
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
        }

        @Override
        public int compareTo(CostSum o) {
            int t1 = this.diamond + this.iron + this.stone;
            int t2 = o.diamond + o.iron + o.stone;
            if (t1 > t2) {
                return -1;
            }
            return 1;
        }
    }
}
