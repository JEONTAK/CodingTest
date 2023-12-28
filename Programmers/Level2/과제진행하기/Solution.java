package Programmers.Level2.과제진행하기;
/*
문제 설명
과제를 받은 루는 다음과 같은 순서대로 과제를 하려고 계획을 세웠습니다.

과제는 시작하기로 한 시각이 되면 시작합니다.
새로운 과제를 시작할 시각이 되었을 때, 기존에 진행 중이던 과제가 있다면 진행 중이던 과제를 멈추고 새로운 과제를 시작합니다.
진행중이던 과제를 끝냈을 때, 잠시 멈춘 과제가 있다면, 멈춰둔 과제를 이어서 진행합니다.
만약, 과제를 끝낸 시각에 새로 시작해야 되는 과제와 잠시 멈춰둔 과제가 모두 있다면, 새로 시작해야 하는 과제부터 진행합니다.
멈춰둔 과제가 여러 개일 경우, 가장 최근에 멈춘 과제부터 시작합니다.
과제 계획을 담은 이차원 문자열 배열 plans가 매개변수로 주어질 때, 과제를 끝낸 순서대로 이름을 배열에 담아 return 하는 solution 함수를 완성해주세요.

제한사항
3 ≤ plans의 길이 ≤ 1,000
plans의 원소는 [name, start, playtime]의 구조로 이루어져 있습니다.
name : 과제의 이름을 의미합니다.
2 ≤ name의 길이 ≤ 10
name은 알파벳 소문자로만 이루어져 있습니다.
name이 중복되는 원소는 없습니다.
start : 과제의 시작 시각을 나타냅니다.
"hh:mm"의 형태로 "00:00" ~ "23:59" 사이의 시간값만 들어가 있습니다.
모든 과제의 시작 시각은 달라서 겹칠 일이 없습니다.
과제는 "00:00" ... "23:59" 순으로 시작하면 됩니다. 즉, 시와 분의 값이 작을수록 더 빨리 시작한 과제입니다.
playtime : 과제를 마치는데 걸리는 시간을 의미하며, 단위는 분입니다.
1 ≤ playtime ≤ 100
playtime은 0으로 시작하지 않습니다.
배열은 시간순으로 정렬되어 있지 않을 수 있습니다.
진행중이던 과제가 끝나는 시각과 새로운 과제를 시작해야하는 시각이 같은 경우 진행중이던 과제는 끝난 것으로 판단합니다.
 */

/*
요구 사항
    1. 과제 시작 시간 변환 및 오름차순으로 정렬
    2. 과제 관리를 위한 Stack 생성 - Stack에 과제를 담고, 남은 과제를 할지, 새 과제를 할지 비교
    3. 현재 작업 중인 과제와 새 과제를 비교
        3.1 Stack이 비어있음
            스택에 새 과제 Push
        3.2 Stack이 비어있지 않음
            3.2.1 현재 시간 (stack에서 peek 한 값의 시작 시간 + 과제 진행 시간)이 새 과제 시간보다 같거나 작음
                현재 과제 종료 및 남아 있는 작업이 있다면 recursive 하게 pop
            3.2.2현재 시간이 새 과제 시간보다 늦은 경우
                새 작업 진행을 위해 스택에 새 작업을 push, 현재 과제에서 진행한 시간만큼 빼준다.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {

    public String[] solution(String[][] plans) {
        String[] answer = {};
        Subject[] subs = new Subject[plans.length];
        for (int i = 0; i < plans.length; i++) {
            Subject sub = new Subject(plans[i][0], plans[i][1], plans[i][2]);
            subs[i] = sub;
        }

        Arrays.sort(subs, ((o1, o2) -> {
            return o1.start - o2.start;
        }));

        Stack<Subject> stack = new Stack<>();
        List<String> ans = new ArrayList<>();

        int curTime = -1;

        for (int i = 0; i < subs.length; i++) {
            if (stack.isEmpty()) {
                stack.push(subs[i]);
                continue;
            }

            Subject curSub = stack.peek();
            Subject newSub = subs[i];

            curTime = curSub.start;

            if (curTime + curSub.time <= newSub.start) {
                recursivePop(stack, newSub, curTime, ans);
            } else {
                curSub.time -= newSub.start - curTime;
            }

            stack.push(newSub);
        }

        while (!stack.isEmpty()) {
            ans.add(stack.pop().name);
        }
        return ans.toArray(new String[0]);

    }

    public void recursivePop(Stack<Subject> stack, Subject newSub, int curTime, List<String> ans) {
        if (stack.isEmpty()) {
            return;
        }
        Subject curSub = stack.peek();   // 진행중 과제
        if (curTime + curSub.time <= newSub.start) {
            ans.add(stack.pop().name);
            recursivePop(stack, newSub, curTime + curSub.time, ans);
        } else {
            curSub.time -= newSub.start - curTime;
        }
    }


    private static class Subject {

        private String name;
        private int start;
        private int time;

        public Subject(String name, String start, String time) {
            this.name = name;
            this.start = timeToMinute(start);
            this.time = Integer.parseInt(time);
        }

        public int timeToMinute(String start) {
            String[] arr = start.split(":");
            int h = Integer.parseInt(arr[0]) * 60;
            int m = Integer.parseInt(arr[1]);
            return h + m;
        }
    }
}

