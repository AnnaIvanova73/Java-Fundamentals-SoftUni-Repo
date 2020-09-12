package Lab_6_Students_2_0;

public class Students_2_0 {
    private String firstName;
    private String lastName;
    private int age;



    private String hometown;

    public Students_2_0(String firstName, String lastName, int age, String hometown) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.hometown = hometown;
    }

    public String getHometown() {
        return this.hometown;
    }
    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }
    public void setAge(int age){
        this.age = age;
    }
}
