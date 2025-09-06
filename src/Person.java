import java.util.Objects;
import java.util.Calendar;
import java.util.Date;

//Need to:
//continue working on product files
//research equals method (lectures, Zoom)
//watch Zoom lecture
//check if you need to create the automatic ID incrementer
//watch JSON, UML, etc. videos
//write JavaDoc
//create comments for any new variables and rewrite how algorithms are described in comments
//remove unused variables
//reread assignment directions from the top

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return YOB == person.YOB && Objects.equals(ID, person.ID) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(title, person.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, firstName, lastName, title, YOB);
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

    public String getAge(int year)
    {
        int selectedYear = 0;
        int age = 0;
        String stringAge = "";
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.YEAR, year);
        selectedYear = calendar.get(Calendar.YEAR);

        age = selectedYear - getYOB();
        stringAge = Integer.toString(age);

        return stringAge;
    }

    public String toCSV()
    {
        String csvRec = "";

        csvRec = getID() + ", " + getFirstName() + ", " + getLastName() + ", " + getTitle() + ", " + getYOB();

        return csvRec;
    }
}