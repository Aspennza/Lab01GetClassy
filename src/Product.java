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

import java.util.Objects;

public class Product
{
    private String ID;
    private String name;
    private String description;
    private double cost;

    public Product(String ID, String name, String description, double cost)
    {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(cost, product.cost) == 0 && Objects.equals(ID, product.ID) && Objects.equals(name, product.name) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, description, cost);
    }

    public String toCSV()
    {
        return ID + ", " + name + ", " + description + ", " + cost;
    }

    public String toJSON()
    {
        String retString = "";
        char DQ = '\u0022';
        retString = "{" + DQ + "IDNum" + DQ + ":" + DQ + this.ID + DQ + ",";
        retString += " " + DQ + "name" + DQ + ":" + DQ + this.name + DQ + ",";
        retString += " " + DQ + "description" + DQ + ":" + DQ + this.description + DQ + ",";
        retString += " " + DQ + "cost" + DQ + ":" + this.cost + "}";

        return retString;
    }

    public String toXML()
    {
        String retString = "";
        retString = "<Product>";
        retString += "<IDNum>" + ID + "</IDNum>";
        retString += "<name>" + this.name + "</name>";
        retString += "<description>" + this.description + "</description>";
        retString += "<cost>" + this.cost + "</cost></Product>";

        return retString;
    }
}
