import java.util.Arrays;
import java.util.Iterator;
/*
 * ID: 2021136025
 * 수정자: 김영민
 * 추가 부분 : add(int item)
 * 수정 부분 : popFront, popBack, removeFirst, removeAll
 * 내용: 비정렬 구조를 정렬 구조로 변경
 * 추가 내용 : 수정부분에 "// 수정" 표시
 *  set 메소드는 삭제하지는 않음
 */
public class DoubleSortedLinkedList implements Iterable<Integer> {
    private static class Node {
        int item;
        Node prev;
        Node next;
        public Node(int item) {
            this(item, null, null);
        }
        public Node(int item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
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
    private Node tail = null;
    private int numItems = 0;
    public DoubleSortedLinkedList() {}
    public DoubleSortedLinkedList(int... initList) {
        if(initList.length == 0) return;
        int[] sortedInitList = Arrays.stream(initList).sorted().toArray();
        Node curr = new Node(sortedInitList[0]);
        head = curr;
        for(int i = 1; i < sortedInitList.length; ++i) {
            Node newNode = new Node(sortedInitList[i]);
            curr.next = newNode;
            newNode.prev = curr;
            curr = newNode;
        }
        tail = curr;
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

    public Node getNode(int index) {
        Node curr = head;
        for(int i = 0; i < index; ++i) curr = curr.next;
        return curr;
    }

    public int get(int index) {
        checkRange(index);
        return getNode(index).item;
    }
    // 삭제?
    public void set(int index, int item) {
        checkRange(index);
        getNode(index).item = item;
    }
    public void add(int item){
        Node dummy = new Node(0,null,head); // 더미
        Node curr = dummy;
        while(curr.next != null) { // 추가할 위치까지 curr 이동
            if(curr.next.item <= item){
                curr = curr.next;
            }else break;
        }
        curr.next = new Node(item, curr, curr.next);
        if(curr.next.next != null) curr.next.next.prev = curr.next;// 리스트 중간 Node 일 때 or 첫 Node 일 때
        else tail = curr.next;  // 리스트 마지막 Node 일 때 or 빈 리스트 일 때
        if(curr == dummy) {
            head = curr.next;
            curr.next.prev = null;
        }
        ++numItems;
    }

    public int popBack() {
        if(isEmpty()) throw new IllegalStateException("popBack: empty state");
        int ret = tail.item;
        Node prev = tail.prev;
        if(prev != null) {
            tail = prev;
            tail.next = null;
        }
        else head = tail = null;
        --numItems;
        return ret;
    }
    public int popFront() {
        if(isEmpty()) throw new IllegalStateException("popFront: empty state");
        int ret = head.item;
        head = head.next;
        if(head != null) head.prev = null;
        else tail = null;
        --numItems;
        return ret;
    }

    int peekFront() {
        if(isEmpty()) throw new IllegalStateException("peekFront: empty state");
        return head.item;
    }

    int peekBack() {
        if(isEmpty()) throw new IllegalStateException("peekBack: empty state");
        return tail.item;
    }

    // 수정
    boolean find(int item) {
        Node curr = head;
        while(curr != null && curr.item <= item) {
            if(curr.item == item) return true;
            curr = curr.next;
        }
        return false;
    }

    // 수정
    void removeFirst(int item) {
        if(isEmpty()) return;
        Node curr = head;
        while(curr != null && curr.item <= item) {
            if(curr.item == item) {
                if(curr.prev != null)curr.prev.next = curr.next;
                if(curr.next != null) curr.next.prev = curr.prev;
                if(curr == head) head = curr.next;
                if(curr == tail) tail = curr.prev;
                --numItems;
                break;
            }
            curr = curr.next;
        }
    }
    // 수정
    void removeAll(int item) {
        if(isEmpty()) return;
        Node curr = head;
        while(curr != null && curr.item <= item) {
            if(curr.item == item) {
                if(curr.prev != null)curr.prev.next = curr.next;
                if(curr.next != null) curr.next.prev = curr.prev;
                if(curr == head) head = curr.next;
                if(curr == tail) tail = curr.prev;
                --numItems;
            }
            curr = curr.next;
        }
    }

    @Override public Iterator<Integer> iterator() {
        return new ListIterator();
    }
}