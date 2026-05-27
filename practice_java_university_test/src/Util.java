import java.util.Comparator;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자료구조및실습
 * @version 2024년도 2학기
 * @author 김상진
 * Util.java
 * 힙정렬 (in-place sort)
 */
/*
 수정자 : 김영민
 학번 : 2021136025
 */
public class Util {
    @SuppressWarnings("unused")
    private static <T extends Object & Comparable<? super T>> void reheapDown(T[] items, int size, int index, Comparator<T> comparator) {
        // heap 은 MaxHeap 으로 유지
        while(true){
            int leftChildIndex = index*2 + 1;
            int rightChildIndex = leftChildIndex + 1;
            if(leftChildIndex >= size) return; // 더이상 자식이 없을 때
            int preferChildIndex;
            // 가장 큰 값이 root 에 오도록 정렬
            if (rightChildIndex >= size) preferChildIndex = leftChildIndex;
            else preferChildIndex = (comparator.compare(items[leftChildIndex],items[rightChildIndex]) > 0)? leftChildIndex : rightChildIndex;

            if(comparator.compare(items[preferChildIndex], items[index]) > 0){ // 자식이 부모보다 크다면
                swap(items,preferChildIndex, index);
                index = preferChildIndex;
            } else return;
        }
    }
    // 주어진 배열을 이진힙으로 바꾸기 O(n)
    private static <T extends Object & Comparable<? super T>> void heapify(T[] items, Comparator<T> comparator) {
        //
        int lastParentsIndex = (items.length - 2) / 2;
        for(int i = lastParentsIndex; i >= 0; --i) {
            reheapDown(items, items.length, i, comparator);
        }
    }
    @SuppressWarnings("unused")
    private static <T extends Object & Comparable<? super T>> void swap(T[] items, int a, int b) {
        T tmp = items[a];
        items[a] = items[b];
        items[b] = tmp;
    }
    // 이진 힙을 정렬된 상태로 바꾸기
    private static <T extends Object & Comparable<? super T>> void reorder(T[] items, Comparator<T> comparator){
        //
        for(int i = items.length-1; i > 0; --i) { // 뒤에서부터 전진
            swap(items,0,i);  // MaxHeap 으로 root 의 정상은 가장 가장 큰 값이 존재 즉 해당 값을 맨 뒤로 보냄 -> 오름차순 정렬
            reheapDown(items,i,0,comparator); // 다시 heap 유지
        }
    }

    public static <T extends Object & Comparable<? super T>> void sort(T[] items) {
        sort(items, (a, b)->a.compareTo(b));
    }

    // 단계 1. 기존 배열을 이진힙 특성을 갖도록 재배치: 비용 O(n)
    // 단계 2. 가장 큰 값을 맨 뒤로 이동한 후 이 값을 제외하고 이진힙 다시 구성 O(n log n)
    public static <T extends Object & Comparable<? super T>> void sort(T[] items, Comparator<T> comparator) {
        heapify(items, comparator);
        reorder(items, comparator);
    }
}