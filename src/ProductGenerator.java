import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

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

public class ProductGenerator
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //This ArrayList holds the total number of product records entered by the user
        ArrayList<Product> products = new ArrayList<>();

        //This Scanner takes all user input
        Scanner in = new Scanner(System.in);

        //This File holds the current directory
        File workingDirectory = new File(System.getProperty("user.dir"));

        //This Path holds the current directory concatenated with the location of the text file that will be created
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestData.txt");

        //This boolean holds the true/false value that determines whether the user is done entering records
        boolean done = false;

        //This String contains the 6-digit ID the user inputs for a product
        String ID = "";

        //This String contains the name the user inputs for a product
        String name = "";

        //This String contains the description the user inputs for a product
        String description = "";

        //This double contains the cost the user inputs for a product
        double cost = 0.00;

        String csv = "";

        //This algorithm takes the user's input to receive an ID, name, description, and cost for a product, concatenates them into a productRec, and adds the record to the products ArrayList, then checks if the user is done entering records
        do {
            ID = SafeInput.getNonZeroLenString(in, "Please enter the ID for your product [6 digits]");
            name = SafeInput.getNonZeroLenString(in, "Please enter the name of your product");
            description = SafeInput.getNonZeroLenString(in, "Please enter a short description of your product");
            cost = SafeInput.getDouble(in, "Please enter the cost of your product [non-negative]");

            Product product = new Product(ID, name, description, cost);
            products.add(product);

            done = SafeInput.getYNConfirm(in, "Have you finished entering products?");
        }while(!done);

        //This algorithm prints each record in the products ArrayList to the console
        for (Product p : products)
        {
            System.out.println();
            System.out.println(p);
        }

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
