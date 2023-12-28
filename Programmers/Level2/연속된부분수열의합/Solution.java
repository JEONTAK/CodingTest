package Programmers.Level2.연속된부분수열의합;

/*
문제 설명
비내림차순으로 정렬된 수열이 주어질 때, 다음 조건을 만족하는 부분 수열을 찾으려고 합니다.

기존 수열에서 임의의 두 인덱스의 원소와 그 사이의 원소를 모두 포함하는 부분 수열이어야 합니다.
부분 수열의 합은 k입니다.
합이 k인 부분 수열이 여러 개인 경우 길이가 짧은 수열을 찾습니다.
길이가 짧은 수열이 여러 개인 경우 앞쪽(시작 인덱스가 작은)에 나오는 수열을 찾습니다.
수열을 나타내는 정수 배열 sequence와 부분 수열의 합을 나타내는 정수 k가 매개변수로 주어질 때, 위 조건을 만족하는 부분 수열의 시작 인덱스와 마지막 인덱스를 배열에 담아 return 하는 solution 함수를 완성해주세요. 이때 수열의 인덱스는 0부터 시작합니다.

제한사항
5 ≤ sequence의 길이 ≤ 1,000,000
1 ≤ sequence의 원소 ≤ 1,000
sequence는 비내림차순으로 정렬되어 있습니다.
5 ≤ k ≤ 1,000,000,000
k는 항상 sequence의 부분 수열로 만들 수 있는 값입니다.
 */
/*
요구 사항
    1. 투 포인터 문제
        1.1 start와 end 포인터를 사용
        1.2 두 포인터 0에서 출발
        1.3 포인터 사이의 값의 합이 k 보다 작다면, end 값을 오른쪽으로 한칸 옮김
        1.4 포인터 사이의 값의 합이 k 보다 크다면, start 값을 오른쪽으로 한칸 옮김
        1.5 포인터 사이의 값의 합이 k와 같다면, 결과 값 저장
    2. 포인터 값을 저장할 class 구현
        2.1 시작값
        2.2 종료값
        2.3 배열의 크기

 */


import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int[] sequence, int k) {

        int start = 0;
        int end = 0;
        int sum = sequence[0];
        int n = sequence.length;

        List<SubArray> subList = new ArrayList<>();
        while (true) {
            if (sum == k) {
                subList.add(new SubArray(start, end));
            }
            if (start == n && end == n) {
                break;
            }
            if (sum <= k && end < n) {
                end++;
                if (end < n) {
                    sum += sequence[end];
                }
            } else {
                if (start < n) {
                    sum -= sequence[start];
                }
                start++;
            }
        }
        subList.sort(SubArray::compareTo);

        return new int[]{subList.get(0).start, subList.get(0).end};
    }

    private static class SubArray implements Comparable<SubArray> {
        int start;
        int end;
        int size;

        public SubArray(int start, int end) {
            this.start = start;
            this.end = end;
            this.size = end - start;
        }

        @Override
        public int compareTo(SubArray o) {
            if (this.size == o.size) {
                return this.start - o.start;
            }
            return this.size - o.size;
        }
    }
}


