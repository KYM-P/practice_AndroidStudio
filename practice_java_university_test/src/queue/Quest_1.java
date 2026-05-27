package queue;

import java.io.*;

public class Quest_1 {
    /*
 ============================================================================
 Name        : 김영민
 ID          : 2021136025
 ============================================================================
 */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    /*
        랜섬 노드와 잡지 노드를 입력받아 canConstruct 에 전달
        checkDone() 의 결과에 반복 여부 결정
     */
    public static void main(String[] args) throws IOException {
        do{
            bw.write("랜섬 노드 입력: ");
            bw.flush();
            String ransomNote = br.readLine();
            bw.write("잡지 노드 입력: ");
            bw.flush();
            String magazine = br.readLine();
            bw.write(canConstruct(ransomNote, magazine)?"랜섬 노트 작성 가능\n":"랜섬 노트 작성 불가\n");
            bw.flush();
        }while(checkDone());
    }
    /*
        a~z 26개 의 알파벳 freq 배열
        magazine 의 특정 알파벳 수 만큼 freq 항목 plus
        ransomNote 의 특정 알파벳 수 만큼 freq 항복 minus
        freq 의 한곳이라도 음수가 있다면, 알파벳의 부족으로 magazine 으로는 ransomNote 를 작성 불가
     */
    public static boolean canConstruct (String ransomNote, String magazine) {
        int freq[] = new int[26];
        for(int i = 0; i < magazine.length(); i++) {
            ++freq[magazine.charAt(i) - 'a'];
        }
        for(int i = 0; i < ransomNote.length(); i++) {
            --freq[ransomNote.charAt(i) - 'a'];
        }
        for(int i = 0; i < 26; i++) {
            if(freq[i] < 0)return false;
        }
        return true;
    }
    /*
        계속 진행 여부 판단
        단일 문자열을 읽어 소문자로 변환 후 'y'와 같은지 판단
        y 일 때 재사용을 위해 readLine()으로 버퍼 정리
     */
    public static boolean checkDone() throws IOException {
        bw.write("계속(y/n)? ");
        bw.flush();
        int done = Character.toLowerCase(br.read());
        if(done == 'y'){
            br.readLine();
            return true;
        }
        return false;
    }
}
