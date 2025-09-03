import java.util.Objects;
import java.util.Calendar;
import java.util.Date;

//WRITE JAVADOC!!
//RESEARCH EQUALS() OVERRIDE; look at CP II videos, look at Prof's thursday Zoom lecture

public class Person
{
    private String ID;
    private String firstName;
    private String lastName;
    private String title;
    private int YOB;

    public Person(String ID, String firstName, String lastName, String title, int YOB)
    {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    public String getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    //May not need a setter for YOB? I'll decide later.
    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ID='" + ID + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }

    public String fullName()
    {
        String fullName = "";
        fullName = getFirstName() + " " + getLastName();
        return fullName;
    }

    public String formalName()
    {
        String formalName = "";
        formalName = getTitle() + " " + fullName();
        return formalName;
    }

    public String getAge()
    {
        int currentYear = 0;
        int age = 0;
        String stringAge = "";
        Calendar calendar = Calendar.getInstance();

        currentYear = calendar.get(Calendar.YEAR);
        age = currentYear - getYOB();

        stringAge = Integer.toString(age);

        return stringAge;
    }
}