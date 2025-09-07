import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product product1;

    @BeforeEach
    void setUp() {
        product1 = new Product("000001", "Computer", "Computer with mouse and keyboard", 500.00);
    }

    @Test
    void testProductConstructor()
    {
        Product product2 = new Product("000002", "Burger", "Burger with lettuce and tomato", 7.00);
        assertEquals("000002", product2.getID());
        assertEquals("Burger", product2.getName());
        assertEquals("Burger with lettuce and tomato", product2.getDescription());
        assertEquals(7.00, product2.getCost());
    }

    @Test
    void setName() {
        product1.setName("Laptop");
        assertEquals("Laptop", product1.getName());
    }

    @Test
    void setDescription() {
    }

    @Test
    void setCost() {
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
    void toCSV() {
    }

    @Test
    void toJSON() {
    }

    @Test
    void toXML() {
    }
}