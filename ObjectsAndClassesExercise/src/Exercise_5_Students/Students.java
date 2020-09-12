package Exercise_5_Students;

public class Students {
    private String firstName;
    private String secondName;
    private double grade;

    public double getGrade() {
        return this.grade;
    }

    public Students (String firstName, String secondName, double grade) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.grade = grade;
    }


    @Override

    public String toString (){
        return String.format("%s %s: %.2f",this.firstName,this.secondName,this.grade);
    }

}
