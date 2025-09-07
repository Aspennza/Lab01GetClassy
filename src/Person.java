import java.util.Objects;
import java.util.Calendar;

//Need to:
//continue working on product files
//make sure product has all the same stuff as person
//write unit tests
//watch Zoom lectures
//watch JSON, UML, etc. videos
//write JavaDoc
//create comments for any new variables and rewrite how algorithms are described in comments
//remove unused variables
//create UML diagrams for Person, Product, and SafeInputObj
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
                "ID='" + ID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
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
        return firstName + " " + lastName;
    }

    public String formalName()
    {
        return title + " " + firstName + " " + lastName;
    }

    public String getAge()
    {
        int currentYear = 0;
        int age = 0;
        String stringAge = "";
        Calendar calendar = Calendar.getInstance();

        currentYear = calendar.get(Calendar.YEAR);
        age = currentYear - YOB;

        stringAge = Integer.toString(age);

        return stringAge;
    }

    public String getAge(int year)
    {
        int age = 0;
        String stringAge = "";
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.YEAR, year);

        age = calendar.get(Calendar.YEAR) - YOB;
        stringAge = Integer.toString(age);

        return stringAge;
    }

    public String toCSV()
    {
        return ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
    }

    public String toJSON()
    {
        String retString = "";
        char DQ = '\u0022';
        retString = "{" + DQ + "IDNum" + DQ + ":" + DQ + this.ID + DQ + ",";
        retString += " " + DQ + "firstName" + DQ + ":" + DQ + this.firstName + DQ + ",";
        retString += " " + DQ + "lastName" + DQ + ":" + DQ + this.lastName + DQ + ",";
        retString += " " + DQ + "title" + DQ + ":" + DQ + this.title + DQ + ",";
        retString += " " + DQ + "YOB" + DQ + ":" + this.YOB + "}";

        return retString;
    }

    public String toXML()
    {
        String retString = "";
        retString = "<Person>";
        retString += "<IDNum>" + ID + "</IDNum>";
        retString += "<firstName>" + this.firstName + "</firstName>";
        retString += "<lastName>" + this.lastName + "</lastName>";
        retString += "<title>" + this.title + "</title>";
        retString += "<YOB>" + this.YOB + "</YOB></Person>";

        return retString;
    }
}