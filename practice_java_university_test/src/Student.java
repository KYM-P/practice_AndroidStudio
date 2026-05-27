public final class Student implements Cloneable {
    private String name;
    private String number;
    private int year;
    public Student(String name, String number, int year) {
        this.name = name;
        this.number = number;
        this.year = year;
    }
    @Override public String toString() {
        return String.format("(%s, %s, %d)", name, number, year);
    }
    @Override public boolean equals(Object other) {
        if(other == null || getClass() != other.getClass()) return false;
        if(this == other) return true;
        Student s = (Student)other;
        return name.equals(s.name) && number.equals(s.number) && year == s.year;
    }
    @Override public Student clone() {
        Student cloned = null;
        try {
            cloned = (Student)super.clone();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return cloned;
    }
}
