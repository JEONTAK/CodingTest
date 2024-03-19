package BaekJoon.Gold1.최솟값;

import java.util.Scanner;

public class Main {

    static long[] num;
    static long[] tree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int a , b;

        num = new long[N];
        tree = new long[N * 4];

        for(int i = 0 ; i < N * 4 ; i ++) {
            tree[i] = Long.MAX_VALUE;
        }

        for(int i = 0 ; i < N ; i++){
            num[i] = sc.nextLong();
        }

        makeTree(0,N - 1, 1);

        for(int i = 0 ; i < M ; i++){
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println(computeTree(0 , N - 1, 1, a - 1, b - 1));
        }
    }

    public static long makeTree(int start, int end, int node){
        if(start == end){
            return tree[node] = num[start];
        }
        int mid = (start + end) / 2;
        return tree[node] = Math.min(makeTree(start, mid, node * 2), makeTree(mid + 1, end, node * 2 + 1));
    }

    public static long computeTree(int start, int end, int node, int left, int right){
        if(left > end || right < start){
            return Long.MAX_VALUE;
        }
        if(left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return Math.min(computeTree(start, mid, node * 2, left, right), computeTree(mid + 1, end, node * 2 + 1, left, right));
    }
}
