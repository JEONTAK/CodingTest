package BaekJoon.Gold5.영어읽기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static HashMap<String, Integer> dict = new HashMap<>();

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            makingType(word);
        }

        String sentence;
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            sentence = br.readLine();
            st = new StringTokenizer(sentence);
            long result = 1;
            while(st.hasMoreTokens()) {
                String temp = st.nextToken();
                result *= findType(temp);
            }
            System.out.println(result);
        }
    }

    static int findType(String word){
        if(word.length() <= 2){
            if (dict.containsKey(word)) {
                return dict.get(word);
            }else{
                return 0;
            }
        }else{
            StringBuilder sb = new StringBuilder();
            char[] words = new char[word.length() - 2];
            sb.append(word.charAt(0));
            sb.append(word.charAt(word.length() - 1));
            for (int i = 0; i < word.length() - 2; i++) {
                words[i] = word.charAt(i + 1);
            }
            Arrays.sort(words);
            for (int i = 0; i < words.length; i++) {
                sb.append(words[i]);
            }
            String temp = String.valueOf(sb);
            if (dict.containsKey(temp)) {
                return dict.get(temp);
            }else{
                return 0;
            }
        }
    }

    static void makingType(String word){

        if(word.length() <= 2){
            if(dict.containsKey(word)){
                dict.put(word,dict.get(word) + 1);
            }else{
                dict.put(word, 1);
            }
        }else{
            StringBuilder sb = new StringBuilder();
            char[] words = new char[word.length() - 2];
            sb.append(word.charAt(0));
            sb.append(word.charAt(word.length() - 1));
            for(int i = 0; i < word.length() - 2 ; i++){
                words[i] = word.charAt(i + 1);
            }
            Arrays.sort(words);
            for (int i = 0; i < words.length; i++) {
                sb.append(words[i]);
            }
            String temp = String.valueOf(sb);
            if(dict.containsKey(temp)){
                dict.put(temp, dict.get(temp) + 1);
            }
            else{
                dict.put(temp,1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }


}
