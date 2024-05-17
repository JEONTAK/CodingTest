package BaekJoon.Gold4.전화번호목록;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class BOJ5052 {

    static class Node{
        HashMap<Character, Node> child;
        boolean eOW;

        public Node(){
            this.child = new HashMap<>();
            this.eOW = false;
        }
    }

    static class Trie{
        Node root;

        public Trie(){
            this.root = new Node();
        }

        public void insert(String str){
            Node node = this.root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                node.child.putIfAbsent(c, new Node());
                node = node.child.get(c);
                if (node.eOW) {
                    flag = false;
                }
            }
            node.eOW = true;
        }

    }

    static int T, N;
    static String tele[];
    static boolean flag;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            tele = new String[N];
            flag = true;
            for (int j = 0; j < N; j++) {
                tele[j] = br.readLine();
            }
            Arrays.sort(tele);
            Trie trie = new Trie();
            for (int j = 0; j < N; j++) {
                trie.insert(tele[j]);
                if(!flag)break;
            }
            if (flag) {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ5052.solution();
    }
}
