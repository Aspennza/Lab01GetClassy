import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person person1;

    @BeforeEach
    void setUp() {
        person1 = new Person("000001", "Bilbo", "Baggins", "Esq.", 1940);
    }

    @Test
    void setFirstName() {
        person1.setFirstName("Frodo");
        assertEquals("Frodo", person1.getFirstName());
    }

    @Test
    void setLastName() {
    }

    @Test
    void setTitle() {
    }

    @Test
    void setYOB() {
    }

    @Test
    void testToString() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void fullName() {
    }

    @Test
    void formalName() {
    }

    @Test
    void getAge() {
    }

    @Test
    void testGetAge() {
    }

    @Test
    void toCSV() {
    }

    @Test
    void toJSON() {
    }

    @Test
    void toXML() {
    }
}