import java.util.Arrays;
import java.util.Iterator;
/*
 * ID: 2021136025
 * 수정자: 김영민
 * 수정부분 popBack, removeFirst, removeAll
 * 내용: 2개의 포인터(prev, curr)를 1개(prev)로 변경
 * 추가 내용: 수정부분에 "// 수정" 표시
 */


public class UnsortedLinkedList implements Iterable<Integer> {
    public static class Node {
        public static int count = 0;
        {
            ++count;
        }
        private int item;
        private Node next;
        public Node(int item) {
            this(item, null);
        }
        public Node(int item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
    private class ListIterator implements Iterator<Integer> {
        private Node curr = head;
        @Override public boolean hasNext() {
            return curr != null;
        }

        @Override public Integer next() {
            int ret = curr.item;
            curr = curr.next;
            return ret;
        }

    }
    private Node head = null;
    private int numItems = 0;
    public UnsortedLinkedList() {}
    public UnsortedLinkedList(int... initList) {
        if(initList.length == 0) return;
        Node curr = new Node(initList[0]);
        head = curr;
        for(int i = 1; i < initList.length; ++i) {
            Node newNode = new Node(initList[i]);
            curr.next = newNode;
            curr = newNode;
        }
        numItems = initList.length;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean isFull() {
        return false;
    }

    public int size() {
        return numItems;
    }

    public void clear() {
        head = null;
        numItems = 0;
    }

    private void checkRange(int index) {
        if(index < 0 || index >= numItems)
            throw new IndexOutOfBoundsException(String.format("checkRange: %d index", index));
    }

    private Node getNode(int index) {
        Node curr = head;
        for(int i = 0; i < index; ++i) curr = curr.next;
        return curr;
    }

    private Node getTail() {
        return getNode(numItems - 1);
    }

    public int get(int index) {
        checkRange(index);
        return getNode(index).item;
    }

    public void set(int index, int item) {
        checkRange(index);
        getNode(index).item = item;
    }

    public void pushBack(int item) {
        Node newNode = new Node(item);
        if(isEmpty()) head = newNode;
        else getTail().next = newNode;
        ++numItems;
    }


    // 수정
    public int popBack() {
        if(isEmpty()) throw new IllegalStateException("popBack: empty state");
        Node dummy = new Node(-1, head);
        Node prev = dummy;
        while(prev.next.next != null){ // prev.next 가 마지막 노드가 아니면 반복
            prev = prev.next; // 다음으로 진행
        }
        int ret = prev.next.item; // 마지막 노드의 값을 결과로 지목
        prev.next = null; // 마지막 노드 삭제
        head = dummy.next; // 기존 head 값이 제거되었을 때의 상황 대비
        --numItems; // 총 아이템 수 감소
        return ret; // 결과 반환
    }

    public void pushFront(int item) {
        Node newNode = new Node(item, head);
        head = newNode;
        ++numItems;
    }

    public int popFront() {
        if(isEmpty()) throw new IllegalStateException("popFront: empty state");
        int ret = head.item;
        head = head.next;
        --numItems;
        return ret;
    }

    int peekFront() {
        if(isEmpty()) throw new IllegalStateException("peekFront: empty state");
        return head.item;
    }

    int peekBack() {
        if(isEmpty()) throw new IllegalStateException("peekBack: empty state");
        return getTail().item;
    }

    boolean find(int item) {
        Node curr = head;
        while(curr != null){
            if(curr.item == item) return true;
            curr = curr.next;
        }
        return false;
    }

    private void removeNode(Node prev, Node curr) {
        prev.next = curr.next;
        --numItems;
    }


    // 수정
    public void removeFirst(int item) {
        Node dummy = new Node(-1, head);
        Node prev = dummy;
        while(prev.next != null){ // prev.next 의 값이 null 이 아니면 반복
            if(prev.next.item == item) { // prev.next 의 값이 item 일 때
                removeNode(prev, prev.next); // prev.next 노드 삭제
                break;
            }
            prev = prev.next; // prev.next 의 값이 item 가 아니면 다음 Node 로 이동
        }
        head = dummy.next; // 기존 head 값이 제거되었을 때의 상황 대비
    }


    // 수정
    void removeAll(int item) {
        Node dummy = new Node(-1, head);
        Node prev = dummy;
        while(prev.next != null) {  // prev.next 의 값이 null 이 아니면 반복
            if(prev.next.item == item) removeNode(prev, prev.next); // prev.next 의 값이 item 일 때 prev.next 노드 삭제
            else prev = prev.next; // prev.next 의 값이 item 가 아니면 다음 Node 로 이동
        }
        head = dummy.next; // 기존 head 값이 제거되었을 때의 상황 대비
    }

    @Override public Iterator<Integer> iterator() {
        return new ListIterator();
    }
}
