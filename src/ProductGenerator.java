import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

//Need to:
//write javadoc for all programs
//create UML diagrams
//take screenshots

/**
 * Creates Product objects containing product data, then writes them to a CSV file.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class ProductGenerator
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //This ArrayList holds the total number of Product objects entered by the user
        ArrayList<Product> products = new ArrayList<>();

        //This Scanner takes all user input
        Scanner in = new Scanner(System.in);

        //This File holds the current directory
        File workingDirectory = new File(System.getProperty("user.dir"));

        //This Path holds the current directory concatenated with the location of the text file that will be created
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestData.txt");

        //This boolean holds the true/false value that determines whether the user is done entering records
        boolean done = false;

        //This String holds the comma-separated version of the data inside each Product object
        String csv = "";

        //This String contains the 6-digit ID the user inputs for a product
        String ID = "";

        //This String contains the name the user inputs for a product
        String name = "";

        //This String contains the description the user inputs for a product
        String description = "";

        //This double contains the cost the user inputs for a product
        double cost = 0.00;

        //This algorithm takes the user's input to receive an ID, name, description, and cost for a product, then adds that data to a Product object
        do {
            ID = SafeInput.getNonZeroLenString(in, "Please enter the ID for your product [6 digits]");
            name = SafeInput.getNonZeroLenString(in, "Please enter the name of your product");
            description = SafeInput.getNonZeroLenString(in, "Please enter a short description of your product");
            cost = SafeInput.getDouble(in, "Please enter the cost of your product [non-negative]");

            Product product = new Product(ID, name, description, cost);
            products.add(product);

            done = SafeInput.getYNConfirm(in, "Have you finished entering products?");
        }while(!done);

        //This algorithm writes each record in the products ArrayList into the ProductTestData.txt file indicated above, then checks for exceptions
        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            //This algorithm writes each record in the products ArrayList into the ProductTestData.txt file indicated above
            for(Product p : products)
            {
                csv = p.toCSV();

                writer.write(csv, 0, csv.length());
                writer.newLine();
            }
            writer.close();
            System.out.println("\nData file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
