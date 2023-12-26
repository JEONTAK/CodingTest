package Programmers.요격시스템;

/*
문제 설명
A 나라가 B 나라를 침공하였습니다. B 나라의 대부분의 전략 자원은 아이기스 군사 기지에 집중되어 있기 때문에 A 나라는 B 나라의 아이기스 군사 기지에 융단폭격을 가했습니다.
A 나라의 공격에 대항하여 아이기스 군사 기지에서는 무수히 쏟아지는 폭격 미사일들을 요격하려고 합니다. 이곳에는 백발백중을 자랑하는 요격 시스템이 있지만 운용 비용이 상당하기 때문에 미사일을 최소로 사용해서 모든 폭격 미사일을 요격하려 합니다.
A 나라와 B 나라가 싸우고 있는 이 세계는 2 차원 공간으로 이루어져 있습니다. A 나라가 발사한 폭격 미사일은 x 축에 평행한 직선 형태의 모양이며 개구간을 나타내는 정수 쌍 (s, e) 형태로 표현됩니다. B 나라는 특정 x 좌표에서 y 축에 수평이 되도록 미사일을 발사하며, 발사된 미사일은 해당 x 좌표에 걸쳐있는 모든 폭격 미사일을 관통하여 한 번에 요격할 수 있습니다. 단, 개구간 (s, e)로 표현되는 폭격 미사일은 s와 e에서 발사하는 요격 미사일로는 요격할 수 없습니다. 요격 미사일은 실수인 x 좌표에서도 발사할 수 있습니다.
각 폭격 미사일의 x 좌표 범위 목록 targets이 매개변수로 주어질 때, 모든 폭격 미사일을 요격하기 위해 필요한 요격 미사일 수의 최솟값을 return 하도록 solution 함수를 완성해 주세요.

제한 사항
1 ≤ targets의 길이 ≤ 500,000
targets의 각 행은 [s,e] 형태입니다.
이는 한 폭격 미사일의 x 좌표 범위를 나타내며, 개구간 (s, e)에서 요격해야 합니다.
0 ≤ s < e ≤ 100,000,000

*/

/*
요구 사항
    1. 받은 값을 Sorting
    2. Sorting한 값을 순서대로 계산
        2-1.첫 값의 범위를 가져 옴
        2-2. 다음 값의 시작이 현재 값의 범위 안에 있을 경우(현재 시작값 <= 다음 값 < 현재 끝값)
            시작 값은 둘 중에 큰것, 끝 값은 둘 중에 작은 것으로 설정
            (왜 -> 범위를 더 작게 해주어야 에러 발생 X)
        2-3. 범위 안에 없으면 현재 값을 다음 값으로 설정 및 answer++
    3. 결과 출력
 */

import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public static class Data implements Comparable<Data> {
        public int start;
        public int end;

        public Data(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Data data) {
            if (data.start < start) {
                return 1;
            } else if (data.start > start) {
                return -1;
            }
            return 0;
        }
    }

    public int solution(int[][] targets) {
        int answer = 0;
        ArrayList<Data> list = new ArrayList<Data>();

        for (int[] target : targets) {
            list.add(new Data(target[0], target[1]));
        }

        Collections.sort(list);
        int startPoint = list.get(0).start;
        int endPoint = list.get(0).end;
        answer++;

        for (int i = 1; i < list.size(); i++) {
            if (startPoint <= list.get(i).start && list.get(i).start < endPoint) {
                startPoint = Math.max(startPoint, list.get(i).start);
                endPoint = Math.min(endPoint, list.get(i).end);
            } else {
                startPoint = list.get(i).start;
                endPoint = list.get(i).end;
                answer++;
            }
        }
        return answer;
    }
}
