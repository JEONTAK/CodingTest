package BaekJoon.구간곱구하기;

import java.util.Scanner;

public class Main {

    static int[] numbers;
    static long[] numberTree;
    static long num = 1000000007;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N,M,K,a,b,c;
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        numbers = new int[N];
        numberTree = new long[N * 4];

        for(int i = 0 ; i < N ; i ++){
            numbers[i] = sc.nextInt();
        }

        for(int i = 0 ; i < N * 4 ; i++){
            numberTree[i] = 1;
        }

        makeTree(0,N - 1,1);

        for(int i = 0 ; i < M + K ; i++){
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();

            if(a == 1){
                update(0, N - 1, 1, b - 1, c);
                numbers[b - 1] = c;
            }
            else{
                System.out.println(printMulti(0, N - 1, 1, b - 1, c - 1));
            }
        }
    }

    private static long makeTree(int start, int end, int node) {
        if(start == end){
            return numberTree[node] = numbers[start];
        }
        int mid = (start + end) / 2;
        return numberTree[node] = (makeTree(start, mid, node * 2) * makeTree(mid + 1, end, node * 2 + 1)) % num;
    }

    private static long update(int start, int end, int node, int index, int newValue){
        if(index < start || index > end){
            return numberTree[node];
        }
        if(start == end){
            return numberTree[node] = newValue;
        }
        int mid = (start + end) / 2;
        return numberTree[node] = (update(start, mid, node * 2, index, newValue) * update(mid + 1, end, node * 2 + 1, index, newValue)) % num;
    }

    private static long printMulti(int start, int end, int node, int left, int right){
        if(left > end || right < start)
        {
            return 1;
        }

        if(left <= start && right >= end){
            return numberTree[node];
        }
        int mid = (start + end) / 2;

        return (printMulti(start, mid, node * 2, left, right) * printMulti(mid + 1, end, node * 2 + 1, left, right)) % num;
    }


}
