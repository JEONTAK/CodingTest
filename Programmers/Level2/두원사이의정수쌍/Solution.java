package Programmers.Level2.두원사이의정수쌍;

/*
문제 설명
x축과 y축으로 이루어진 2차원 직교 좌표계에 중심이 원점인 서로 다른 크기의 원이 두 개 주어집니다. 반지름을 나타내는 두 정수 r1, r2가 매개변수로 주어질 때, 두 원 사이의 공간에 x좌표와 y좌표가 모두 정수인 점의 개수를 return하도록 solution 함수를 완성해주세요.
※ 각 원 위의 점도 포함하여 셉니다.

제한 사항
1 ≤ r1 < r2 ≤ 1,000,000
 */

/*
요구 사항
    1. 값 두개 받아오기
    2. 각 값을 길이로 설정
    3. 양의 좌표에서만 값을 구하고 곱하기 4
    4. y 값은 0 이상, X 값은 0 초과
    5. x 값을 1부터 r2 까지 순차적으로 실행
        5-1. 해당 x 값에서 두 원의 y 좌표 사이의 값을 가져옴
        -> 사이 갯수 = r2의 y좌표 - r1의 y좌표(올림) + 1
        5-2. answer에 더해줌
    6. 결과 출력
 */

public class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        for (int i = 1; i <= r2; i++) {
            double y1 = Dist(r1, i);
            double y2 = Dist(r2, i);
            answer += ((long) y2 - (long) Math.ceil(y1) + 1);
        }
        answer *= 4;
        return answer;
    }

    public double Dist(int x, int y) {
        return (double) Math.sqrt(Math.pow(x, 2) - Math.pow(y, 2));
    }
}
