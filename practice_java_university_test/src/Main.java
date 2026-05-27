import java.io.*;
import java.util.*;

/*
자바프로그래밍 01분반
이름: 김영민
학번: 2021136025
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int B = 1, S = 0; // 1 은 소수
        boolean isReverse = false;
        boolean[] isBeforePrime = new boolean[]{ false , false };
        if( k > 1) {
            isReverse = true;
            isBeforePrime = new boolean[]{ true , true };
            B = 0;
            S = 2;
        }
        for(int i = 3; i <= k; ++i) {
            int index = isReverse? 0 : 1;
            //System.out.println(i  + " " + index + " " + isBeforePrime[index]);
            if(checkPrime(i)) {
                if(!isBeforePrime[index]){
                    --B;
                    ++S;
                }
                isBeforePrime[index] = true;
                isReverse = !isReverse;
                ++S;
            }else{
                ++B;
                isBeforePrime[index] = false;
            }
            //System.out.println(String.format("%d %d", B, S));
        }
        System.out.println(String.format("%d %d", B, S));
    }

    public static boolean checkPrime(int n) {
        for(int i = 2; i <= Math.sqrt(n); ++i) {
            if(n%i == 0) return false;
        }
        return true;
    }
    /* 대회7 */

    //https://judge.koreatech.ac.kr/showsource.php?id=132820

    public static void anagram () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; ++i) {
            char[] P = br.readLine().toCharArray();
            char[] S = br.readLine().toCharArray();
            HashMap<Character, Integer> Smap = new HashMap<>();
            for(int j = 0; j < S.length; ++j) { Smap.put(S[j],Smap.getOrDefault(S[j],0)+1);}
            int[] tableCount = new int[26];
            Queue<Character> table = new LinkedList<>();
            for(int j = 0; j < P.length; ++j) {
                if(!Smap.containsKey(P[j])) {
                    table.clear();
                    tableCount = new int[26];
                    continue;
                }
                table.add(P[j]);
                tableCount[P[j] - 'a'] += 1;
                if(table.size() > S.length){
                    tableCount[table.poll() - 'a'] -= 1;
                }
                if(isSame(tableCount, Smap)) bw.write((j + 1 - S.length) + " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
    public static boolean isSame(int[] count, HashMap<Character, Integer> map){
        for(char key : map.keySet()){
            if(count[key - 'a'] != map.get(key)) return false;
        }
        return true;
    }

    //https://judge.koreatech.ac.kr/showsource.php?id=132823

    final static int NUM_TO_ALPHABET = 'a' - '1';
    public static void deCode() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; ++i) {
            char[] Code = br.readLine().toCharArray();
            Queue<Character> table = new LinkedList<>();
            for(int j = 0; j < Code.length; ++j) {
                if(Code[j] == '#') {
                    bw.write((char)((table.poll() - '0')*10 + (table.poll() - '0') + 'a' - 1)); // a 는 1부터 시작
                    continue;
                }
                table.add(Code[j]);
                if(table.size() > 2){
                    bw.write((char)(table.poll() + NUM_TO_ALPHABET));
                }
            }
            while(!table.isEmpty()) bw.write((char)(table.poll() + NUM_TO_ALPHABET));
            bw.write("\n");
        }
        bw.flush();
    }
}