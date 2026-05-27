import java.util.Arrays;
import java.util.Iterator;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자료구조및실습
 * @version 2024년도 2학기
 * @author 김상진
 * @file SortedArrayList.java
 * 동적 배열, 중복 허용, 배열을 이용한 정렬 정수 리스트
 * 코드 중복 제거
 */
/*
 * 추가 작성자 : 김영민
 * ID : 2021136025
 */
public class SortedArrayList implements Iterable<Integer>{

    private class ListIterator implements Iterator<Integer>{
        int curr = 0;
        @Override public boolean hasNext() {
            return curr < numItems;
        }

        @Override public Integer next() {
            return items[curr++];
        }
    }

    private int capacity = 5;
    private int numItems = 0;
    private int[] items = null;

    public SortedArrayList() {
        items = new int[capacity];
    }

    public SortedArrayList(int capacity) {
        this.capacity = capacity;
        items = new int[capacity];
    }


    // 최소 정수 2개 이상을 나열해야 호출됨 (하나만 나열하면 위 생성자가 호출됨)
    public SortedArrayList(int... initList) {
        capacity = numItems = initList.length;
        items = initList.clone();
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public boolean isFull() {
        return false;
    } // (capacity == numItems) ?

    public int size() {
        return numItems;
    }

    public void clear() {
        numItems = 0;
    }

    private void checkRange(int index) {
        if(index < 0 || index >= numItems)
            throw new IndexOutOfBoundsException(String.format("checkRange: %d index", index));
    }

    public int get(int index) {
        checkRange(index);
        return items[index];
    }

    public void add(int item) {
        // 완성하시오.
        if(isEmpty()){
            items[0] = item;
        }else {
            if(numItems == capacity)increaseCapacity();
            int index = search(item);
            for(int i = numItems; i > index; --i) {
                items[i] = items[i-1];
            }
            items[index] = item;
        }
        ++numItems;
    }

    public int popBack() {
        if(isEmpty()) throw new IllegalStateException("popBack: empty state");
        --numItems;
        return items[numItems];
    }

    public int popFront() {
        if(isEmpty()) throw new IllegalStateException("popFront: empty state");
        int ret = items[0];
        shiftLeft(0);
        return ret;
    }

    public int peekFront() {
        if(isEmpty()) throw new IllegalStateException("peekFront: empty state");
        return items[0];
    }

    public int peekBack() {
        if(isEmpty()) throw new IllegalStateException("peekBack: empty state");
        return items[numItems - 1];
    }

    public boolean find(int item) {
        // 완성하시오.
        if(isEmpty()) throw new IllegalStateException("find: empty state");
        int index = search(item);
        return checkMatch(item,index);
    }
    // 추가
    public boolean checkMatch(int item, int index){
        return (index < numItems && items[index] == item);
    }
    public void removeFirst(int item) {
        // 완성하시오.
        if(isEmpty()) throw new IllegalStateException("removeFirst: empty state");
        int index = search(item);; // 실수형에서는 꼭 첫 번째일 필요가 없다. 꼭 처음으로 해야한다면 findFirstOverlap(item)
        if(!checkMatch(item,index)) return; // find(item) 시 search() 2회 발생
        for(int i = index; i < numItems-1; ++i) {
            items[i] = items[i+1];
        }
        --numItems;
    }

    public void removeAll(int item) {
        // 완성하시오.
        if(isEmpty()) throw new IllegalStateException("removeAll: empty state");
        int startIndex = findFirstOverlap(item); // 중복의 시작 인덱스
        if(!checkMatch(item,startIndex)) return;
        int copyIndex = search(item+1); // 앞으로 당길(복사를 시작할) 시작 인덱스
        System.arraycopy(items, copyIndex, items, startIndex, numItems - copyIndex);
        numItems -= copyIndex - startIndex;
    }
    // 추가
    public int findFirstOverlap(int item) {
        int index = search(item-1);
        return (items[index] != item)? ++index : index;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new ListIterator();
    }

    @SuppressWarnings("unused")
    private void increaseCapacity() {
        capacity *= 2;
        items = Arrays.copyOf(items, capacity);
    }

    private void shiftLeft(int startIdx){
        for(int i = startIdx; i < numItems - 1; ++i)
            items[i] = items[i + 1];
        --numItems;
    }

    @SuppressWarnings("unused")
    private void shiftRight(int startIdx) {
        for(int i = numItems; i > startIdx; --i)
            items[i] = items[i - 1];
        ++numItems;
    }

    @SuppressWarnings("unused")
    // 이진 탐색
    // @return 있으면 해당 요소가 있는 색인, 없으면 해당 요소를 삽입할 위치
    private int search(int item) {
        // 완성하시오.
        int start = 0;
        int end = numItems-1;
        int index = getMiddle(start, end);
        while(start < end){
            if (item == items[index]) return index;
            else {
                if(item < items[index]){
                    end = index - 1;
                    index = getMiddle(start, end);
                }
                else{
                    start = index + 1;
                    index = getMiddle(start, end);
                }
            }
        }
        return (item <= items[index])? index : index + 1;
    }
    // 추가
    public int getMiddle(int start, int end) {
        return (start + end) / 2;
    }
}

