/*
 * 작성자 : 김영민
 * ID : 2021136025
 */
public class Time {
    /*
    1)불변 클래스 맴버 변수가 객체이며 불변 객체가 아닐 때
    문제상황1) public final 선언
    Time 클래스 안에 public final Hour h; 와 같은 맴버 변수와 Hour 클래스 안에
    private int hour;, ... setHour(int)..., ...getHour(int)... 가 존재한다 가정하자
    이때 Time t 인 객체가 있다면 t.h.setHour(40);를 통해 외부에서 내부 값을 바꿀 수 있게된다.
    그렇다면 이것은 불변 클래스라고 말할 수 없게된다.
    문제상황2) 생성자 초기화, 생성자에서의 객체 참조 복사 ex) this.h = h;
    Hour a 처럼 객체를 미리 만들고 해당 a를 매개변수로 Time 클래스 생성자로 내부 객체 h 에 a의 주소를 복사하여 저장한다면
    a의 내부 변수를 수정하면 Time 클래스 내부 객체 h 또한 값이 변화하게 된다. -> 불변성 위배
    -극복
    문제상황1) public final 선언
    Time 클래스 내부 Hour h; 객체를 public 이 아닌 private 으로 선언한다.
    그렇다면 외부에서 t.h.setHour(40)을 통해 접근하려 할 때 t.h 에 접근이 불가능 하다.
    문제상황2) 생성자 초기화, 생성자에서의 객체 참조 복사 ex) this.h = h;
    this.h = new Hour(h.getHour()); 과 같이 중간에 복사본을 만들어 저장한다.
    혹은 명확한 초기화를 한 후 생성자에서 값복사 방법을 이용한다.
    private final Hour h = new Hour(0); ... this.h.setHour(h.getHour());

    2)언제, 어느 조건에서 객체 풀을 사용하는게 효과적인가? 전제조건) 불변 클래스 일 때
    1.객체가 어느정도 무거울 때
    무거운 객체를 생성하면서 발생하는 시간적 낭비를 줄일 수 있다.
    2.만들 수 있는 서로다른 객체 수가 적을 때 or 자주 사용되는 값이 있을 때
    예를들어 서로다른 객체를 400개 만들 수 있다면 400개를 모두 만들어 놓는것은 비효율적이다.
    다만 0~10 까지의 사용률이 굉장히 높은 상태라면 0~10까지의 객체만 만들고 꺼내다 쓰면 효율적이 될 수 있다.
    혹은 서로다른 객체를 10개만 만들 수 있다면 10개를 미리 만들어 놓고 꺼내다 쓰면 초기에 만드는 시간을 제외하고는
    시간적 효율성을 얻을 수 있다.
     */
    // range 0~23
    public final int hour;
    // range 0~59
    public final int minute;
    // range 0~59
    public final int second;
    public Time(int hour){
        this.hour = fitRange(hour,24);
        this.minute = 0;
        this.second = 0;
    }
    public Time(int hour, int minute){
        int minuteToHour = translateToUpper(minute,60);
        this.hour = fitRange(hour + minuteToHour,24);
        this.minute = fitRange(minute,60);
        this.second = 0;
    }
    public Time(int hour, int minute, int second){
        int secondToMinute = translateToUpper(second,60);
        int changedMinute = minute + secondToMinute;
        int minuteToHour = translateToUpper(changedMinute,60);
        this.hour = fitRange(hour + minuteToHour,24);
        this.minute = fitRange(changedMinute,60);
        this.second = fitRange(second,60);
    }
    public boolean isPM(){
        return  hour >= 12;
    }
    public Time next(int deltaHour){
        return new Time(this.hour + deltaHour,this.minute,this.second);
    }
    public Time next(int deltaHour, int deltaMinute){
        return new Time(this.hour + deltaHour, this.minute + deltaMinute,this.second);
    }
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d",this.hour,this.minute,this.second);
    }
    void testTime() {
        Time lunchTime = new Time(12, 30);
        System.out.println(lunchTime);
        System.out.println(lunchTime.isPM());
        Time quitTime = lunchTime.next(7);
        System.out.println(quitTime);
        lunchTime = lunchTime.next(24, 30);
        System.out.println(lunchTime);
        // 추가 구문
        lunchTime = lunchTime.next(0, -1);
        System.out.println(lunchTime);
        quitTime = quitTime.next(5);
        System.out.println(quitTime);
        quitTime = quitTime.next(0,-30);
        System.out.println(quitTime);
        quitTime = quitTime.next(0,-1);
        System.out.println(quitTime);
        quitTime = quitTime.next(-1,1);
        System.out.println(quitTime);
    }
    public int fitRange(int num, int range) {
        int answer = num%range;
        return (answer < 0)? range + answer : answer;
    }
    public int translateToUpper(int num, int range){
        return (num < 0)? num/range - 1 : num/range;
    }

}
