import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeTest {
    @Test
    void test_case1() {
        Time lunchTime = new Time(12, 30);
        assertEquals(lunchTime.toString(), "12:30:00");
        assertTrue(lunchTime.isPM());
        Time quitTime = lunchTime.next(7);
        assertEquals(quitTime.toString(), "19:30:00");
        lunchTime = lunchTime.next(24, 30);
        assertEquals(lunchTime.toString(), "13:00:00");
    }
}