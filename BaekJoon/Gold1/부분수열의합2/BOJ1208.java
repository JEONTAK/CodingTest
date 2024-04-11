package BaekJoon.Gold1.부분수열의합2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ1208 {

    static int[] sequence;
    static int N, S;
    static ArrayList<Integer> frontList = new ArrayList<>();
    static ArrayList<Integer> backList = new ArrayList<>();
    static long sumOfS = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = sc.nextInt();

        sequence = new int[N];
        for(int i = 0 ; i < N ; i++){
            sequence[i] = sc.nextInt();
        }

        makeTree(0, 0, N / 2, frontList);
        makeTree(0, N / 2, N, backList);

        Collections.sort(frontList);
        Collections.sort(backList);


        sumOfS = 0;
        findNumOfS();

        if(S==0){
            System.out.println(sumOfS - 1);
        }else{
            System.out.println(sumOfS);
        }
    }

    static void makeTree(int sum, int start, int end, ArrayList<Integer> list){
        if(start == end){
            list.add(sum);
            return;
        }

        makeTree(sum, start + 1, end, list);
        makeTree(sum + sequence[start], start + 1, end, list);
    }

    static void findNumOfS(){
        int front = 0;
        int back = backList.size() - 1;

        while(true){
            if(front == frontList.size() || back < 0){
                break;
            }

            int frontValue = frontList.get(front);
            int backValue = backList.get(back);

            if(frontValue + backValue == S){
                long frontCount = 0;
                while(front < frontList.size() && frontList.get(front) == frontValue){
                    frontCount++;
                    front++;
                }

                long backCount = 0;
                while(0 <= back && backList.get(back) == backValue){
                    backCount++;
                    back--;
                }

                sumOfS += frontCount * backCount;
            }

            if(frontValue + backValue > S){
                back--;
            }

            if(frontValue + backValue < S){
                front++;
            }
        }
    }
}
