import java.io.*;
import java.util.*;

public class main2 {
    public static void main(String[] args) throws IOException{
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

    /* 대회6 */

    // https://judge.koreatech.ac.kr/showsource.php?id=132435
    public static void thirdMaximumNum() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        PriorityQueue<Integer> pq;
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; ++i) {
            int len = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");
            pq = new PriorityQueue<>();
            for(int j = 0; j < len; ++j) {
                int num = Integer.parseInt(st.nextToken());
                if(pq.contains(num)) continue;
                pq.add(num);
                if(pq.size()>3) pq.poll();
            }
            int thirdMaxNum = 0;
            if(pq.size() < 3) {
                while(!pq.isEmpty()) {
                    thirdMaxNum = pq.poll();
                }
            }else thirdMaxNum = pq.poll();
            bw.write(thirdMaxNum + "\n");
        }
        bw.flush();
    }

    //https://judge.koreatech.ac.kr/showsource.php?id=132440
    public static void pairAndLeftOutNum() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        HashMap<Integer,Integer> hm;
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; ++i) {
            int len = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");
            hm = new HashMap<>();
            for(int j = 0; j < len; ++j) {
                int num = Integer.parseInt(st.nextToken());
                if(hm.containsKey(num)) hm.replace(num, hm.get(num) + 1);
                else hm.put(num, 1);
            }
            int pairNum = 0;
            int leftOutNum = 0;
            for(var value : hm.values()){
                pairNum += value/2;
                leftOutNum += value%2;
            }
            bw.write(String.format("%d %d\n", pairNum, leftOutNum));
        }
        bw.flush();
    }

    /* 대회5 */

    // https://judge.koreatech.ac.kr/showsource.php?id=131857
    public static void changeToSmallNumber() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; ++i) {
            char[] numItems = br.readLine().toCharArray();
            char beforeNum = numItems[0];
            for (int j = 1; j < numItems.length; ++j) {
                char currNum = numItems[j];
                if (beforeNum % 2 == currNum % 2 && beforeNum > currNum) {
                    numItems[j - 1] = currNum;
                    numItems[j] = beforeNum;
                    break;
                }
                beforeNum = currNum;
            }
            bw.write(numItems);
            bw.write('\n');
        }
        bw.flush();
    }

    // https://judge.koreatech.ac.kr/showsource.php?id=131859
    public static void differenceOfTwoNumber() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int num1 = 0, num2 = 0;
            for (int j = 1; j <= n; ++j) {
                if (j % m == 0) num2 += j;
                else num1 += j;
            }
            bw.write((num1 - num2) + "\n");
        }
        bw.flush();
    }
    /* 대회4 */

    // https://judge.koreatech.ac.kr/showsource.php?id=131664
    public static void changeToNine() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int numItems = Integer.parseInt(br.readLine());
        for(int i = 0; i < numItems; ++i) {
            int item = Integer.parseInt(br.readLine());
            int copyItem = item;
            int biggestSixDigit = 0;
            int digit = 1;
            while(copyItem != 0){
                if(copyItem%10 == 6){
                    biggestSixDigit = digit;
                }
                digit *= 10;
                copyItem /= 10;
            }
            bw.write(String.valueOf(item + biggestSixDigit*3) + '\n');
        }
        bw.flush();
    }
    // https://judge.koreatech.ac.kr/showsource.php?id=132013
    public static void changeToOnesComplement() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0; i < testCase; ++i) {
            int item = Integer.parseInt(br.readLine());
            int bit = 1;
            while(bit <= item) {
                bit <<= 1;
            }
            bit -= 1;
            bw.write(String.valueOf(item^bit) + '\n');
        }
        bw.flush();
    }
}
