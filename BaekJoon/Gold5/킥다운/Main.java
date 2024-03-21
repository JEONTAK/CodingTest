package BaekJoon.Gold5.킥다운;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String top, bottom;
    static int minLength;
    static char[] topChar, bottomChar;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        top = br.readLine();
        bottom = br.readLine();
        topChar = top.toCharArray();
        bottomChar = bottom.toCharArray();
        minLength = top.length() + bottom.length();
        compute();
        System.out.println(minLength);
    }

    static void compute(){
        int topIndex;
        int bottomIndex;
        boolean isNotCorrect;
        topIndex = top.length();
        while(topIndex >= 0){
            int curIndex = topIndex;
            bottomIndex = 0;
            isNotCorrect = true;
            while (curIndex < top.length() && bottomIndex < bottom.length()) {
                if (topChar[curIndex] == '2' && topChar[curIndex] == bottomChar[bottomIndex]) {
                    isNotCorrect = false;
                    break;
                }

                curIndex++;
                bottomIndex++;
            }
            if (isNotCorrect) {
                minLength = Math.min(minLength, top.length() + bottom.length() - bottomIndex);
            }
            topIndex--;
        }

        bottomIndex = 1;
        while (bottomIndex < bottom.length()) {
            topIndex = 0;
            int curIndex = bottomIndex;
            isNotCorrect = true;
            while (curIndex < bottom.length() && topIndex < top.length()) {
                if (bottomChar[curIndex] == '2' && bottomChar[curIndex] == topChar[topIndex]) {
                    isNotCorrect = false;
                    break;
                }

                curIndex++;
                topIndex++;
            }
            if (isNotCorrect) {
                minLength = Math.min(minLength, top.length() + bottom.length() - topIndex);
            }
            bottomIndex++;
        }
    }
}
