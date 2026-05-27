import queue.Queue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/*
 * @author 김영민
 * @ID 2021136025
 * 범용 큐 자료구조
 */
public class QueueTest {
    @Test
    void init01_test() {
        Queue<Integer> queue = new Queue<>();
        queue.push(4);
        queue.push(5);
        queue.push(3);
        int[] output = new int[3];
        int i = 0;
        while(!queue.isEmpty())
            output[i++] = queue.pop();
        assertArrayEquals(output,new int[] {4,5,3});
    }

    @Test
    void init02_test() {
        Queue<Integer> queue = new Queue<>(3);
        queue.push(4);
        queue.push(5);
        queue.push(3);
        queue.push(2);
        queue.push(1);
        queue.push(8);
        queue.push(9);
        int[] output = new int[7];
        int i = 0;
        while(!queue.isEmpty())
            output[i++] = queue.pop();
        assertArrayEquals(output,new int[] {4,5,3,2,1,8,9});
    }

    @Test
    void init03_test() {
        Queue<Integer> queue = new Queue<>(4,5,3,2,1,8,9);
        int[] output = new int[7];
        int i = 0;
        while(!queue.isEmpty())
            output[i++] = queue.pop();
        assertArrayEquals(output,new int[] {4,5,3,2,1,8,9});
        // Queue<Integer> queue = new Queue<>(new int[] {4,5,3,2,1,8,9});
    }


    @Test
    void student_test01() {
        Queue<Student> queue = new Queue<>(3);
        Student[] students = {
                new Student("임꺽정","202202",1),
                new Student("성춘향","202101",2),
                new Student("홍길동","202201",1),
                new Student("이몽룡","202202",2)
        };
        for(var student: students)
            queue.push(student);
        int i = 0;
        while(!queue.isEmpty()) {
            assertEquals(queue.pop(), students[i++]);
        }
    }


    @Test
    void student_test02() {
        Student[] students = {
                new Student("임꺽정","202202",1),
                new Student("성춘향","202101",2),
                new Student("홍길동","202201",1),
                new Student("이몽룡","202202",2)
        };
        Queue<Student> queue = new Queue<>(students);
        int i = 0;
        while(!queue.isEmpty()) {
            assertEquals(queue.pop(), students[i++]);
        }
    }

    @Test
    void iterator_test() {
        Queue<Integer> queue = new Queue<>(3);
        queue.push(4);
        queue.push(5);
        queue.push(3);
        queue.push(2);
        queue.push(1);
        queue.push(8);
        queue.push(9);
        int[] output = new int[7];
        int i = 0;
        for(var item: queue)
            output[i++] = item;
        assertArrayEquals(output,new int[] {4,5,3,2,1,8,9});
    }
}