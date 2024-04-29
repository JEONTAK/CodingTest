package BaekJoon.Gold5.압축;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1662 {

    static String S;
    static String[] splitStr;
    static int idx;
    static Stack<String> stack = new Stack<>();

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        splitStr = S.split("");
        System.out.println(compute(0));
    }
    static int compute(int s){
        int len = 0;
        for (int i = s; i < splitStr.length; i++) {
            if (splitStr[i].equals("(")) {
                //"(" 를 찾으면 스택에 집어 넣음
                //길이에 ( 이전 숫자 * 안쪽 길이 추가
                //i를 ")"위치로 변경
                stack.push(splitStr[i]);
                len += Integer.parseInt(splitStr[i - 1]) * compute(i + 1) - 1;
                i = idx;
            } else if (splitStr[i].equals(")")) {
                //")" 를 찾으면
                //만약 스택이 비어있지 않고, 스택에서 뽑았을 때 "("면
                //idx를 ")"위치로 바꿈
                //스택에서 제거한 후
                //길이 리턴
                if (!stack.isEmpty() && stack.peek().equals("(")) {
                    idx = i;
                    stack.pop();
                    return len;
                }
            }else{
                //만약 숫자이면 길이 + 1
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) throws IOException {
        BOJ1662.solution();
    }
}
