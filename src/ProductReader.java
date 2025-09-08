import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import static java.nio.file.StandardOpenOption.CREATE;
import javax.swing.JFileChooser;

//Need to:
//write javadoc for all programs
//create UML diagrams
//take screenshots

/**
 * Reads input from CSV files containing product data, outputs the data to the console,
 * and inputs it into Product objects for storage.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class ProductReader
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //This is the file chooser that is used to select a file to read
        JFileChooser chooser = new JFileChooser();

        //This File holds the File selected by the user
        File selectedFile;

        //This String holds the line that has just been read from the document selected
        String rec = "";

        //This ArrayList holds every line from the document being read
        ArrayList<String> lines = new ArrayList<>();

        //This ArrayList holds every Product created based on the data read from the file
        ArrayList<Product> products = new ArrayList<>();

        //This array holds the values from each record after they have been split
        String[] fields;

        //This int determines the total number of values that should be found in each record
        final int FIELDS_LENGTH = 4;

        //This String holds the ID of each record read from the chosen text file
        String ID = "";

        //This String holds the name of each record read from the chosen text file
        String name = "";

        //This String holds the description of each record read from the chosen text file
        String description = "";

        //This double holds the cost of each record read from the chosen text file
        double cost = 0.00;

        //This algorithm checks if the file reader has thrown an exception
        try
        {
            System.out.println("Please select a file containing product records to read to the console.");

            //This File holds the current directory
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            //This algorithm checks if the user selected a file, reads each record in the file into the lines ArrayList, splits each record into four fields, prints those values to the console, and creates Product objects to store the data
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                //This int tracks how many lines have been read
                int line = 0;

                //This algorithm reads each line of the selected file into the rec variable, adds each record to the lines ArrayList, and prints each line to the console
                while(reader.ready())
                {
                    rec = reader.readLine();
                    lines.add(rec);
                    line++;

                    System.out.printf("\nLine %-4d %-60s", line, rec);
                }
                reader.close();
                System.out.println("\n\nThe data file has been read.\n");

                System.out.println("ID#     Name          Description              Cost");
                System.out.println("=========================================================");

                //This algorithm splits each record in the lines ArrayList based on comma delimiters, puts the split values into the fields array, trims each value into a variable to be printed to the console, and adds each value to a Product object
                for(String l : lines)
                {
                    fields = l.split(",");

                    //This algorithm checks if the fields array has the correct number of values, trims each value in the fields array into a variable to be printed to the console, and adds each variable to a Product object for storage
                    if(fields.length == FIELDS_LENGTH)
                    {
                        ID = fields[0].trim();
                        name = fields[1].trim();
                        description = fields[2].trim();
                        cost = Double.parseDouble(fields[3].trim());

                        System.out.printf("\n%-8s%-14s%-25s%8f", ID, name, description, cost);

                        Product product = new Product(ID, name, description, cost);
                        products.add(product);
                    }
                    else
                    {
                        System.out.println("One of the records in your file may be corrupted. Please select a different file.");
                        System.out.println(l);
                    }
                }
            }
            else
            {
                System.out.println("No file was selected.");
                System.out.println("Please run this program again to select a file.");
                System.exit(0);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("The file couldn't be found.");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            System.out.println("An exception occurred.");
            e.printStackTrace();
        }
    }
}
