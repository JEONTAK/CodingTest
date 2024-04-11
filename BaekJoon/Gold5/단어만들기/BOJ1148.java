package BaekJoon.Gold5.단어만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ1148 {
    static final int AToZ = 'z' - 'a' + 1;
    static final int Word_Limit = 200000;
    static int[][] word = new int[Word_Limit][AToZ];

    static int boarCnt = 0;
    static int wordCnt = 0;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while(true){
            temp = br.readLine();
            if (temp.contains("-")) {
                break;
            }
            for (int i = 0; i < temp.length(); i++) {
                word[wordCnt][temp.charAt(i) - 'A']++;
            }
            wordCnt++;
        }

        while (true) {
            int[] board = new int[AToZ];
            int[] result = new int[AToZ];
            temp = br.readLine();
            if(temp.contains("#")){
                break;
            }
            for (int i = 0; i < temp.length(); i++) {
                board[temp.charAt(i) - 'A']++;
            }
            compute(board, result);
        }
    }

    static void compute(int[] board, int[] result){
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < wordCnt; i++) {
            //불가능한 단어 무시
            if(!isValid(word[i],board)) continue;
            
            //가능한 단어 알파벳 카운팅
            for (int j = 0; j < AToZ; j++) {
                if (word[i][j] != 0) {
                    result[j]++;
                }
            }
        }

        //Min Max 체크
        for (int i = 0; i < AToZ; i++) {
            if(board[i] == 0) continue;
            if(min > result[i]) min = result[i];
            if(max < result[i]) max = result[i];
        }
        
        //최소 출력
        for (int i = 0; i < AToZ; i++) {
            if (board[i] != 0 && result[i] == min) {
                answer.append((char)('A' + i));
            }
        }
        answer.append(' ').append(min).append(' ');
        
        //최대 출력
        for (int i = 0; i < AToZ; i++) {
            if (board[i] != 0 && result[i] == max) {
                answer.append((char)('A' + i));
            }
        }
        answer.append(' ').append(max).append('\n');
        System.out.print(answer);
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }

    static boolean isValid(int[] word, int[] board){
        for (int i = 0; i < AToZ; i++) {
            if(board[i] < word[i]) return false;
        }
        return true;
    }
}
