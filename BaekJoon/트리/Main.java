package BaekJoon.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, delete;
    static int[] node;
    static int res = 0;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        node = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        int root = 0;
        for (int i = 0; i < N; i++) {
            node[i] = Integer.parseInt(st.nextToken());
            if (node[i] == -1) {
                root = i;
            }
        }

        st = new StringTokenizer(br.readLine());
        delete = Integer.parseInt(st.nextToken());

        deleteNode(delete);

        countLeafNode(root);
        System.out.println(res);
    }

    static void deleteNode(int delete) {
        node[delete] = -2;
        for (int i = 0; i < N; i++) {
            if (node[i] == delete) {
                deleteNode(i);
            }
        }
    }

    static void countLeafNode(int idx) {
        boolean isLeaf = true;
        visited[idx] = true;
        if (node[idx] != -2) {
            for (int i = 0; i < N; i++) {
                if (node[i] == idx && !visited[i]) {
                    countLeafNode(i);
                    isLeaf = false;
                }
            }
            if (isLeaf) {
                res++;
            }
        }
    }
}
