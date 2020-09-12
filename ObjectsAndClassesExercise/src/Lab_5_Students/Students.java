package Lab_5_Students;

public class Students {
    private String firstName;
    private String lastName;
    private int age;
    private String hometown;

    public Students(String firstName,String lastName, int age, String hometown){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.hometown = hometown;
    }
    public String getHometown() {
        return this.hometown;
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


}
