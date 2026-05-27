/*
 * 작성자 : 김영민
 * ID : 2021136025
 */
public class Rectangle {
    private int x = 0;
    private int y = 0;
    /*
        Private Point p;
        // 내부 클래스
        class Point {
            private int x = 0;
            private int y = 0;
            // (isNotNegative() 를 사용할 수 있다 가정)
            public void setX(int x) { this.x = isNotNegative(x)? x : this.x; }
            public void setY(int y) { this.y = isNotNegative(y)? y : this.y; }
            public int getX() { return x; }
            public int getY() { return y; }
        }
     */
    private int width = 1;
    private int height = 1;

    // 추가 상태 ( color )
    private String color = "black";

    public Rectangle(int leftTop_x, int leftTop_y, int width, int height){
        // x = Math.max(leftTop_x, x); 도 가능
        this.x = isNotNegative(leftTop_x)? leftTop_x : 0;
        this.y = isNotNegative(leftTop_y)? leftTop_y : 0;
        this.width = Math.max(this.width, width);
        this.height = Math.max(this.height, height);
    }
    public int getHeight(){return height;}
    public int getWidth(){return width;}
    public int area(){return Math.multiplyExact(height,width);}
    public boolean isSquare(){return (height == width);}
    public void moveTo(int x, int y){
        if ( isNotNegative(x) && isNotNegative(y)){
            this.x = x;
            this.y = y;
        }
    }
    /*
        moveTo ( Point 클래스로 x, y 값을 유지할 경우 )
        private Point p;
        ...
        public void moveTo(int x, int y){
            // 단 Point 의 메소드로 setX(), getX() , setY(), getY() 구현 상태
            p.setX(isNotNegative(x)? x : p.getX());
            p.setY(isNotNegative(y)? y : p.getY());
        }
     */
    public void moveBy(int deltaX, int deltaY){
        x = isNotNegative(x + deltaX)? x + deltaX : x;
        y = isNotNegative(y + deltaY)? y + deltaY : y;
    }
    /*
        moveBy ( Point 클래스로 x, y 값을 유지할 경우 )
        private Point p;
        ...
        public void moveBy(int deltaX, int deltaY){
            // 단 Point 의 메소드로 setX(), getX() , setY(), getY() 구현 상태
            int nextX = p.getX() + deltaX;
            int nextY = p.getY() + deltaY;
            p.setX(isNotNegative(nextX)?nextX:p.getX());
            p.setY(isNotNegative(nextY)?nextY:p.getY());
        }
     */
    public boolean isInside(int x, int y) {
        return (x > this.x && x < this.x + width) && (y < this.y && y > this.y - height);
    }
    private boolean isNotNegative(int a){
        return a >= 0;
    }

    // 추가 메소드 setColor(String color), getColor()
    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }
    public void setHeight(int height) {
        if(height > 0){
            this.height = height;
        }
    }
    public void setWidth(int width) {
        if(width > 0){
            this.width = width;
        }
    }
    // test 메소드
    public void testRectangle() {
        Rectangle rectangle = new Rectangle(0, 0, 1, 1);
        System.out.println(rectangle.isSquare()); // true
        System.out.println(rectangle.area()); // 1
        rectangle.moveTo(-5,5);
        System.out.println(rectangle.area()); // 1
        rectangle.setWidth(5);
        rectangle.setHeight(5);
        System.out.println(rectangle.area()); // 25
        rectangle.moveBy(5,5);
        System.out.println(rectangle.isInside(7,2)); // true
    }
}
