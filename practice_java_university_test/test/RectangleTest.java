import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    @Test
    void test_case1() {
        Rectangle rectangle = new Rectangle(0, 0, 1, 1);
        rectangle.testRectangle();
        assertTrue(rectangle.isSquare());
        assertEquals(rectangle.area(),1);
        assertEquals(rectangle.getColor(), "black");
    }
}